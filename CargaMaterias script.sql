create database CargaMaterias;
/*drop database CargaMaterias;*/
use CargaMaterias;

create table Alumnos(
	NC int not null,
    nombres nvarchar (100) not null,
    apellidos nvarchar (100) not null,
    carrera nvarchar (100) not null,
    correo nvarchar (100) not null,
    telefono nvarchar(10) not null,
    activo int not null
);

create table Materias(
	id int not null AUTO_INCREMENT,
    nombre nvarchar (50) not null,
    dias nvarchar (50) not null,
    credito int not null,
    activo int not null,
    primary key (id)
);

create table Cargas(
	id int not null AUTO_INCREMENT,
	NC int not null,
    id_materia int not null,
    horario nvarchar (50),
    primary key (id)
);

/*Alteracion de tablas*/
alter table alumnos add primary key (NC);

alter table cargas add constraint FK_alumno foreign key (NC) references alumnos (NC);
alter table cargas add constraint FK_materias foreign key (id_materia) references materias (id);

/*alter table cargas add primary key (NC, id_materia);
drop table cargas*/

INSERT INTO alumnos (NC, nombres, apellidos, carrera, correo, telefono, activo) VALUES
    (16171419, 'jose', 'jostar', 'gestion', 'jojo@gmail.com', '6671550505', 1);
    
INSERT INTO materias (nombre, dias, credito, activo) VALUES
    ("Calculo", 'Lun - Juev', 30, 1);

INSERT INTO cargas (NC, id_materia, horario) VALUES
    (16171419, 2, "10:00-11:00");

INSERT INTO cargas (NC, id_materia, horario) VALUES
    (16171419, 3, "11:00-12:00"); 

INSERT INTO cargas (NC, id_materia, horario) VALUES
    (16171419, 4, "12:00-13:00");

select DISTINCT * from cargas where NC = 16171419;

SELECT m.*
FROM materias m
LEFT JOIN cargas c ON m.id = c.id_materia AND c.NC = 16171419
WHERE c.id_materia is NULL and m.activo = 1


