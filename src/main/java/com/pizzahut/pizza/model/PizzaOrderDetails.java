package com.pizzahut.pizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_OrderDetails")
public class PizzaOrderDetails {
	@Id
	@Column
	Integer id;
	@Column
	Integer orderId;
	@Column
	Integer priceId;
	public PizzaOrderDetails() {
		super();
	}
	public PizzaOrderDetails(Integer id, Integer orderId, Integer priceId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.priceId = priceId;
	}
	@Override
	public String toString() {
		return "PizzaOrderDetails [id=" + id + ", orderId=" + orderId + ", priceId=" + priceId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
}
