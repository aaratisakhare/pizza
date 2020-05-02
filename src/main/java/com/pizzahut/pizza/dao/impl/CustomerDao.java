package com.pizzahut.pizza.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pizzahut.pizza.dao.HbUtil;
import com.pizzahut.pizza.dao.iface.ICustomerDao;
import com.pizzahut.pizza.model.PizzaCustomers;

public class CustomerDao extends BaseDao<PizzaCustomers, Integer> implements ICustomerDao{
	public PizzaCustomers findByEmail(String username) {
		Session session = getSessionFactory().getCurrentSession();
		String hql = "from PizzaCustomers c where c.email=:p_name";
		try {
			HbUtil.beginTransaction();
			 Query<PizzaCustomers> query = session.createQuery(hql);
			 query.setParameter("p_name", username);
			 List<PizzaCustomers> list = query.getResultList();
			 HbUtil.commitTransaction();
			 if(list != null) return list.get(0);
		}catch (Exception e) {
			HbUtil.rollbackTransaction();
		}finally {
			session.close();
		}
		return null;
	}
}
