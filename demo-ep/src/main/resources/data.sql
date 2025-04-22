--CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

insert into categorias (short_name, description) values ( 'Drinks', 'All kinf of liquids');
insert into categorias (short_name, description) values ( 'Candies', 'Sweets, candies and chocolate');
insert into categorias (short_name, description) values ('Vegetables', 'Fruit and fresh vegetables');




insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Tea - Apple Green Tea', 736.78, 10, 5.5, 1);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Juice - Apple, 341 Ml', 698.45, 10, 5.5, 1);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ('Water - Spring Water, 355 Ml', 625.18, 10, 5.5,1);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Chocolate - Milk Coating', 326.17, 10, 5.5, 2);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ('Onions - Green', 94.2, 10, 5.5, 3);