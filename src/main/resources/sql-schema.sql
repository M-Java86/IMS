drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) Null Default Null,
    `cost` Double(5,4) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)

);

CREATE TABLE IF NOT EXISTS `ims`. `order_customer` (
    `id INT(11) NOT NULL AUTO_INCREMENT,
    `client_id INT(11),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customer_id`) REFRENCES `customers`('id')
    
    

);
