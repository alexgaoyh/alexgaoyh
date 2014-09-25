package com.alexgaoyh.sysman.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alexgaoyh.common.dao.impl.BaseDaoImpl;
import com.alexgaoyh.sysman.admin.dao.SysmanResourceDao;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理dao接口实现类
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
@Repository
public class SysmanResourceDaoImpl extends BaseDaoImpl<SysmanResource> implements SysmanResourceDao {

	@Override
	public List<SysmanResource> getRootResourceList() {
		String hql = "from " + this.clazz.getName() + "  where deleteFlag=0  and parent is null ";
		return this.getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	

}
