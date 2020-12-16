# 创建用户账户表
create table if not exists tcc_account
(
	id bigint auto_increment
		primary key,
	user_id varchar(50) null comment '用户编号',
	amount double(50,2) null comment '账号余额',
	frozen_amount double(50,2) default 0.00 null comment '账号冻结余额'
);

INSERT INTO account.tcc_account (id, user_id, amount) VALUES (1, 'user123', 1250);

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

