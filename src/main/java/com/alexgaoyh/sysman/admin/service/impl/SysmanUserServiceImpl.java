package com.alexgaoyh.sysman.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.sysman.admin.dao.SysmanUserDao;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.service.SysmanUserService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc 用户后台登陆用户表--RBAC权限管理service接口实现类
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
@Service
public class SysmanUserServiceImpl extends BaseServiceImpl<SysmanUser> implements SysmanUserService {

	@Override
	@Resource(name ="sysmanUserDaoImpl")
	public void setBaseDao(BaseDao<SysmanUser> dao) {
		this.baseDao =  dao;
	}
	
	private SysmanUserDao getDao(){
		return (SysmanUserDao) this.baseDao ;
	}

	@Override
	public SysmanUser findByName(String userName) {
		return this.getDao().findByName(userName);
	}
	


}
