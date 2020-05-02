package com.pizzahut.pizza.services;

import com.pizzahut.pizza.dao.impl.CustomerDao;

public class LoginService {
	CustomerDao dao = new CustomerDao();
	
	public boolean authenticate(String email, String password) {
		if(dao.findByEmail(email)!=null){
			return true;	//TODO
		}
		return false;
	}
}
