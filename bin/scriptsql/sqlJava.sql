create database if not exists universidad_bd;
use universidad_bd;

create table if not exists usuario (
documento varchar(11) not null,  
nombre varchar(80) not null,
profesion varchar(200) not null,
edad int(3) not null,
direccion varchar(200) not null,
telefono varchar(10) not null
) engine=InnoDB default charset=latin1;