CREATE TABLE user(
    `id` BigInt(20) Unsigned not null auto_increment,
    `user_name` varchar(50) not null,
    `first_name` varchar(50) not null,
    `last_name` varchar(50) not null,
    `email_address` varchar(50) not null,
    `role` varchar(50) not null,
    `ssn` varchar(50) not null unique,
    `address` varchar(100) ,
    `password` varchar(100) not null,
    primary key(`id`)
);

CREATE TABLE orders(
    `orderid` BigInt(20) Unsigned not null auto_increment,
    `orderdescription` varchar(100),
    `user_id` BigInt(20) not null,
    primary key(`orderid`)
);