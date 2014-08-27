package com.alexgaoyh.admin.login.shiro.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.service.SysmanUserService;


public class ShiroDbRealm extends AuthorizingRealm {
	
	@Resource
	private SysmanUserService sysmanUserService;
	
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysmanUser user = (SysmanUser) principals.fromRealm(getName()).iterator().next();
		user = this.sysmanUserService.get(user.getPid());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<SysmanRole> roles = user.getRoles();
		
		
		Set<String>  permissions = new HashSet<String>();
		
		for(SysmanRole role : roles ){
			info.addRole(role.getName());
			for(SysmanResource resource : role.getResource()){
				if(SysmanResource.TYPE_MENU != resource.getResourceType() ){
					setMenuPerms(permissions, resource.getParent());
					permissions.add(resource.getPid() +":"+resource.getParent().getPid() );
				}
			}
		}
		
		info.addStringPermissions(permissions);
		
		return info;
	}
	
	private void setMenuPerms(Set<String> permissions, SysmanResource resource) {
		permissions.add(resource.getPid()+"");
		if(resource.getParent()!=null){
			setMenuPerms(permissions, resource.getParent());
		}
	}

	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToke = (UsernamePasswordToken)token;
		
		String username = usernamePasswordToke.getUsername();
		
		SysmanUser user  = sysmanUserService.findByName(username);
		
		sysmanUserService.evict(user);
		user.setRoles(null);
		
		if(user==null){
			throw new  UnknownAccountException("用户帐号不存在！");
		}
		
		if(user.getStatus()!=SysmanUser.STATUS_NORMAL){
			throw new  LockedAccountException("用户帐号不正常，请联系系统管理员！");
		}
		
		
		return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getPassword()),getName());
	}

}
