create database db_msvc_optica_gestion_promociones;
use db_msvc_optica_gestion_promociones;

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

/*tabla promociones*/
create table promociones(
	id_promocion 			varchar (36)  primary key not null,
    id_tipo					varchar (36) not null,
	descuento 				decimal (4,2) not null,
	fecha_termino 			datetime not null,
	estado 					int not null,
	usuario_creacion 		varchar(36) not null,
	fecha_creación 			datetime not null,
	usuario_modificacion 	varchar(36),
	fecha_modificacion 		datetime,
    foreign key (id_tipo) references maestros(id_maestro)
);

/*tabla top banner*/
create table top_banner(
	id_top_banner			varchar (36)  primary key not null,
    id_producto 			varchar (36)  not null,
    H3_tag					varchar (100) not null,
    P1_tag					varchar (100) not null,
    H4_tag					varchar (100) not null,
	P2_tag					varchar (100) not null,
	Span_tag				varchar (100) not null,
	Button_tag				varchar (100) not null,
	IMG_tag					varchar (100) not null,
	estado 					int not null,
	usuario_creacion 		varchar(36) not null,
	fecha_creación 			datetime not null,
	usuario_modificacion 	varchar(36),
	fecha_modificacion 		datetime
);

/*tabla cupones*/
create table cupones(
	id_cupon	 			varchar (36)  primary key not null,
    descripcion				varchar (36)  not null,
	descuento 				decimal (4,2) not null,
	estado 					int not null,
	usuario_creacion 		varchar(36)   not null,
	fecha_creación 			datetime not null,
	usuario_modificacion 	varchar(36),
	fecha_modificacion 		datetime
);


/*tabla top banner*/
create table horizontal_slider(
	id_horizontal_slider	varchar (36)  primary key not null,
    id_producto 			varchar (36)  not null,
    H4_tag	    			varchar (100) not null,
	H3_1_tag				varchar (100) not null,
	H3_2_tag				varchar (100) not null,
	H3_3_tag				varchar (100) not null,
	H3_4s_tag				varchar (100) not null,
	Button_tag				varchar (100) not null,
	IMG_tag					varchar (100) not null,
	estado 					int not null,
	usuario_creacion 		varchar(36) not null,
	fecha_creación 			datetime not null,
	usuario_modificacion 	varchar(36),
	fecha_modificacion 		datetime
);



insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 1, 0, 'Tipo Promocion',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 1, 1, 'Descuento',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 1, 2, 'Precio Fijo',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );


select * from maestros;




