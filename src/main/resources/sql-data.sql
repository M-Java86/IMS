INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`. `customers`(`first_name`, `surname`) VALUES ('raquel', 'hardy');
INSERT INTO `ims`. `customers`(`first_name`, `surname`) VALUES ('rodeny', 'jennings');

INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('shoe', 89.99);
INSERT INTO `ims`.`items` (`item_name`, `price`) VALUES ('magazine', 12.99);
INSERT INTO `ims`. `items`(`item_name`, `price`) VALUES ('toy truck', 1.99);

INSERT INTO `ims`.`order_customer`(`customer_id`) VALUES (1);
INSERT INTO `ims`.`order_customer`(`customer_id`) VALUES (1);

INSERT INTO `ims`.`order_products` (`id`, `item_id`, `quantity`) VALUES (1,1,1);
INSERT INTO `ims`.`order_products`(`id`, `item_id`, `quantity`) VALUES(1,2,4);

INSERT INTO `ims`.`order_products`(`id`,`item_id`, `quantity`) Values (2,3,1);

INSERT INTO `ims`. `accounts` (`user_name`, `password`, `is_loggin`) VALUES ('root', 'root', true);
INSERT INTO `ims`. `accounts` (`user_name`, `password`, `is_loggin`) VALUES ('another root', 'another root', fasle);

 