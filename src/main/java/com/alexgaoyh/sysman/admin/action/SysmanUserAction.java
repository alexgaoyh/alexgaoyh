package com.alexgaoyh.sysman.admin.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class SysmanUserAction  {

	private static final Logger LOGGER = Logger.getLogger(SysmanUser.class);
	
	@Resource
	private SysmanUserService sysmanUserService;

}
