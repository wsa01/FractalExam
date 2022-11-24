CREATE DATABASE IF NOT EXISTS db_fractal;

USE db_fractal;

-- TABLAS

CREATE TABLE IF NOT EXISTS tbl_producto(
    id_producto INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    category VARCHAR(250),
    price DECIMAL(5,2),
    status CHAR(1) -- A= ACTIVE, I=INACTIVE
);

CREATE TABLE IF NOT EXISTS tbl_cliente(
    id_cliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS tbl_pedidos(
    id_pedidos INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_clienteFK INT NOT NULL,
    status CHAR(1), -- P=PENDING, C=COMPLETED, R=REJECTED
    date DATE,
    city_tax DECIMAL(5,2),
    country_tax DECIMAL(5,2),
    state_tax DECIMAL(5,2),
    federal_tax DECIMAL(5,2),
    total DECIMAL(8,2)
);
ALTER TABLE tbl_pedidos ADD FOREIGN KEY (id_clienteFK) REFERENCES tbl_cliente(id_cliente);

CREATE TABLE IF NOT EXISTS tbl_pedidos_detalle(
    id_pedidosPK INT NOT NULL,
    id_productoPK INT NOT NULL,
    cantidad int,
    price_unitario DECIMAL(5,2),
    cost DECIMAL(8,2)
);
ALTER TABLE tbl_pedidos_detalle ADD CONSTRAINT PK_tbl_pedidos_detalle PRIMARY KEY(id_pedidosPK, id_productoPK);
ALTER TABLE tbl_pedidos_detalle ADD FOREIGN KEY (id_pedidosPK) REFERENCES tbl_pedidos(id_pedidos);
ALTER TABLE tbl_pedidos_detalle ADD FOREIGN KEY (id_productoPK) REFERENCES tbl_producto(id_producto);

-- STORE PROCEDURE

DELIMITER $$
CREATE PROCEDURE PRODUCT_LIST()
BEGIN
    SELECT id_producto, name, category, price, status 
    FROM tbl_producto;
END $$

$$
CREATE PROCEDURE PRODUCT_ADD(
    P_name VARCHAR(250),
    P_category VARCHAR(250),
    P_price DECIMAL(5,2),
    P_status CHAR(1) -- A= ACTIVE, I=INACTIVE
)BEGIN
    INSERT INTO tbl_producto(name, category, price, status)
    VALUES(P_name, P_category, P_price, P_status);
END $$

$$
CREATE PROCEDURE PEDIDOS_GET(
)BEGIN
    SELECT  id_pedidos, id_cliente, status, date, total, name
    from tbl_pedidos AS tb1
    LEFT JOIN tbl_cliente AS tb2
    ON tb1.id_clienteFK = tb2.id_cliente
END
$$

$$
CREATE PROCEDURE PEDIDOS_FIND(
    IN P_name VARCHAR(250)
)BEGIN
    SELECT  id_pedidos, id_cliente, status, date, total, name
    from tbl_pedidos AS tb1
    LEFT JOIN tbl_cliente AS tb2
    ON tb1.id_clienteFK = tb2.id_cliente
    WHERE name = P_name;
END
$$

$$
CREATE PROCEDURE PEDIDOS_DET_GET(
    in p_id_pedido int
)BEGIN
    SELECT  name, cantidad, price_unitario, cost
    from tbl_pedidos_detalle AS tb1
    LEFT JOIN tbl_producto AS tb2
    ON tb1.id_productoPK = tb2.id_producto
    WHERE id_pedidosPK=p_id_pedido;
END
$$

DELIMITER ;
