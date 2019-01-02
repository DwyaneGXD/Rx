-- 类目
CREATE TABLE IF NOT EXISTS `product_category` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR (64) NOT NULL COMMENT '类目名字',
    `type` INT(5) NOT NULL COMMENT '类目编号',
    `created_at` DATETIME(3) DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_at` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`),
    unique key `uqe_type` (`type`)
);
INSERT INTO `product_category` (`id`, `name`, `type`, `created_at`, `updated_at`)
VALUES
	(1,'热榜',11,'2017-03-28 16:40:22','2017-11-26 23:39:36'),
	(2,'好吃的',22,'2017-03-14 17:38:46','2017-11-26 23:39:40');

-- 商品
create table `product_info` (
    `id` varchar(32) not null,
    `name` varchar(64) not null comment '商品名称',
    `price` decimal(8,2) not null comment '单价',
    `stock` int not null comment '库存',
    `description` varchar(64) comment '描述',
    `icon` varchar(512) comment '小图',
    `status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    `category_type` int not null comment '类目编号',
    `created_at` timestamp not null default current_timestamp comment '创建时间',
    `updated_at` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
);
INSERT INTO `product_info` (`id`, `name`, `price`, `stock`, `description`, `icon`, `status`, `category_type`, `created_at`, `updated_at`)
VALUES
	('157875196366160022','皮蛋粥',0.01,39,'好吃的皮蛋粥','//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg',0,1,'2017-03-28 19:39:15','2017-07-02 11:45:44'),
	('157875227953464068','慕斯蛋糕',10.90,200,'美味爽口','//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg',1,1,'2017-03-28 19:35:54','2017-04-21 10:05:57'),
	('164103465734242707','蜜汁鸡翅',0.02,982,'好吃','//fuss10.elemecdn.com/7/4a/f307f56216b03f067155aec8b124ejpeg.jpeg',0,1,'2017-03-30 17:11:56','2017-06-24 19:20:54');

-- 订单
create table `order_master` (
    `id` varchar(32) not null,
    `name` varchar(32) not null comment '买家名字',
    `phone` varchar(32) not null comment '买家电话',
    `address` varchar(128) not null comment '买家地址',
    `openid` varchar(64) not null comment '买家微信openid',
    `amount` decimal(8,2) not null comment '订单总金额',
    `status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态, 默认未支付',
    `created_at` timestamp not null default current_timestamp comment '创建时间',
    `updated_at` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`),
    key `idx_openid` (`openid`)
);

-- 订单商品
create table `order_detail` (
    `id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment '商品名称',
    `product_price` decimal(8,2) not null comment '当前价格,单位分',
    `product_quantity` int not null comment '数量',
    `product_icon` varchar(512) comment '小图',
    `created_at` timestamp not null default current_timestamp comment '创建时间',
    `updated_at` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`),
    key `idx_order_id` (`order_id`)
);

-- 用户
CREATE TABLE `user_info` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT '',
  `password` varchar(32) DEFAULT '',
  `openid` varchar(64) DEFAULT '' COMMENT '微信openid',
  `role` tinyint(1) NOT NULL COMMENT '1买家2卖家',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
);