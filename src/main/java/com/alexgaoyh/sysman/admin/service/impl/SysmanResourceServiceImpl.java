package com.alexgaoyh.sysman.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.sysman.admin.dao.SysmanResourceDao;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.service.SysmanResourceService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理service接口实现类
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
@Service
public class SysmanResourceServiceImpl extends BaseServiceImpl<SysmanResource> implements SysmanResourceService {

	@Override
	@Resource(name ="sysmanResourceDaoImpl")
	public void setBaseDao(BaseDao<SysmanResource> dao) {
		this.baseDao =  dao;
	}
	
	private SysmanResourceDao getDao(){
		return (SysmanResourceDao) this.baseDao ;
	}

	@Override
	public List<SysmanResource> getRootResourceList() {
		return this.getDao().getRootResourceList();
	}
	


}
