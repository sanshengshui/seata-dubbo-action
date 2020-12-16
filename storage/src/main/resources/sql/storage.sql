# 创建商品库存表
create table if not exists storage.tcc_storage
(
    id bigint auto_increment
        primary key,
    commodity_code varchar(50) null comment '商品编码',
    name varchar(255) null comment '商品名称',
    count int null comment '商品库存数',
    frozen_count int default 0 null comment '冻结商品库存数'
);

INSERT INTO storage.tcc_storage (id, commodity_code, name, count) VALUES (1, 'cola', '可口可乐', 2000);

# 新建undo_log表
create table if not exists storage.undo_log
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

