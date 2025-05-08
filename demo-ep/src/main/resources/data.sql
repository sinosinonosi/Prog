-- Crear la tabla categorias (si no existe)
CREATE TABLE IF NOT EXISTS categorias (
                                          id INT PRIMARY KEY AUTO_INCREMENT,
                                          short_name VARCHAR(255),
    description VARCHAR(255)
    );

-- Crear la tabla productos (si no existe)
CREATE TABLE IF NOT EXISTS productos (
                                         id INT PRIMARY KEY AUTO_INCREMENT,
                                         nombre VARCHAR(255),
    precio DECIMAL(10, 2),
    cantidad INT,
    coste_fabricacion DECIMAL(10, 2),
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
    );

-- Insertar los datos en categorias
insert into categorias (short_name, description) values ( 'fruits', 'fruits');
insert into categorias (short_name, description) values ( 'drinks', 'drinks');
insert into categorias (short_name, description) values ( 'meet', 'meet');
insert into categorias (short_name, description) values ( 'fish', 'fish');

-- Insertar los datos en productos
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Chicken - Base', 973.79, 10, 8.99, 1);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Appetizer - Spring Roll, Veg', 565.83, 1, 5.99, 1);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Wine - Blue Nun Qualitatswein', 56.28, 5 ,10.00, 2);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Marjoram - Dried, Rubbed', 793.63, 1, 2.00, 3);
insert into productos (nombre, precio, cantidad, coste_fabricacion, categoria_id) values ( 'Flour - Semolina', 68.65, 2, 3.99, 1);
