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
	
	@Override
	public int hashCode() {
		return id.getCustomerId().hashCode() 
				+ id.getProductId().hashCode() 
				+ id.getOrderId().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (! (obj instanceof Order)) {
			return false;
		}
		
		Order order = (Order) obj;
		
		return order.getId().getCustomerId().equals(this.getId().getCustomerId())
				&& order.getId().getOrderId().equals(this.getId().getOrderId())
				&& order.getId().getProductId().equals(this.getId().getProductId());
	}
	
	@Override
	public String toString() {
		return "orderId=" + this.getId().getOrderId()
					+ " | customerId=" + this.getId().getCustomerId()
					+ " | productId=" + this.getId().getProductId();
	}
}
