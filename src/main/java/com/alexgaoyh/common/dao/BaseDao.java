package com.alexgaoyh.common.dao;

import com.alexgaoyh.common.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

	/**
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	void saveOrUpdate(E entity) throws Exception;
}
