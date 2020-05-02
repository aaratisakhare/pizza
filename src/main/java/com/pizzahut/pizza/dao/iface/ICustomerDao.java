package com.pizzahut.pizza.dao.iface;

import com.pizzahut.pizza.model.PizzaCustomers;

public interface ICustomerDao extends IBaseDao<PizzaCustomers, Integer> {
	public PizzaCustomers findByEmail(String username) ;
}
