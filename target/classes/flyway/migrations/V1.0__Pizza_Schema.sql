DROP DATABASE IF EXISTS pizza;
CREATE DATABASE IF NOT EXISTS  pizza;
USE  pizza;

DROP TABLE IF EXISTS individual_order_status;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS price_per_pizza;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS pizza;


CREATE TABLE pizza (
    pizza_pk int unsigned NOT NULL AUTO_INCREMENT,
    pizza_id varchar(45) NOT NULL,
    pizza_size enum ('SMALL', 'MEIDUM', 'LARGE'),
    pizza_type enum ('CHEESE', 'BARBQUE','ALFERDO'),
     PRIMARY KEY (pizza_pk),
     UNIQUE KEY (pizza_id, pizza_size, pizza_type)
);

CREATE TABLE customers (
    customer_pk int unsigned NOT NULL AUTO_INCREMENT,
    address_fk int unsigned NOT NULL,
    customer_id varchar(40) NOT NULL,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    phone varchar(20) NOT NULL,
     PRIMARY KEY (customer_pk)
    );

  CREATE TABLE address (
 	address_pk int unsigned NOT NULL AUTO_INCREMENT,
  	customer_fk int unsigned NOT NULL,
  	deilvery_address varchar(150) NOT NULL,
  	 PRIMARY KEY (address_pk),
  	 FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
  );

CREATE TABLE price_per_pizza (
	price_per_pizza_pk int unsigned NOT NULL AUTO_INCREMENT,
    pizza_fk int unsigned NOT NULL,
  	price_per_pizza decimal(6, 2) NOT NULL,
     PRIMARY KEY (price_per_pizza_pk),
     FOREIGN KEY (pizza_fk) REFERENCES pizza (pizza_pk) ON DELETE CASCADE
);

CREATE TABLE order_items (
	order_item_pk int unsigned NOT NULL AUTO_INCREMENT,
    pizza_fk int unsigned NOT NULL,
    price_per_pizza_fk int unsigned NOT NULL,
    quantity int unsigned NOT NULL,
     PRIMARY KEY (order_item_pk),
     FOREIGN KEY (pizza_fk) REFERENCES pizza (pizza_pk) ON DELETE CASCADE,
     FOREIGN KEY (price_per_pizza_fk) REFERENCES price_per_pizza (price_per_pizza_pk) ON DELETE CASCADE
);

CREATE TABLE orders (
	order_pk int unsigned NOT NULL AUTO_INCREMENT,
    order_item_fk int unsigned NOT NULL,
    customer_fk int unsigned NOT NULL,
    order_total decimal(6, 2) NOT NULL,
     PRIMARY KEY (order_pk),
     FOREIGN KEY (order_item_fk) REFERENCES order_items (order_item_pk) ON DELETE CASCADE,
     FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);

CREATE TABLE individual_order_status (
	order_status_pk int unsigned NOT NULL AUTO_INCREMENT,
	order_fk int unsigned NOT NULL,
    customer_fk int unsigned NOT NULL,
    order_status enum('ORDER RECEIVED','BAKING IN OVEN', 'PACKED', 'SHIPPED'),
    shipping_status enum ('PRE-TRANSIT', 'IN-TRANSIT', 'OUT FOR DELIVERY', 'DELIVERED'),
     PRIMARY KEY (order_status_pk),
     FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE,
     FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);

