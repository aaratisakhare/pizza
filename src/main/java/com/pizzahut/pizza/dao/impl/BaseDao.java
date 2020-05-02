package com.pizzahut.pizza.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pizzahut.pizza.dao.HbUtil;
import com.pizzahut.pizza.dao.iface.IBaseDao;

public abstract class BaseDao<T,K extends Serializable> implements IBaseDao<T,K>{
	
	//private SessionFactory em;
	
	private final Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	protected SessionFactory getSessionFactory() {
		return HbUtil.getSessionFactory();
	}
	
	public T findById(K k) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			return session.get(entityClass, k);
		}finally {
			session.close();
		}
	}

	public List<T> findAll() {
		Session session = getSessionFactory().getCurrentSession();
		try {
			HbUtil.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(entityClass);
			Root<T> table =  criteria.from(entityClass);
			criteria.select(table);
			TypedQuery<T> q = session.createQuery(criteria);
			HbUtil.commitTransaction();
			return q.getResultList();
		}catch (Exception e) {
			HbUtil.rollbackTransaction();
			return null;
		}finally {
			session.close();
		}
	}

	public T save(T t) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.save(t);
			return t;
		}finally {
			session.close();
		}
	}

	public void update(T t) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.update(t);
		}finally {
			session.close();
		}
	}

	public void delete(T t) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			session.delete(t);
		}finally {
			session.close();
		}
	}

	public void deleteById(K k) {
		Session session = getSessionFactory().getCurrentSession();
		try {
			HbUtil.beginTransaction();
			Query query = session.createQuery("delete from "+ entityClass.getName()  +" where id = :uid");
			query.setParameter("uid", k);
			query.executeUpdate();
			HbUtil.commitTransaction();
			//T t = findById(k);
			//session.remove(t);
		}catch (Exception e) {
			HbUtil.rollbackTransaction();
		}finally {
			session.close();
		}
	}
}
