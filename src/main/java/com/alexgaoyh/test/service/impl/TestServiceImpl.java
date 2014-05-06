package com.alexgaoyh.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;
import com.alexgaoyh.test.entity.TestEntity;
import com.alexgaoyh.test.service.TestService;

@Service
public class TestServiceImpl  extends BaseServiceImpl<TestEntity> implements TestService{

	@Override
	@Resource
	public void setBaseDao(BaseDao<TestEntity> dao) {
		this.baseDao =  dao;
	}
}
