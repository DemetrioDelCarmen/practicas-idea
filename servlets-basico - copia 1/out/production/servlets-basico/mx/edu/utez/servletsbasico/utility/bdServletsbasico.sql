create database directivos;
use directivos;

create table Rol(
	idRol int auto_increment,
    nombre varchar(20),
    primary key(idRol)
);
create table Usuario(
	idUsuario int auto_increment primary key,
    usuario varchar(20) not null,
    contrasena varchar(20) not null,
    rol int,
    constraint fk_rol_usuario
    foreign key(rol) references Rol(idRol)
);