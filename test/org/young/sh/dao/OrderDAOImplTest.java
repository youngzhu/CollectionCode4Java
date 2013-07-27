package org.young.sh.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.young.db.DB;
import org.young.hibernate.dao.IOrderDAO;
import org.young.hibernate.entity.Order;
import org.young.hibernate.entity.OrderId;

public class OrderDAOImplTest extends DefaultDAOTest {
	
	private IOrderDAO orderDAO;

	@Test
	public void testAdd() {
		
		// 构建数据
		Order order = new Order();
		
		OrderId id = new OrderId();
		
		String customerId = DB.generateUniqueKey(32);
		String productId = DB.generateUniqueKey(32);
		String orderId = DB.generateUniqueKey(32);
		
		id.setCustomerId(customerId);
		id.setProductId(productId);
		id.setOrderId(orderId);
		order.setId(id);
		
		order.setOrderDate(new Date());
		order.setRemark("TEST!!");
		
		// 向数据库中添加数据
		orderDAO.add(order);
		
		logger.info("add order: " + order);
		
		// 验证
		/*
		 * CREATE TABLE `tbl_order` (
  `order_id` varchar(32) NOT NULL,
  `customer_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `order_date` datetime DEFAULT NULL COMMENT '下单时间',
  `remark` longtext COMMENT '备注',
  PRIMARY KEY (`order_id`,`customer_id`,`product_id`)
		 */
		String sql = "SELECT COUNT(1) AS NUM_OF_ORDER FROM TBL_ORDER T WHERE ORDER_ID=? AND CUSTOMER_ID=? AND PRODUCT_ID=?";
		List<Object> args = new ArrayList<Object>();
		args.add(orderId);
		args.add(customerId);
		args.add(productId);
		
		int count = getJdbcTemplate().queryForInt(sql, args.toArray());
		// 数据中应该有且只有1条数据
		assertEquals(1, count);
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

}
