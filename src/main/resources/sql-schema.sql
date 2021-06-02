drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;
DROP TABLE IF EXISTS 'customers';
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `items`
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) Null Default Null,
    `cost` Double(5,4) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)

);

CREATE TABLE IF NOT EXISTS `ims`. `order_customer` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer`_id INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`)
    
    

);

CREATE TABLE IF NOT EXISTS `ims`. 'accounts' (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(40) NULL DEFAULT NULL,
    `password` VARCHAR(40) NULL DEFAULT NULL,
    `is_loggin` Boolean NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);




