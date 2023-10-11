create database CargaMaterias;
use CargaMaterias;

create table Alumnos(
	NC int not null,
    nombres nvarchar (100) not null,
    apellidos nvarchar (100) not null,
    carrera nvarchar (100) not null,
    correo nvarchar (100) not null,
    telefono nvarchar(10) not null
);

create table Materias(
	id int not null AUTO_INCREMENT,
    nombre nvarchar (50) not null,
    credito int not null,
    primary key (id)
);

create table Cargas(
	NC int not null,
    id_materia int not null,
    horario nvarchar (50)
);

/*Alteracion de tablas*/
alter table alumnos add primary key (NC);

alter table cargas add constraint FK_alumno foreign key (NC) references alumnos (NC);
alter table cargas add constraint FK_materias foreign key (id_materia) references materias (id);

alter table cargas add primary key (NC, id_materia);

INSERT INTO alumnos (NC, nombres, apellidos, carrera, correo, telefono) VALUES
    (16171421, 'jose', 'jostar', 'gestion', 'jojo@gmail.com', '6671550505');

