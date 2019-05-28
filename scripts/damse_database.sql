create database damse;

use damse;

create table cliente(
  cliente_id int unsigned auto_increment,
  codigo varchar(20) unique not null,
  dni char(8) not null,
  contraseña varchar(30) not null,
  nombre varchar(30) not null,
  apellidos varchar(30) not null,
  creado datetime not null default now(),
  modificado datetime null on update now(),
  edad int(3) unsigned not null,
  genero char(1) not null check(sexo in ('M', 'F')),
  direccion varchar(80),
  correo varchar(80) unique,
  telefono varchar(15),
  celular varchar(10),
  profile_url varchar(80),
  estado tinyint(1) not null default 1,
  primary key(cliente_id)
);

create table empresa(
  empresa_id int unsigned auto_increment,
  codigo varchar(20) unique not null,
  ruc varchar(11) not null,
  contraseña varchar(30) not null,
  nombre varchar(30) not null,
  creado datetime not null default now(),
  modificado datetime null on update now(),
  direccion varchar(80),
  correo varchar(80) unique,
  telefono varchar(15),
  celular varchar(10),
  profile_url varchar(80),
  estado tinyint(1) not null default 1,
  primary key(empresa_id)
);

create table admin(
  admin_id int unsigned auto_increment,
  codigo varchar(20) unique not null,
  dni char(8) not null,
  contraseña varchar(30) not null,
  nombre varchar(30) not null,
  creado datetime not null default now(),
  modificado datetime null on update now(),
  direccion varchar(80),
  correo varchar(80) unique not null,
  telefono varchar(15),
  celular varchar(10),
  profile_url varchar(80),
  estado tinyint(1) not null default 1,
  primary key(admin_id)
);

create table sesion_usuario(
  sesion_id int unsigned auto_increment,
  codigo_usuario varchar(20) not null,
  creado datetime not null default now(),
  modificado datetime null on update now(),
  primary key(sesion_id),
);

create table factura(
  factura_id int unsigned auto_increment,
  codigo_usuario varchar(20) not null,
  creado datetime not null default now(),
  modificado datetime null on update now(),
  primary key(factura_id)
);

create table facturaDetalle(
  factura_id int,
  material_id int,
  cantidad int not null,
  primary key(factura_id, material_id)
);

create table material(
  material_id int unsigned auto_increment,
  codigo_usuario varchar(20) not null,
  nombre varchar(20) not null,
  descripcion varchar(150) not null,
  precio_venta decimal(4, 2) not null,
  tipo varchar(10) not null,
  estado varchar(10) not null,
  material_img varchar(80),
  creado datetime not null default now(),
  modificado datetime null on update now(),
  primary key(material_id)
);

create table reporte(
  reporte_id int unsigned auto_increment,
  codigo_usuario varchar(20) not null,
  reporte_url varchar(50) not null,
  nombre varchar(20) not null,
  extension char(5) not null check(extension in ('xml', 'txt', 'csv')),
  creado datetime not null default now(),
  modificado datetime null on update now(),
  primary key(reporte_id)
);
