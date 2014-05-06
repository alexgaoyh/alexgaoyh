package com.alexgaoyh.common.service;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.entity.BaseEntity;

public interface BaseService<E extends BaseEntity> {
	
	
	BaseDao<E> getBaseDao();
	
	void setBaseDao(BaseDao<E> dao);

	/**
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	void saveOrUpdate(E entity) throws Exception;
}
