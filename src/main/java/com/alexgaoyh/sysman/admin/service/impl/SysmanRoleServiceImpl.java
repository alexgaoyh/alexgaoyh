package com.alexgaoyh.sysman.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.sysman.admin.dao.SysmanRoleDao;
import com.alexgaoyh.sysman.admin.entity.SysmanRole;
import com.alexgaoyh.sysman.admin.service.SysmanRoleService;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc 用户后台登陆用户角色表--RBAC权限管理service接口实现类
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:27:52 CST 2014
 */
@Service
public class SysmanRoleServiceImpl extends BaseServiceImpl<SysmanRole> implements SysmanRoleService {

	@Override
	@Resource(name ="sysmanRoleDaoImpl")
	public void setBaseDao(BaseDao<SysmanRole> dao) {
		this.baseDao =  dao;
	}
	
	private SysmanRoleDao getDao(){
		return (SysmanRoleDao) this.baseDao ;
	}
	


}
