package com.pizzahut.pizza.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_ITEMS")
public class PizzaItems {
	@Id
	@Column
	Integer id;
	@Column
	String name;
	@Column
	String category;
	@OneToMany(mappedBy = "itemId")
	Set<PizzaPricing> priceList;
	public Set<PizzaPricing> getPriceList() {
		return priceList;
	}
	public void setPriceList(Set<PizzaPricing> priceList) {
		this.priceList = priceList;
	}
	@Override
	public String toString() {
		return "PizzaItems [id=" + id + ", name=" + name + ", category=" + category + ", Descrption=" + Descrption
				+ "]";
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescrption() {
		return Descrption;
	}
	public void setDescrption(String descrption) {
		Descrption = descrption;
	}
	public PizzaItems() {
		super();
	}
	@Column
	String Descrption;
	public PizzaItems(Integer id, String name, String category, String descrption) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		Descrption = descrption;
	}
}
