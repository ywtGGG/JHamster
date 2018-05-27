CREATE TABLE `character_recharge_record` (
  `character_id` int(11) NOT NULL COMMENT '角色id',
  `character_name` varchar(255) NOT NULL COMMENT '角色姓名',
  `recharge_money` int(11) DEFAULT NULL COMMENT '充值金额',
  `gain_dj` int(11) DEFAULT NULL COMMENT '已领取的点卷',
  PRIMARY KEY (`character_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8