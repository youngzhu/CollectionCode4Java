CREATE TABLE `tbl_order` (
  `order_id` char(32) NOT NULL COMMENT '订单ID',
  `customer_id` char(32) NOT NULL COMMENT '客户ID',
  `product_id` char(32) NOT NULL COMMENT '产品ID',
  `order_date` datetime DEFAULT NULL COMMENT '下单时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`order_id`,`customer_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
