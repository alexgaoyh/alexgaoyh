package com.alexgaoyh.common.service.impl;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.entity.BaseEntity;
import com.alexgaoyh.common.service.BaseService;

public class BaseServiceImpl <E extends BaseEntity> implements BaseService<E>{
	
	protected BaseDao<E> baseDao;

	@Override
	public BaseDao<E> getBaseDao() {
		// TODO Auto-generated method stub
		return this.baseDao;
	}
	
	@Override
	public void setBaseDao(BaseDao<E> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void saveOrUpdate(E entity) throws Exception {
		this.getBaseDao().saveOrUpdate(entity);
	}


}
