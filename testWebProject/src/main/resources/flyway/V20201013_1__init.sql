create table categories(
    category_id serial not null,
    category_name varchar(255),
    category_description text,
    primary key(category_id)
);

create table products(
product_id serial not null,
product_name varchar(255),
category_id serial,
unit_price int,
description text,
company_id serial,
production_date date,
expire_date date,
volume float,
barcode int8,
primary key(product_id)
);


alter table products add constraint fk1  foreign key(category_id) references categories(category_id);

create table customer(
customer_id serial not null,
customer_name varchar(255),
customer_email varchar(255),
customer_phone varchar(255),
customer_login varchar(255),
customer_password varchar(255),
primary key(customer_id)
);


create table auth(
id serial not null,
login varchar(255),
password varchar(255),
token varchar(255),
customer_id serial not null
);


create unique index auth_token_uindex
	on auth (token);



CREATE TABLE public.order_item
(
    order_item_id serial NOT NULL,
    product_id int8 NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    quantity integer NOT NULL,
    price int8 NOT NULL,
    order_id serial NOT NULL,
    CONSTRAINT order_item_pkey PRIMARY KEY (order_item_id)
);


create table orders(
	order_id serial not null,
	total_price int8,
	customer_id serial not null,
	order_date timestamp,
	status VARCHAR(255) NOT NULL,
	delivery_id serial not null,
	primary key(order_id)
);


alter table order_item add constraint fk_order_id  foreign key(order_id) references orders(order_id);
