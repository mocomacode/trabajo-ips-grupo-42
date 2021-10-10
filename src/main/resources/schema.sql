--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Competicion;
create table Competicion (
	id int primary key not null, 
	nombreCarrera varchar(255) not null,
	tipoCarrera varchar(255) not null,
	distancia varchar(255) not null,
	cuota dobule not null,
	fecha date not null, 
	fechaInicio date not null, 
	fechaFin date not null, 
	plazas int not null,
	estadoCarrera varchar(255) not null,
	check(inicio<=fin), 
	check(fin<fecha)
);

drop table Atleta;
create table Atleta (
	dni varchar(255) primary key not null,
	email varchar(255) unique not null,
	nombreAtleta varchar(255) not null,
	fechaNacimiento date not null, 
	sexo varchar(255) not null
);

drop table Inscripcion;
create table Inscripcion (
	idCompeticion varchar(255) not null,
	dniAtleta varchar(255) not null,
	categoria varchar(255) not null,
	fechaInscripcion date not null,
	estadoInscripcion varchar(255) not null,
	fechaCambioEstado date not null,
	posicion int,
	double tiempo,
	
	primary key(idCompeticion,dniAtleta),
	foreign key(idCompeticion) references Competicion(id),
	foreign key(dniAtleta) references Atleta(dni)
);

