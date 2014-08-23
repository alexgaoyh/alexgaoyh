package com.alexgaoyh.common.dao;

import java.util.List;

import com.alexgaoyh.common.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

	/**
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	void saveOrUpdate(E entity) throws Exception;
	
	
	List<E> getAll(String orderBy);
	
	List<E> getAll();
	
	E queryForObject(String hql, Object[] parameters);
	
	E get(String pid);
	
	void evict(Object entity);
}
