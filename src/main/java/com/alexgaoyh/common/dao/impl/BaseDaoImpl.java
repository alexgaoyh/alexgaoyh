package com.alexgaoyh.common.dao.impl;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.entity.BaseEntity;
import com.alexgaoyh.util.GenericUtil;

public class BaseDaoImpl<E extends BaseEntity> extends HibernateTemplate implements BaseDao<E> {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	protected Class<E> clazz;

	@Override
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		try {
			clazz = GenericUtil.getActualClass(this.getClass(), 0);
		} catch (Exception e) {
			log.error("base dao can not get  clazz!", e);
		}
	}

	@Override
	public void saveOrUpdate(E entity) throws Exception {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	
	@Override
	public List<E> getAll(String orderBy) {
		if (orderBy == null) {
			orderBy = " createTime ";
		}
		String hql = "from " + this.clazz.getName() + "  where deleteFlag=0  order by " + orderBy;
		return this.getSessionFactory().getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<E> getAll() {
		String hql = "from " + this.clazz.getName() + "  where deleteFlag=0  order by createTime" ;
		return this.getSessionFactory().getCurrentSession().createQuery(hql).list();
	}

	@Override
	public E queryForObject(String hql, Object[] parameters) {
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (parameters != null) {
			for (int i = 0, len = parameters.length; i < len; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return (E) query.uniqueResult();
	}

	@Override
	public E get(Integer pid) {
		return (E) this.getSessionFactory().getCurrentSession().get(this.clazz, pid);
	}

}
