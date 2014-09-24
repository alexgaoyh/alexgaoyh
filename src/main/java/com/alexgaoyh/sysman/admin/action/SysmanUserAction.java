package com.alexgaoyh.sysman.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.service.SysmanRoleService;

/**
 * 
 * @desc 用户后台登陆用户表--RBAC权限管理action控制类
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
@Controller
@RequestMapping(value="admin/sysmanUser")
public class SysmanUserAction extends BaseController<SysmanUser>  {

	private static final Logger LOGGER = Logger.getLogger(SysmanUser.class);
	
	@Override
	@Resource(name = "sysmanUserServiceImpl")
	public void setBaseService(BaseService<SysmanUser> baseService) {
		this.baseService = baseService;
	}
	
	
	@Resource(name = "sysmanRoleServiceImpl")
	private SysmanRoleService sysmanRoleService;
	
	/**
	 * 重写list方法，在进入list页面的时候，将sysmanRoleList 加载到页面中
	 */
	@Override
	public ModelAndView list(ModelAndView model) {
		List<SysmanRole> sysmanRoleList = sysmanRoleService.getAll();
		model.addObject("sysmanRoleList", sysmanRoleList);
		return super.list(model);
	}
	
	@Override
	protected void beforeDoSave(HttpServletRequest request, SysmanUser entity) throws Exception {
		//加密密码
		Md5Hash md5Hash = new Md5Hash("admin");
		entity.setPassword(md5Hash.toHex());
		
		loadEntityRoles(request, entity);
		
		super.beforeDoSave(request, entity);
	}
	
	@Override
	protected void beforeDoUpdate(HttpServletRequest request, SysmanUser entity) throws Exception {
		//加密密码
		Md5Hash md5Hash = new Md5Hash("admin");
		entity.setPassword(md5Hash.toHex());
				
		loadEntityRoles(request, entity);
		super.beforeDoUpdate(request, entity);
	}
	
	/**
	 * 向实体对象加载关联关系（用户包含的角色信息）
	 * @param request 请求参数
	 * @param entity form表单提交的实体对象
	 */
	private void loadEntityRoles(HttpServletRequest request, SysmanUser entity) {
		String relRolePids = request.getParameter("relRolePids");
		if(relRolePids != null && !relRolePids.equals("")) {
			String[] idArr = relRolePids.split(",");
			
			List<SysmanRole> list = new ArrayList<SysmanRole>();
			for(String id : idArr){
				SysmanRole _role = new SysmanRole();
				_role.setPid(Integer.parseInt(id));
				list.add(_role);
			}
			
			entity.setRoles(list);
		}
	}
	
}
