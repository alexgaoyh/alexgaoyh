package com.alexgaoyh.sysman.admin.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
	
}
