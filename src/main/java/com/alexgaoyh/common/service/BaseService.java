package com.alexgaoyh.common.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.entity.BaseEntity;
import com.alexgaoyh.common.util.Pagination;

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

	Pagination<E> getPageData(DetachedCriteria condition, int page, int rows);
	
	/**
	 * 保存 entity
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	void save(E entity) throws Exception;
	
	void update(E entity) throws Exception;
	
	
}
