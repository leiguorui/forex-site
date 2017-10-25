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

