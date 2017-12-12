
CREATE DATABASE forex_db;
ALTER DATABASE forex_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE forex_db;

CREATE TABLE customer
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    name TEXT,
    age INT(11),
    account TEXT,
    password TEXT,
    email TEXT,
    primary key (id)
);
CREATE TABLE news
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    type VARCHAR(100),
    title VARCHAR(100),
    source VARCHAR(100),
    content TEXT,
    imageUrl VARCHAR(100),
    time VARCHAR(50),
    primary key (id)
);
CREATE TABLE sys_config
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    sys_key VARCHAR(50),
    sys_value VARCHAR(100),
    create_time DATETIME,
    note VARCHAR(50),
    primary key (id)
);
CREATE TABLE trading_order
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    currency VARCHAR(10),
    type VARCHAR(10),
    lots FLOAT,
    profit_pips FLOAT,
    open_price DECIMAL(10,5),
    open_time DATETIME,
    close_price DECIMAL(10,5) COMMENT '最低盈利价, 相当于止损',
    close_time DATETIME,
    trading_id VARCHAR(20),
    trading_platform VARCHAR(10),
    primary key (id)
);
CREATE TABLE trading_price
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    ask_price DECIMAL(10,5),
    bid_price DECIMAL(10,5) COMMENT ' 最少盈利价,相当于止损价',
    platform VARCHAR(20),
    create_time DATETIME,
    currency VARCHAR(10),
    order_id INT(11),
    profit_price DECIMAL(10,5) COMMENT '盈利价格',
    primary key (id)
);
CREATE TABLE trading_signal
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    platform VARCHAR(20),
    user_name VARCHAR(50),
    currency VARCHAR(10),
    price DECIMAL(10,5),
    profit_price DECIMAL(10,5) COMMENT '盈利价格',
    loss_price DECIMAL(10,5) COMMENT '止损价格',
    create_time DATETIME,
    order_id INT(11) COMMENT '根据信号下单的id',
    type VARCHAR(10),
    primary key (id)
);
CREATE UNIQUE INDEX table_name_id_uindex ON customer (id);
CREATE INDEX order_id_index ON trading_price (order_id);

############    设置系统配置    #################

INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (1, 'trade.profit', '0.5', null, '交易获利点数');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (2, 'open.trade.time', '2', null, '获取第三方交易订单的时间范围');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (3, 'trade.loss', '-1', null, '交易亏损点数');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (4, 'trade.max.loss', '-1', null, '最大亏损点数');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (5, 'trade.move.loss', '0.2', null, '止损每次移动点数');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (6, 'trade.move.trigger', '0.4', null, '触发止损位置的获利金额');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (7, 'trade.open.threshold', '0.0001', null, '与前一个蜡烛图价格的阈值');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (8, 'trade.min.profit', '-0.5', null, '最大盈利金额');
INSERT INTO forex_db.sys_config (id, sys_key, sys_value, create_time, note) VALUES (9, 'trade.min.profit.trigger', '0', null, '设置最小盈利金额的触发点');

