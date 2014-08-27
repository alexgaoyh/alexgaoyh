package com.alexgaoyh.common.service;

import java.util.List;

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
	
	List<E> getAll(String orderBy);
	
	List<E> getAll();
	
	E get(Integer pid);
	
	void evict(Object entity);
	
	
}
