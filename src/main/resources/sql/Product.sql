CREATE TABLE `tbl_product` (
  `id` char(32) NOT NULL COMMENT '产品ID',
  `price` double DEFAULT NULL COMMENT '产品价格',
  `description` varchar(500) DEFAULT NULL COMMENT '产品描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
