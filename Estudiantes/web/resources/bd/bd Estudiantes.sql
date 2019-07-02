create database estudiantes;
use estudiantes;

create table calificacion (
matricula VARCHAR(11),
nombre VARCHAR(50),
apellidos VARCHAR(50),
asignatura VARCHAR(50),
calificacion INT,
PRIMARY KEY(matricula)
);

