package org.young.hibernate.entity;

import java.util.Date;

/**
 * 订单
 *
 * @author by Young.ZHU
 *		on 2013-1-29
 *
 * Package&FileName: org.young.hibernate.entity.Order
 */
public class Order {

	private OrderId id; // 订单ID-联合主键
	
	private Date orderDate; // 下单时间
	
	private String remark; // 备注

	public OrderId getId() {
		return id;
	}

	public void setId(OrderId id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
