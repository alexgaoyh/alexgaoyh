package com.alexgaoyh.sysman.admin.service;

import java.util.List;

import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理service接口
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
public interface SysmanResourceService extends BaseService<SysmanResource> {

	List<SysmanResource> getRootResourceList();
}
