package com.alexgaoyh.sysman.admin.util;

import java.util.List;

import org.springframework.web.context.ContextLoader;

import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.service.SysmanUserService;

public class SysmanUserServiceUtil {
	
	private static SysmanUserService sysmanUserService;

	public static SysmanUserService getService() {

		if (sysmanUserService == null) {

			synchronized (SysmanUserServiceUtil.class) {

				if (sysmanUserService == null) {

					sysmanUserService = ContextLoader
							.getCurrentWebApplicationContext().getBean(
									SysmanUserService.class);

				}
			}
		}

		return sysmanUserService;

	}
	
	public static List<SysmanUser>  getAll(){
		return getService().getAll() ;
	}
	
	public static SysmanUser findByName(String username){
		return getService().findByName(username);
	}
}
