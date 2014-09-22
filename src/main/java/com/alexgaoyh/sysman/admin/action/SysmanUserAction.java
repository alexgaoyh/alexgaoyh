package com.alexgaoyh.sysman.admin.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.service.SysmanUserService;

/**
 * 
 * @desc 用户后台登陆用户表--RBAC权限管理action控制类
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
@Controller
@RequestMapping(value="sysmanUser")
public class SysmanUserAction extends BaseController<SysmanUser>  {

	private static final Logger LOGGER = Logger.getLogger(SysmanUser.class);
	
	@Override
	@Resource(name = "sysmanUserServiceImpl")
	public void setBaseService(BaseService<SysmanUser> baseService) {
		this.baseService = baseService;
	}
	
}
