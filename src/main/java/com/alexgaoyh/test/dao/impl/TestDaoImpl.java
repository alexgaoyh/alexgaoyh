package com.alexgaoyh.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.alexgaoyh.common.dao.impl.BaseDaoImpl;
import com.alexgaoyh.test.dao.TestDao;
import com.alexgaoyh.test.entity.TestEntity;

@Repository
public class TestDaoImpl extends BaseDaoImpl<TestEntity> implements TestDao{

}
