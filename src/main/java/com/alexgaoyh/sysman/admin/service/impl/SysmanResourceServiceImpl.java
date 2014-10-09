package com.alexgaoyh.sysman.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;
import com.alexgaoyh.sysman.admin.dao.SysmanResourceDao;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.service.SysmanResourceService;

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
	
	@Override
	public void update(SysmanResource entity) throws Exception {
		
		checkErrorMove(entity ,  entity.getParent().getPid());
		
		super.update(entity);
	}

	/**
	 * update操作，移动错误时抛出异常信息
	 * @param entity
	 * @param parentId
	 */
	private void checkErrorMove(SysmanResource entity, Integer parentId) {
		if( entity.getPid() == parentId ){
			throw new RuntimeException("父级知识点不能是自己！");
		}else{
			if(entity != null && entity.getSubResource() != null){
				for(SysmanResource kk : entity.getSubResource()){
					
					if( parentId == kk.getPid() ){
						throw new RuntimeException("父级知识点不能是自己的子知识点！");
					}else{
						checkErrorMove(kk,parentId);
					}
				}
			}
		}
	}
	
	
	
}
