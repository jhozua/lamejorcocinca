DROP TABLE IF EXISTS detalle_factura CASCADE;
DROP TABLE IF EXISTS factura CASCADE;
DROP TABLE IF EXISTS cocinero CASCADE;
DROP TABLE IF EXISTS camarero CASCADE;
DROP TABLE IF EXISTS cliente CASCADE;
DROP TABLE IF EXISTS mesa CASCADE;

CREATE TABLE mesa (
	id_mesa serial NOT NULL,
	num_max_comensales int4 NOT NULL,
	ubicacion int4 NOT NULL,
	CONSTRAINT mesa_pk PRIMARY KEY (id_mesa)
);

CREATE TABLE cliente (
	id_cliente serial NOT NULL,
	nombre varchar(30) NOT NULL,
	apellido_1 varchar(30) NOT NULL,
	apellido_2 varchar(30) NULL,
	observaciones text NULL,
	CONSTRAINT cliente_pk PRIMARY KEY (id_cliente)
);

CREATE TABLE camarero (
	id_camarero serial NOT NULL,
	nombre varchar(30) NOT NULL,
	apellido_1 varchar(30) NOT NULL,
	apellido_2 varchar(30) NULL,
	CONSTRAINT camarero_pk PRIMARY KEY (id_camarero)
);

CREATE TABLE cocinero (
	id_cocinero serial NOT NULL,
	nombre varchar(30) NOT NULL,
	apellido_1 varchar(30) NOT NULL,
	apellido_2 varchar(30) NULL,
	CONSTRAINT cocinero_pk PRIMARY KEY (id_cocinero)
);

CREATE TABLE factura (
	id_factura serial NOT NULL,
	id_cliente int NOT NULL,
	id_camarero int NOT NULL,
	id_mesa int NOT NULL,
	fecha_factura date NOT NULL,
	CONSTRAINT factura_pk PRIMARY KEY (id_factura),
	CONSTRAINT factura_camarero_fk FOREIGN KEY (id_camarero) REFERENCES camarero(id_camarero),
	CONSTRAINT factura_cliente_fk FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
	CONSTRAINT factura_mesa_fk FOREIGN KEY (id_mesa) REFERENCES mesa(id_mesa)
);

CREATE TABLE detalle_factura (
	id_factura int,
	id_detalle_factura serial NOT NULL,
	id_cocinero int NOT NULL,
	plato varchar(30) NOT NULL,
	importe numeric(7) NULL,
	CONSTRAINT detalle_factura_pk PRIMARY KEY (id_factura, id_detalle_factura),
	CONSTRAINT detalle_factura_cocinero_fk FOREIGN KEY (id_cocinero) REFERENCES cocinero(id_cocinero),
	CONSTRAINT detalle_factura_factura_fk FOREIGN KEY (id_factura) REFERENCES factura(id_factura)
);

INSERT INTO camarero(nombre, apellido_1)values
('Karen', 'Sanchez'),
('Mahe', 'Nery'),
('Nelson', 'Penagos'),
('Jonnathan', 'Corredor');

INSERT INTO cocinero(nombre, apellido_1)values
('Natalia', 'Sanabria'), 
('Kate', 'Villamil'), 
('Fabian', 'Rocha'), 
('Alexander', 'Romero');

INSERT INTO mesa(num_max_comensales, ubicacion)values
(3, 1), 
(4, 2), 
(10, 3), 
(2, 4);

INSERT INTO cliente(nombre, apellido_1, observaciones)values
('Adriana', 'Magalaes', 'Todo excelente'), 
('Claudia', 'Rodrigez', 'Muy rico todo'), 
('Jessica', 'Vargas', 'Delicioso'), 
('Diego', 'Trujillo', 'Muy bueno');

INSERT INTO factura(id_cliente, id_camarero, id_mesa, fecha_factura)values
(1, 2, 1, '2019-03-10'), 
(2, 2, 2, '2019-03-11'), 
(3, 2, 3, '2019-03-12'), 
(4, 3, 4, '2019-03-13');

INSERT INTO detalle_factura(id_factura, id_cocinero, plato, importe)values
(1, 1, 'Salmon', 31000), 
(1, 1, 'Punta de Anca', 32000), 
(2, 2, 'Mixta con Langostinos', 33000), 
(2, 2, 'Solomito Sterling', 34000), 
(3, 3, 'Encocado de Pargo frito', 35000), 
(3, 3, 'Cerdo en Tamarindo', 36000), 
(4, 4, 'Pescado en salsa de Camarones', 37000), 
(4, 4, 'Trucha al Ajillo', 38000);