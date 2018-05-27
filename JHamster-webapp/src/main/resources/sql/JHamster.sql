CREATE TABLE `orders` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `uid` int(11) NOT NULL,
  `ref_order_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '外部单号',
  `subject` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '订单标题',
  `goods_type` tinyint(4) NOT NULL COMMENT '商品类型 0-虚拟商品  1-真实商品',
  `word_server` tinyint(4) DEFAULT NULL COMMENT '世界服务器 1-hytn冒险岛',
  `character_id` int(11) DEFAULT NULL COMMENT '角色id',
  `character_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名字',
  `total_amount` decimal(12,2) NOT NULL COMMENT '订单金额',
  `receipt_amount` decimal(12,2) DEFAULT NULL COMMENT '实际收款金额',
  `pay_type` tinyint(4) NOT NULL COMMENT '支付方式',
  `status` tinyint(4) NOT NULL COMMENT '状态 0-等待付款  1-支付成功  2-支付失败',
  `remark` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_ref` (`ref_order_id`) USING HASH,
  KEY `idx_status` (`status`) USING BTREE,
  KEY `idx_character_id` (`character_id`) USING BTREE,
  KEY `idx_uid` (`uid`) USING BTREE,
  KEY `idx_pay_type` (`pay_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '账号',
  `passwd` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `user_name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `admin_flag` tinyint(4) DEFAULT NULL COMMENT '管理员标识',
  `mobile` int(13) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '头像路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `last_login_ip` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '最后一次登录ip',
  PRIMARY KEY (`id`),
  KEY `idx_account` (`account`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `system_config` (
  `id` int(11) NOT NULL,
  `key` varchar(32) NOT NULL COMMENT '配置名称',
  `value` varchar(128) NOT NULL COMMENT '配置值',
  `status` tinyint(4) NOT NULL COMMENT '状态 0-关闭  1-开启',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_key` (`key`) USING BTREE,
  KEY `idx_status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


CREATE TABLE `rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '规则名称',
  `key` varchar(64) NOT NULL COMMENT '规则key',
  `triggering` int(11) DEFAULT NULL COMMENT '触发条件',
  `award` int(11) DEFAULT NULL COMMENT '奖励值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_key` (`key`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;