package com.pizzahut.pizza.dao.iface;

import java.util.List;

public interface IBaseDao<T,K> {
	
	public T findById(K k);
	
	public List<T> findAll();
	
	public T save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public void deleteById(K k);
	
}
