package com.alexgaoyh.sysman.admin.dao;

import java.util.List;

import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.common.dao.BaseDao;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理dao接口
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
public interface SysmanResourceDao extends BaseDao<SysmanResource> {
	
	List<SysmanResource> getRootResourceList();
}
