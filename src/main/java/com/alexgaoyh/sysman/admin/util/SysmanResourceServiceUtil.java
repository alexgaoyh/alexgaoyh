package com.alexgaoyh.sysman.admin.util;

import java.util.List;

import org.springframework.web.context.ContextLoader;

import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.service.SysmanResourceService;

public class SysmanResourceServiceUtil {
	
	private static SysmanResourceService sysmanResourceService;

	public static SysmanResourceService getService() {

		if (sysmanResourceService == null) {

			synchronized (SysmanResourceServiceUtil.class) {

				if (sysmanResourceService == null) {

					sysmanResourceService = ContextLoader
							.getCurrentWebApplicationContext().getBean(
									SysmanResourceService.class);

				}
			}
		}

		return sysmanResourceService;

	}
	
	public static List<SysmanResource>  getAll(){
		return getService().getAll() ;
	}
}
