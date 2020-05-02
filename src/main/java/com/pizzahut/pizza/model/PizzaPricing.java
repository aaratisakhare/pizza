package com.pizzahut.pizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_PRICING")
public class PizzaPricing {
	@Id
	@Column
	Integer id;
	@Column
	Integer itemId;
	@Column
	Sizes sizes;
	@Column
	Double price;
	@Override
	public String toString() {
		return "PizzaPricing [id=" + id + ", itemId=" + itemId + ", sizes=" + sizes + ", price=" + price + "]";
	}
	public PizzaPricing() {
		super();
	}
	public PizzaPricing(Integer id, Sizes sizes, Double price) {
		super();
		this.id = id;
		this.sizes = sizes;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Sizes getSizes() {
		return sizes;
	}
	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
