package com.alexgaoyh.sysman.admin.service;

import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.common.service.BaseService;

/**
 * 
 * @desc 用户后台登陆用户表--RBAC权限管理service接口
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
public interface SysmanUserService extends BaseService<SysmanUser> {

	SysmanUser findByName(String userName);
}
