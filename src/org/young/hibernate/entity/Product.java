package org.young.hibernate.entity;

/**
 * 产品
 *
 * @author by Young.ZHU
 *		on 2013-1-29
 *
 * Package&FileName: org.young.hibernate.entity.Product
 */
public class Product {

	private String id; // 产品ID
	
	private double price; // 产品价格
	
	private String description; // 产品描述

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
