CREATE TABLE customer
(
    id INT(11) PRIMARY KEY NOT NULL,
    name TEXT,
    age INT(11),
    account TEXT,
    password TEXT,
    email TEXT
);
CREATE UNIQUE INDEX table_name_id_uindex ON CUSTOMER (id);


CREATE TABLE news
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type VARCHAR(100),
    title VARCHAR(100),
    source VARCHAR(100),
    content TEXT,
    imageUrl VARCHAR(100),
    time VARCHAR(50)
);

CREATE TABLE trading_order
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    currency VARCHAR(10),
    type VARCHAR(10),
    lots FLOAT,
    profit_pips FLOAT,
    open_price DECIMAL(10,5),
    open_time DATETIME,
    close_price DECIMAL(10,5),
    close_time DATETIME,
    trading_id VARCHAR(20),
    trading_platform VARCHAR(10)
);

CREATE TABLE trading_signal
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
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