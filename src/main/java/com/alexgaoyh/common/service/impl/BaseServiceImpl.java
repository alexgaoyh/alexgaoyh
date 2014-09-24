package com.alexgaoyh.common.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.entity.BaseEntity;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.common.util.Pagination;

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
	public E get(Integer pid) {
		return this.getBaseDao().get(pid);
	}

	@Override
	public void evict(Object entity) {
		this.getBaseDao().evict(entity);
		
	}

	@Override
	public Pagination<E> getPageData(DetachedCriteria condition, int page, int rows) {
		Pagination<E> pagination = new Pagination<E>(page, rows);
		
		int total = this.getBaseDao().getRowCountByDetachedCriteria(condition);
		pagination.setTotalCount(total);
		
		condition.setProjection(null);

		if (total != 0) {
			List<E> datas = this.getBaseDao().findByDetachedCriteria(condition, page, rows);
			
			pagination.setDatas(datas);
		}
		return pagination;
	}

	@Override
	public void save(E entity) throws Exception {
		this.getBaseDao().save(entity);
	}

	@Override
	public void update(E entity) throws Exception {
		this.getBaseDao().update(entity);
	}

	@Override
	public void deleteLogicByIds(String[] pidArray) throws Exception {
		this.getBaseDao().deleteLogicByIds(pidArray);
	}


}
