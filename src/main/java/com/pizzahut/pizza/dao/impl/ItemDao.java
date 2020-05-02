package com.pizzahut.pizza.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pizzahut.pizza.dao.HbUtil;
import com.pizzahut.pizza.dao.iface.IItemsDao;
import com.pizzahut.pizza.model.PizzaItems;

public class ItemDao extends BaseDao<PizzaItems, Integer> implements IItemsDao {	
	public List<String> getItemCategories() {
		Session session = getSessionFactory().getCurrentSession();
		String hql = "select distinct Type from PizzaItems ";
		try {
			 HbUtil.beginTransaction();
			 Query<String> query = session.createQuery(hql, String.class);
			 List<String> list = query.getResultList();
			 HbUtil.commitTransaction();
			 if(list != null) return list;
		}catch (Exception e) {
			HbUtil.rollbackTransaction();
		}finally {
			session.close();
		}
		return null;
	}
	public List<PizzaItems> getItemCategories(String type) {
		Session session = getSessionFactory().getCurrentSession();
		String hql = "from PizzaItems i where i.type=:p_type";
		try {
			 HbUtil.beginTransaction();
			 Query<PizzaItems> query = session.createQuery(hql);
			 query.setParameter("p_type", type);
			 List<PizzaItems> list = query.getResultList();
			 HbUtil.commitTransaction();
			 if(list != null) return list;
		}catch (Exception e) {
			HbUtil.rollbackTransaction();
		}finally {
			session.close();
		}
		return null;
	}
}
