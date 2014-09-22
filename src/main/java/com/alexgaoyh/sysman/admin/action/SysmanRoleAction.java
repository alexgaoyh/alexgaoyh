package com.alexgaoyh.sysman.admin.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.service.SysmanRoleService;

/**
 * 
 * @desc 用户后台登陆用户角色表--RBAC权限管理action控制类
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:27:52 CST 2014
 */
@Controller
@RequestMapping(value="admin/sysmanRole")
public class SysmanRoleAction extends BaseController<SysmanRole> {

	private static final Logger LOGGER = Logger.getLogger(SysmanRole.class);
	
	@Override
	@Resource(name = "sysmanRoleServiceImpl")
	public void setBaseService(BaseService<SysmanRole> baseService) {
		this.baseService = baseService;
	}
	

}
