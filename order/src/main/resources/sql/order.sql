#创建 订单表
create table if not exists `order`.`order`
(
    id bigint auto_increment
        primary key,
    order_no varchar(100) null comment '订单号',
    user_id varchar(50) null comment '用户编号',
    code varchar(100) null comment '商品编码',
    count int null comment '商品数量',
    amount double(50,2) null comment '消费总金额'
);



#创建undo_log表
create table if not exists undo_log
(
	id bigint auto_increment
		primary key,
	branch_id bigint not null,
	xid varchar(100) not null,
	context varchar(128) not null,
	rollback_info longblob not null,
	log_status int not null,
	log_created datetime not null,
	log_modified datetime not null,
	ext varchar(100) null,
	constraint ux_undo_log
		unique (xid, branch_id)
)
charset=utf8;
