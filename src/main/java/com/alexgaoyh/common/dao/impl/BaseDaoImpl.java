package com.alexgaoyh.common.dao.impl;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.entity.BaseEntity;

public class BaseDaoImpl<E extends BaseEntity> extends HibernateTemplate implements BaseDao<E> {
	
	@Override
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public void saveOrUpdate(E entity) throws Exception {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

}
