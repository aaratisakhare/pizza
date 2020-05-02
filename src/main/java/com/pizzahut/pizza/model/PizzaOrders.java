package com.pizzahut.pizza.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "PIZZA_ORDERS")
public class PizzaOrders {
	@Id
	@Column
	Integer id;
	@Column
	Integer customerId;
	@Column
	Date orderTime;
	@Column
	String status;
	@OneToMany(mappedBy = "orderId")
	Set<PizzaOrderDetails> orderDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<PizzaOrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<PizzaOrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public PizzaOrders() {
		super();
	}
	public PizzaOrders(Integer id, Integer customerId, Date orderTime, String status,
			Set<PizzaOrderDetails> orderDetails) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.orderTime = orderTime;
		this.status = status;
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "PizzaOrders [id=" + id + ", customerId=" + customerId + ", orderTime=" + orderTime + ", status="
				+ status + ", orderDetails=" + orderDetails + "]";
	}
}
