CREATE TABLE customer
(
    id INT(11) NOT NULL,
    name TEXT,
    age INT(11),
    account TEXT,
    password TEXT,
    email TEXT
);
CREATE TABLE news
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    type VARCHAR(100),
    title VARCHAR(100),
    source VARCHAR(100),
    content TEXT,
    imageUrl VARCHAR(100),
    time VARCHAR(50)
);
CREATE TABLE sys_config
(
    id INT(11) NOT NULL AUTO_INCREMENT,
    sys_key VARCHAR(50),
    sys_value VARCHAR(100),
    create_time DATETIME,
    note VARCHAR(50)
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
    trading_platform VARCHAR(10)
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
    profit_price DECIMAL(10,5) COMMENT '盈利价格'
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
    type VARCHAR(10)
);
CREATE UNIQUE INDEX table_name_id_uindex ON customer (id);
CREATE INDEX order_id_index ON trading_price (order_id);