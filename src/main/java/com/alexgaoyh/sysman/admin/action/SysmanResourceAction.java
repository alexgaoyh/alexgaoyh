package com.alexgaoyh.sysman.admin.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.service.SysmanResourceService;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理action控制类
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
@Controller
@RequestMapping(value="sysmanResource")
public class SysmanResourceAction  {

	private static final Logger LOGGER = Logger.getLogger(SysmanResource.class);
	
	@Resource
	private SysmanResourceService sysmanResourceService;

}
