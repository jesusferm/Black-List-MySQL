create database bdlistanegra;
use bdlistanegra;

create table usuarios(
	id int auto_increment,
	nick varchar(89),
	passwd varchar(480),
	nombre varchar(40),
	apellidos varchar(30),
	image longblob,
	primary key(id)
);

create table listanegra(
	id int auto_increment,
	iduser int,
	nombre varchar(90),
	razon varchar(190),
	edad int,
	primary key(id),
	foreign key(iduser) references usuarios(id) on update cascade on delete restrict
);

create table fechas_importantes(
	id_fecha int auto_increment,
	id_user int,
	tipo_fecha varchar(90),
	descripcion varchar(180),
	fecha varchar(30),
	primary key(id_fecha),
	foreign key(id_user) references usuarios(id) on update cascade on delete cascade
);
