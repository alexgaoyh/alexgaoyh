package com.alexgaoyh.sysman.admin.dao;

import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.common.dao.BaseDao;

/**
 * 
 * @desc 用户后台登陆用户表--RBAC权限管理dao接口
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
public interface SysmanUserDao extends BaseDao<SysmanUser> {
	
	SysmanUser findByName(String userName);
}
