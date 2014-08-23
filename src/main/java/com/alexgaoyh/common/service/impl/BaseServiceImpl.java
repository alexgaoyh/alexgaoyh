package com.alexgaoyh.common.service.impl;

import java.util.List;

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

	@Override
	public List<E> getAll(String orderBy) {
		return this.getBaseDao().getAll(orderBy);
	}

	@Override
	public List<E> getAll() {
		return this.getBaseDao().getAll();
	}

	@Override
	public E get(String pid) {
		return this.getBaseDao().get(pid);
	}

	@Override
	public void evict(Object entity) {
		this.getBaseDao().evict(entity);
		
	}


}
