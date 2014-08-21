package com.alexgaoyh.sysman.admin.dao.impl;

import org.springframework.stereotype.Repository;

import com.alexgaoyh.common.dao.impl.BaseDaoImpl;
import com.alexgaoyh.sysman.admin.dao.SysmanUserDao;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;

/**
 * 
 * @desc 用户后台登陆用户表--RBAC权限管理dao接口实现类
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
@Repository
public class SysmanUserDaoImpl extends BaseDaoImpl<SysmanUser> implements SysmanUserDao {

	@Override
	public SysmanUser findByName(String userName) {
		String hql = "from "+ this.clazz.getName() + " where username = ? and deleteFlag=0" ;
		return this.queryForObject(hql, new Object[]{userName});
	}
	

}
