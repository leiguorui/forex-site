CREATE TABLE CUSTOMER
(
    id INT(11) PRIMARY KEY NOT NULL,
    name TEXT,
    age INT(11),
    account TEXT,
    password TEXT,
    email TEXT
);
CREATE UNIQUE INDEX table_name_id_uindex ON CUSTOMER (id);

