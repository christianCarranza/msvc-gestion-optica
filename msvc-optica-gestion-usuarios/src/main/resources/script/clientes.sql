create database db_msvc_optica_gestion_usuarios;
use db_msvc_optica_gestion_usuarios;


/*tabla usuarios*/
create table usuarios(
                         id_usuario 				varchar (36)  primary key not null,
                         nombre 					varchar(120) not null,
                         apellido_paterno 		varchar(140) not null,
                         apellido_materno 		varchar(140) not null,
                         username 				varchar(30) not null,
                         password 				varchar(60) not null,
                         correo 					varchar(255) not null,
                         celular 				varchar(9) not null,
                         direccion	 			varchar(130) not null,
                         foto			 		varchar(30) not null,
                         estado 					int not null,
                         usuario_creacion 		varchar(36) not null,
                         fecha_creacion 			datetime not null,
                         usuario_modificacion 	varchar(36),
                         fecha_modificacion 		datetime
);

/*tabla roles*/
create table roles(
                      id_rol 					varchar (36)  primary key not null,
                      nombre 					varchar(255) not null,
                      estado 					int not null,
                      usuario_creacion 		varchar(36) not null,
                      fecha_creacion 			datetime not null,
                      usuario_modificacion 	varchar(36),
                      fecha_modificacion 		datetime
);

/*tabla roles*/
create table usuario_roles (
                               id_usuario varchar(36) NOT NULL,
                               id_rol varchar(36) NOT NULL,
                               UNIQUE KEY `UKl72dbb2ssew6kxdehf7oh1xrn` (`id_usuario`,`id_rol`),
                               KEY `FKo74ec96jhrl0qnl41u14osa2b` (`id_rol`),
                               CONSTRAINT `FKo74ec96jhrl0qnl41u14osa2b` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`),
                               CONSTRAINT `FKor5vdfg7bv12b37vaawa9lee2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
);


/*usuarios*/
insert into usuarios (id_usuario, nombre, apellido_paterno, apellido_materno, username, password, correo, celular, direccion, foto, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 'Christian', 'Carranza', 'Felix', 'cbcarranzac',	'123','carranzachristian61@gmail.com', '951279343', 'puente piedra', 'cbcarranzac.jpg',  1,'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

/*roles*/
insert into roles(id_rol, nombre, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 'ROLE_USER',  1,'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null  );

insert into roles(id_rol, nombre, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 'ROLE_ADMIN',  1,'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null  );


/*roles*/
insert into usuario_roles( id_usuario , id_rol )
values ('8e8d4d95-4f5c-11ed-89b3-025041000001', '919bb976-4f5c-11ed-89b3-025041000001');



select * from usuarios;
select * from roles;
select * from usuario_roles;
