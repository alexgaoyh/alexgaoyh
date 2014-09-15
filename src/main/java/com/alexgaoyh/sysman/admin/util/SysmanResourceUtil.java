package com.alexgaoyh.sysman.admin.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;

public class SysmanResourceUtil {

	/**
	 * 根据SysmanUser获取这个用户下所包含的权限，只取 父节点 部分为空的SysmanResource
	 * @param user
	 * @return
	 */
	public static List<SysmanResource> getResourceListByUser(SysmanUser user){
		
		List<SysmanResource> resultList = new ArrayList<SysmanResource>();
		
		Set<SysmanResource> _temp = new HashSet<SysmanResource>();
		
		List<SysmanRole> sysmanRoleList = user.getRoles();
		for(SysmanRole sRole : sysmanRoleList){
			for(SysmanResource sResource : sRole.getResource()){
				if(sResource.getParent() == null && sResource.getResourceType() == SysmanResource.TYPE_MENU){
					_temp.add(sResource);
				}
			}
		}
		resultList.addAll(_temp);
		return resultList;
	}
}
