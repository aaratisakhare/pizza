package com.pizzahut.pizza.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_CUSTOMERS")
public class PizzaCustomers {
	@Id
	@Column
	Integer id;
	@Column
	String name;
	@Column
	String password;
	@Column
	String email;
	@Column
	String address;
	@Column
	String mobile;
	public PizzaCustomers() {
		super();
	}
	public PizzaCustomers(Integer id, String name, String password, String email, String address, String phone,
			Set<PizzaOrders> orderList) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.mobile = phone;
		this.orderList = orderList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return mobile;
	}
	public void setPhone(String phone) {
		this.mobile = phone;
	}
	public Set<PizzaOrders> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<PizzaOrders> orderList) {
		this.orderList = orderList;
	}
	@Override
	public String toString() {
		return "PizzaCustomers [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", phone=" + mobile + ", orderList=" + orderList + "]";
	}
	@OneToMany(mappedBy = "customerId")
	Set<PizzaOrders> orderList;
}
