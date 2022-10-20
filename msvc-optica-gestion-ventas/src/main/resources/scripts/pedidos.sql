create database db_msvc_optica_gestion_ventas;
use db_msvc_optica_gestion_ventas;

/*tabla maestro*/
create table maestros(
                         id_maestro	 			varchar (36)  primary key not null,
                         correlativo				int not null,
                         prefijo					int not null,
                         descripcion				varchar (255) not null,
                         estado 					int not null,
                         usuario_creacion 		varchar(36) not null,
                         fecha_creacion 			datetime not null,
                         usuario_modificacion 	varchar(36),
                         fecha_modificacion 		datetime
);

/*tabla ventas*/
create table ventas(
                       id_venta 				varchar (36)  primary key not null,
                       id_producto 			varchar (36) not null,
                       id_cliente 				varchar (36) not null,
                       id_estado_venta			varchar (36) not null,
                       cantidad				int not null,
                       precio_total			decimal (4,2) not null,
                       estado 					int not null,
                       usuario_creacion 		varchar (36) not null,
                       fecha_creación 			datetime not null,
                       usuario_modificacion 	varchar (36),
                       fecha_modificacion 		datetime
);

/*tabla proceso*/
create table procesos(
                         id_proceso 				varchar (36)  primary key not null,
                         id_venta 				varchar (36) not null,
                         id_momento 				varchar (36) not null,
                         id_estado_proceso		varchar (36) not null,
                         comentario				varchar (360),
                         fecha_proceso			datetime not null,
                         estado 					int not null,
                         usuario_creacion 		varchar (36) not null,
                         fecha_creación 			datetime not null,
                         usuario_modificacion 	varchar (36),
                         fecha_modificacion 		datetime
);












