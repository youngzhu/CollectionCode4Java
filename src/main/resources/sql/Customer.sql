CREATE TABLE `tbl_customer` (
  `id` char(32) NOT NULL COMMENT 'ID',
  `gender` char(1) DEFAULT '0' COMMENT '性别：0-女 1-男',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
