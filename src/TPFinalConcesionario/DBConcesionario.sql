CREATE DATABASE concesionario;
USE concesionario;

CREATE TABLE VEHICULOS
(
	id_vehiculo int not null auto_increment,
    marca varchar(50),
    modelo varchar(50),
    tipo varchar(50),
    precio decimal(10,2),
    disponible bool,
    cant_puertas int,
    combustible varchar(50),
    capacidad_carga int,
    cant_ejes int,
    tipo_trabajo varchar(50),
    cant_asientos int,
    
    constraint pk_vehiculos primary key(id_vehiculo)    
);

CREATE TABLE CLIENTES
(
	id_cliente int not null auto_increment,
    dni int,
    nombre varchar(50),
    apellido varchar(50),
    contacto varchar(50),
    
    constraint pk_clientes primary key(id_cliente)	
);

CREATE TABLE VENDEDORES
(
	id_vendedor int not null auto_increment,
    legajo int,
    nombre varchar(50),
    apellido varchar(50),
    
    constraint pk_vendedores primary key(id_vendedor)	
);

CREATE TABLE TRANSACCIONES
(
	id_transaccion int not null auto_increment,
    id_cliente int,
    id_vendedor int,
    id_vehiculo int,
    fecha date,
    tipo varchar(50),
    
    constraint pk_transacciones primary key(id_transaccion),
    constraint fk_transacciones_clientes foreign key(id_cliente)
		references clientes(id_cliente),
	constraint fk_transacciones_vendedores foreign key(id_vendedor)
		references vendedores(id_vendedor),
	constraint fk_transacciones_vehiculos foreign key(id_vehiculo)
		references vehiculos(id_vehiculo)
);

/*select * from vehiculos;*/
insert into vehiculos (id_vehiculo, marca, modelo, tipo, precio, disponible, cant_puertas, combustible)
values (id_vehiculo, 'Volkswagen', 'CrossFox', 'Auto', 2000000, 1, 5, 'Nafta');
insert into vehiculos (id_vehiculo, marca, modelo, tipo, precio, disponible, cant_puertas, combustible)
values (id_vehiculo, 'Ford', 'EcoSport', 'Auto', 3500000, 0, 5, 'Nafta');
insert into vehiculos (id_vehiculo, marca, modelo, tipo, precio, disponible, cant_puertas, combustible)
values (id_vehiculo, 'Toyota', 'Corolla', 'Auto', 5000000, 0, 5, 'Nafta');
insert into vehiculos (id_vehiculo, marca, modelo, tipo, precio, disponible, capacidad_carga, cant_ejes)
values (id_vehiculo, 'Mercedes-Benz', 'Actros 2548', 'Camion', 188000, 1, 13, 3);
insert into vehiculos (id_vehiculo, marca, modelo, tipo, precio, disponible, tipo_trabajo, cant_asientos)
values (id_vehiculo, 'Peugeot', 'Partner', 'Utilitario', 3100000, 1, 'Mudanzas', 2);

/*select * from clientes;*/
insert into clientes values (id_cliente, 11222333, 'Lionel', 'Messi', '3511231212');
insert into clientes values (id_cliente, 33111222, 'Samuel', 'de Luque', 'samuel@gmail.com');

/*select * from vendedores;*/
insert into vendedores values (id_vendedor, 113826, 'Luciano', 'Manzanelli');
insert into vendedores values (id_vendedor, 254879, 'Guillermo', 'Diaz');

/*select * from transacciones;*/
insert into transacciones (id_transaccion, id_cliente, id_vendedor, id_vehiculo, fecha, tipo)
values (id_transaccion, 1, 1, 1, '2023-05-06', 'Venta');
insert into transacciones (id_transaccion, id_cliente, id_vendedor, id_vehiculo, fecha, tipo)
values (id_transaccion, 2, 2, 2, '2023-05-07', 'Venta');
