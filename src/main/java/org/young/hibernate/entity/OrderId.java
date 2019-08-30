package org.young.hibernate.entity;

import java.io.Serializable;

public class OrderId implements Serializable {

	private static final long serialVersionUID = -2104360136579926818L;

	private String orderId; // 订单编号
	
	private String customerId; // 客户编号
	
	private String productId; // 产品编号

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
}
