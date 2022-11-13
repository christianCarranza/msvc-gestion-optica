create database db_msvc_optica_gestion_productos;
use db_msvc_optica_gestion_productos;

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

/*tabla categorias*/
create table categorias(
                           id_categoria 			varchar (36)  primary key not null,
                           nombre 					varchar (100) not null,
                           url 					varchar (120) not null,
                           imagen 					varchar (100) not null,
                           icono 					varchar (100) not null,
                           vista 					int not null,
                           estado 					int not null,
                           usuario_creacion 		varchar(36) not null,
                           fecha_creacion 			datetime not null,
                           usuario_modificacion 	varchar(36),
                           fecha_modificacion 		datetime
);

/*tabla sub categoria titulos*/
create table sub_categoria_titulos(
                                      id_sub_categoria_titulo	varchar (36)  primary key not null,
                                      id_categoria 			varchar (36)  not null,
                                      descripcion				varchar (100) not null,
                                      estado 					int not null,
                                      usuario_creacion 		varchar(36) not null,
                                      fecha_creacion 			datetime not null,
                                      usuario_modificacion 	varchar(36),
                                      fecha_modificacion 		datetime,
                                      foreign key (id_categoria) references categorias(id_categoria)
);

/*tabla sub categorias*/
create table sub_categorias(
                               id_sub_categoria		varchar (36)  primary key not null,
                               id_sub_categoria_titulo	varchar (36)  not null,
                               nombre 					varchar (100) not null,
                               url 					varchar (120) not null,
                               imagen 					varchar (100) not null,
                               inventario				int not null,
                               vista 					int not null,
                               estado 					int not null,
                               usuario_creacion 		varchar(36) not null,
                               fecha_creacion 			datetime not null,
                               usuario_modificacion 	varchar(36),
                               fecha_modificacion 		datetime,
                               foreign key (id_sub_categoria_titulo) references sub_categoria_titulos(id_sub_categoria_titulo)
);

/*tabla promociones*/
create table promociones(
                            id_promocion 			varchar (36)  primary key not null,
                            id_tipo					varchar (36) not null,
                            descuento 				decimal (4,2) not null,
                            fecha_termino 			datetime not null,
                            estado 					int not null,
                            usuario_creacion 		varchar(36) not null,
                            fecha_creacion 			datetime not null,
                            usuario_modificacion 	varchar(36),
                            fecha_modificacion 		datetime,
                            foreign key (id_tipo) references maestros(id_maestro)
);

/*tabla top banner*/
create table top_banner(
                           id_top_banner			varchar (36)  primary key not null,
                           H3_tag					varchar (100) not null,
                           P1_tag					varchar (100) not null,
                           H4_tag					varchar (100) not null,
                           P2_tag					varchar (100) not null,
                           Span_tag				varchar (100) not null,
                           Button_tag				varchar (100) not null,
                           IMG_tag					varchar (1000) not null,
                           estado 					int not null,
                           usuario_creacion 		varchar(36) not null,
                           fecha_creacion 			datetime not null,
                           usuario_modificacion 	varchar(36),
                           fecha_modificacion 		datetime
);

/*tabla cupones*/
create table cupones(
                        id_cupon	 			varchar (36)  primary key not null,
                        descripcion				varchar (36)  not null,
                        descuento 				decimal (4,2) not null,
                        fecha_termino 			datetime not null,
                        estado 					int not null,
                        usuario_creacion 		varchar(36)   not null,
                        fecha_creacion 			datetime not null,
                        usuario_modificacion 	varchar(36),
                        fecha_modificacion 		datetime
);


/*tabla top banner*/
create table horizontal_slider(
                                  id_horizontal_slider	varchar (36)  primary key not null,
                                  H4_tag	    			varchar (100) not null,
                                  H3_1_tag				varchar (100) not null,
                                  H3_2_tag				varchar (100) not null,
                                  H3_3_tag				varchar (100) not null,
                                  H3_4s_tag				varchar (100) not null,
                                  Button_tag				varchar (100) not null,
                                  IMG_tag					varchar (1000) not null,
                                  estado 					int not null,
                                  usuario_creacion 		varchar(36) not null,
                                  fecha_creacion 			datetime not null,
                                  usuario_modificacion 	varchar(36),
                                  fecha_modificacion 		datetime
);

/*tabla productos*/
/*El formato de video es: youtube o vimeo ...*/
create table productos(
                          id_producto				varchar (36)  primary key not null,
                          id_sub_categoria		varchar (36)  not null,
                          nombre					varchar (100) not null,
                          palabra_clave			varchar (50)  not null,
                          url 					varchar (120) not null,
                          imagen 					varchar (1000) not null,
                          video 					varchar (100),
                          id_formato_video		varchar (36),
                          precio					decimal (4,2) not null,
                          stock				    int not null,
                          resumen					text not null,
                          id_cupon				varchar (36),
                          id_promocion			varchar (36),
                          id_top_banner			varchar (36) not null,
                          id_horizontal_slider	varchar (36) not null,
                          especificaciones		text  	not null,
                          descripcion				text 	not null,
                          default_banner			varchar (1000) not null,
                          vertical_slider			varchar (1000) not null,
                          vista 					int not null,
                          ventas 					int not null,
                          estado 					int not null,
                          usuario_creacion 		varchar (36) not null,
                          fecha_creacion 			datetime not null,
                          usuario_modificacion 	varchar (36),
                          fecha_modificacion 		datetime,
                          foreign key (id_sub_categoria) references sub_categorias(id_sub_categoria),
                          foreign key (id_formato_video) references maestros(id_maestro),
                          foreign key (id_cupon) references cupones(id_cupon),
                          foreign key (id_promocion) references promociones(id_promocion),
                          foreign key (id_top_banner) references top_banner(id_top_banner),
                          foreign key (id_horizontal_slider) references horizontal_slider(id_horizontal_slider)
);


/*tabla detalles*/
create table detalles(
                         id_detalle					varchar (36)  primary key not null,
                         id_producto 				varchar (36)  not null,
                         titulo 					varchar (255)  not null,
                         descripcion				varchar (1000) not null,
                         estado 					int not null,
                         usuario_creacion 			varchar(36) not null,
                         fecha_creacion 			datetime not null,
                         usuario_modificacion 		varchar(36),
                         fecha_modificacion 		datetime,
                         foreign key (id_producto) 	references productos(id_producto)
);

/*tabla Galerias*/
create table galerias(
                         id_galeria					varchar (36)  primary key not null,
                         id_producto 				varchar (36)  not null,
                         descripcion				varchar (1000) not null,
                         estado 					int not null,
                         usuario_creacion 			varchar(36) not null,
                         fecha_creacion 			datetime not null,
                         usuario_modificacion 		varchar(36),
                         fecha_modificacion 		datetime,
                         foreign key (id_producto) 	references productos(id_producto)
);

/*tabla sub reviews*/
create table resenas(
                        id_resena					varchar (36)  primary key not null,
                        id_producto				varchar (36)  not null,
                        id_cliente 				varchar(36) not null,
                        calificacion 				int not null,
                        comentario					varchar (360) not null,
                        estado 					int not null,
                        usuario_creacion 			varchar(36) not null,
                        fecha_creacion 			datetime not null,
                        usuario_modificacion 		varchar(36),
                        fecha_modificacion 		datetime,
                        foreign key (id_producto) 	references productos(id_producto)
);

/*insert tabla maestro*/

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 1, 0, 'Tipo Promocion',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 1, 1, 'Descuento',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 1, 2, 'Precio Fijo',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );


insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 2, 0, 'Tipo Plataforma',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 2, 1, 'YouTube',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );

insert into maestros (id_maestro, correlativo, prefijo, descripcion, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 2, 2, 'Vimedo',	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null );


/*insert tabla categorias*/

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Lentes de Contacto', 'lentes-de-contacto', 'lentes-de-contacto.jpg', 'icon-laundry', 2, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Monturas o Gafas', 'monturas-o-gafas', 'monturas-o-gafas.jpg', 'icon-shirt', 4, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Lentes Oftálmicos', 'lentes-oftalmicos', 'lentes-oftalmicos.jpg', 'icon-lampshade', 5, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Lentes de Sol', 'lentes-de-sol', 'lentes-de-sol.jpg', 'icon-heart-pulse', 23, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Lunas', 'lunas', 'lunas.jpg', 'icon-diamond2', 3, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Lentes', 'lentes', 'lentes.jpg', 'icon-desktop', 45, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Accesorios', 'accesorios', 'accesorios.jpg', 'icon-desktop', 45, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/*insert tabla sub categoria titulos*/

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd67f964d-6174-11ed-b9ef-025041000001', 'Color', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd67f964d-6174-11ed-b9ef-025041000001', 'Tipos', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd67f964d-6174-11ed-b9ef-025041000001', 'Duración', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd8a29e06-6174-11ed-b9ef-025041000001', 'Niños', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd8a29e06-6174-11ed-b9ef-025041000001', 'Adultos', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd8a29e06-6174-11ed-b9ef-025041000001', 'Seguridad', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd8a29e06-6174-11ed-b9ef-025041000001', 'Deportivas', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'd8a29e06-6174-11ed-b9ef-025041000001', 'Lectores', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'dacfff2b-6174-11ed-b9ef-025041000001', 'Marca', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'dacfff2b-6174-11ed-b9ef-025041000001', 'Forma', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'ddb9166e-6174-11ed-b9ef-025041000001', 'Forma', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/*Lunas*/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'ddbb7cff-6174-11ed-b9ef-025041000001', 'Lunas', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/*Lentes*/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'e07bf36f-6174-11ed-b9ef-025041000001', 'Lentes', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/*Accesorios*/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'e07e1b7f-6174-11ed-b9ef-025041000001', 'Accesorios', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);


/*insert tabla sub categoria*/

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '151a44c4-6179-11ed-b9ef-025041000001', 'Color con Medida', 'color-con-medida', 'color-con-medida.jpg', 10,	2,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);
/*
insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'TV and Videos', 'tv-videos', 'tv-videos.jpg', 10,	4,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Camera, Photos and Videos', 'camera-photos-videos', 'camera-photos-videos.jpg', 10,	5,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Cellphones and Accessories', 'cellphones-accessories', 'cellphones-accessories.jpg', 10, 23,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Headphones', 'headphones', 'headphones.jpg', 10, 3,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Video games', 'video-games', 'video-games.jpg', 10, 45,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Wireless Speakers', 'wireless-speakers', 'wireless-speakers.jpg', 10, 4, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Office Electronic', 'office-electronic', 'office-electronic.jpg', 10, 45, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '9e653eb7-3d23-11ed-b973-025041000001', 'Digital Cables', 'digital-cables', 'digital-cables.jpg', 10, 5,1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '9e653eb7-3d23-11ed-b973-025041000001', 'Audio and Video Cables', 'audio-video-cables', 'audio-video-cables,jpg', 10, 5, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '9e653eb7-3d23-11ed-b973-025041000001', 'Batteries', 'batteries', 'batteries.jpg', 10, 4, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'9e666a5d-3d23-11ed-b973-025041000001',	'Sportswear man',	'sportswear-man',	'sportswear-man.jpg',	10,	4,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'9e666a5d-3d23-11ed-b973-025041000001',	'Elegant clothes man',	'elegant-clothes-man',	'elegant-clothes-man.jpg',	10,	12,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'9e666a5d-3d23-11ed-b973-025041000001',	'Classic clothes man',	'classic-clothes-man',	'classic-clothes-man.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'9e6771ee-3d23-11ed-b973-025041000001',	'Sportswear woman',	'sportswear-woman',	'sportswear-woman.jpg',	10,	21,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'9e6771ee-3d23-11ed-b973-025041000001',	'Elegant clothes woman',	'elegant-clothes-woman',	'elegant-clothes-woman.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'9e6771ee-3d23-11ed-b973-025041000001',	'Classic clothes woman',	'classic-clothes-woman',	'classic-clothes-woman.jpg',	10,	12,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'bd23ed12-3d23-11ed-b973-025041000001',	'Sportswear kids',	'sportswear-kids',	'sportswear-kids.jpg',	10,	21,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'bd23ed12-3d23-11ed-b973-025041000001',	'Elegant clothes kids',	'elegant-clothes-kids',	'elegant-clothes-kids.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'bd23ed12-3d23-11ed-b973-025041000001',	'Classic clothes kids',	'classic-clothes-kids',	'classic-clothes-kids.jpg',	10,	12,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30cb4f1-3d23-11ed-b973-025041000001',	'Cookware',	'cookware',	'cookware.jpg',	10,	3,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30cb4f1-3d23-11ed-b973-025041000001',	'Decoration',	'decoration',	'decoration.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30cb4f1-3d23-11ed-b973-025041000001',	'Furniture',	'furniture',	'furniture.jpg',	10,	4,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30dff7c-3d23-11ed-b973-025041000001',	'Garden Tools',	'garden-tools',	'garden-tools.jpg',	10,	5,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30dff7c-3d23-11ed-b973-025041000001',	'Garden Equipments',	'garden-equipments',	'garden-equipments.jpg',	10,	23,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30dff7c-3d23-11ed-b973-025041000001',	'Powers and Hand Tools',	'powers-hand-tools',	'powers-hand-tools.jpg',	10,	3,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30dff7c-3d23-11ed-b973-025041000001',	'Utensil and Gadget',	'utensil-gadget',	'utensil-gadget.jpg',	10,	45,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30f37af-3d23-11ed-b973-025041000001',	'Kitchen Equipments',	'kitchen-equipments',	'kitchen-equipments.jpg',	10,	23,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd30f37af-3d23-11ed-b973-025041000001',	'Kitchen Utensil',	'kitchen-utensil',	'kitchen-utensil.jpg',	10,	45,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd31039f2-3d23-11ed-b973-025041000001',	'Yoga Instrument',	'yoga-Instrument',	'yoga-Instrument.jpg',	10,	3,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd31039f2-3d23-11ed-b973-025041000001',	'Passive Gymnastics',	'passive-gymnastics',	'passive-gymnastics.jpg',	10,	3,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd31039f2-3d23-11ed-b973-025041000001',	'Gym Equipment',	'gym-equipment',	'gym-equipment.jpg',	10,	21,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd311554f-3d23-11ed-b973-025041000001',	'Hair Care',	'hair-care',	'hair-care.jpg',	10,	45,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd311554f-3d23-11ed-b973-025041000001',	'Makeup',	'makeup',	'makeup.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd311554f-3d23-11ed-b973-025041000001',	'Perfume',	'perfume',	'perfume.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3124879-3d23-11ed-b973-025041000001',	'Necklace',	'necklace',	'necklace',	10,	3,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3124879-3d23-11ed-b973-025041000001',	'Pendant',	'pendant',	'pendant',	10,	3,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3124879-3d23-11ed-b973-025041000001',	'Ring',	'ring',	'ring',	10,	21,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3135e0d-3d23-11ed-b973-025041000001',	'Sport Watch',	'sport-watch',	'sport-watch',	10,	4,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3135e0d-3d23-11ed-b973-025041000001',	'Womens Watch',	'womens-watch',	'womens-watch',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3135e0d-3d23-11ed-b973-025041000001',	'Mens Watch',	'mens-watch',	'mens-watch',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3146ea5-3d23-11ed-b973-025041000001',	'Desktop PC',	'desktop-pc',	'desktop-pc.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3146ea5-3d23-11ed-b973-025041000001',	'Laptop',	'laptop',	'laptop.jpg',	10,	2,	1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd3146ea5-3d23-11ed-b973-025041000001',	'Audio and Video',	'audio-video',	'audio-video.jpg',	10,	3,1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd315811b-3d23-11ed-b973-025041000001',	'Smartphones',	'smartphones',	'smartphones.jpg',	10,	3, 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd315811b-3d23-11ed-b973-025041000001',	'Tablets',	'tablets',	'tablets.jpg',	10,	21,	1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),	'd315811b-3d23-11ed-b973-025041000001',	'Wireless Speaker',	'wireless-speaker',	'wireless-speaker.jpg',	10,	4, 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);
*/

/*insert tabla promociones*/

insert into  promociones( id_promocion, id_tipo, descuento, fecha_termino, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(),'cc323011-6174-11ed-b9ef-025041000001',25, '2022-11-25 03:57:18', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

/*insert tabla cupones*/
/*create table cupones( id_cupon, descripcion, descuento, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion);
values ();*/

/*insert tabla top banner*/
insert into top_banner( id_top_banner, H3_tag, P1_tag, H4_tag, P2_tag, Span_tag, Button_tag, IMG_tag, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'20%', 'Disccount', 'For Books Of March','Enter Promotion', 'Sale2019', 'Shop now', 'header-promotion-1.jpg', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

/*insert tabla horizontal slider*/
insert into horizontal_slider( id_horizontal_slider, H4_tag, H3_1_tag, H3_2_tag, H3_3_tag, H3_4s_tag, Button_tag, IMG_tag, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'Limit Edition', 'Happy Summer', 'Combo Super Cool','Up to', '40%', 'Shop now', 'h-slider-1.jpg', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);


/*insert tabla productos*/
insert into productos(id_producto, id_sub_categoria, nombre, palabra_clave, url ,imagen, video, id_formato_video, precio, stock, resumen,
                      id_cupon, id_promocion, id_top_banner, id_horizontal_slider, especificaciones, descripcion, default_banner, vertical_slider,vista, ventas, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '00cc3e30-cde2-43c2-acb1-b9454130d228', 'Korea Long Sofa Fabric In Blue Navy Color', '[\"sofa\",\"furniture\",\"home\"]', 'korea-long-sofa', 'korea-long-sofa.jpg','v=bLX6ETR3w1M', 'd0411d0b-6174-11ed-b9ef-025041000001', 67.99, 100, '[\"Unrestrained and portable active stereo speaker\", \"Free from the confines of wires and chords\", \"20 hours of portable capabilities\", \"Double-ended Coil Cord with 3.5mm Stereo Plugs Included\", \"3/4 Dome Tweeters: 2X and 4 Woofer: 1X\"]',
       null, '5c431363-6229-11ed-b9ef-025041000001','618b7a27-6229-11ed-b9ef-025041000001','63746dee-6229-11ed-b9ef-025041000001', '<figure class=\"ml-3\">\n\n                                                            <figcaption>Color: <strong> Choose an option</strong></figcaption>\n\n                                                            <div class=\"ps-variant ps-variant--image\">\n\n                                                                <span class=\"ps-variant__tooltip\">Blue</span>\n\n                                                                <img src=\"img/products/detail/variants/small-1.jpg\" alt=\"\">\n\n                                                            </div>\n\n                                                            <div class=\"ps-variant ps-variant--image\">\n\n                                                                <span class=\"ps-variant__tooltip\"> Dark</span>\n\n                                                                <img src=\"img/products/detail/variants/small-2.jpg\" alt=\"\">\n\n                                                            </div>\n\n                                                            <div class=\"ps-variant ps-variant--image\">\n\n                                                                <span class=\"ps-variant__tooltip\"> pink</span>\n\n                                                                <img src=\"img/products/detail/variants/small-3.jpg\" alt=\"\">\n\n                                                            </div>\n\n                                                        </figure>\n\n                                                        <figure class=\"ml-3\">\n\n                                                            <figcaption>Size <strong> Choose an option</strong></figcaption>\n\n                                                            <div class=\"ps-variant ps-variant--size\"><span class=\"ps-variant__tooltip\">S</span><span class=\"ps-variant__size\">S</span></div>\n                                                            <div class=\"ps-variant ps-variant--size\"><span class=\"ps-variant__tooltip\"> M</span><span class=\"ps-variant__size\">M</span></div>\n                                                            <div class=\"ps-variant ps-variant--size\"><span class=\"ps-variant__tooltip\"> L</span><span class=\"ps-variant__size\">L</span></div>\n\n                                                        </figure>\n',
       '<h5>Embodying the Raw, Wayward Spirit of Rock "N" Roll</h5>\n\n                                                    <p>Embodying the raw, wayward spirit of rock ‘n’ roll, the Kilburn portable active stereo speaker takes the unmistakable look and sound of Marshall, unplugs the chords, and takes the show on the road.</p>\n\n                                                    <p>Weighing in under 7 pounds, the Kilburn is a lightweight piece of vintage styled engineering. Setting the bar as one of the loudest speakers in its class, the Kilburn is a compact, stout-hearted hero with a well-balanced audio which boasts a clear midrange and extended highs for a sound that is both articulate and pronounced. The analogue knobs allow you to fine tune the controls to your personal preferences while the guitar-influenced leather strap enables easy and stylish travel.</p>\n\n                                                    <img class=\"mb-30\" src=\"img/products/detail/content/description.jpg\" alt=\"\">\n\n                                                    <h5>What do you get</h5>\n\n                                                    <p>Sound of Marshall, unplugs the chords, and takes the show on the road.</p>\n\n                                                    <p>Weighing in under 7 pounds, the Kilburn is a lightweight piece of vintage styled engineering. Setting the bar as one of the loudest speakers in its class, the Kilburn is a compact, stout-hearted hero with a well-balanced audio which boasts a clear midrange and extended highs for a sound that is both articulate and pronounced. The analogue knobs allow you to fine tune the controls to your personal preferences while the guitar-influenced leather strap enables easy and stylish travel.</p>\n\n                                                    <p>The FM radio is perhaps gone for good, the assumption apparently being that the jury has ruled in favor of streaming over the internet. The IR blaster is another feature due for retirement – the S6 had it, then the Note5 didn’t, and now with the S7 the trend is clear.</p>\n\n                                                    <h5>Perfectly Done</h5>\n\n                                                    <p>Meanwhile, the IP68 water resistance has improved from the S5, allowing submersion of up to five feet for 30 minutes, plus there’s no annoying flap covering the charging port</p>\n                                                    \n                                                    <ul class=\"pl-0\">\n                                                        <li>No FM radio (except for T-Mobile units in the US, so far)</li>\n                                                        <li>No IR blaster</li>\n                                                        <li>No stereo speakers</li>\n                                                    </ul>\n\n                                                    <p>If you’ve taken the phone for a plunge in the bath, you’ll need to dry the charging port before plugging in. Samsung hasn’t reinvented the wheel with the design of the Galaxy S7, but it didn’t need to. The Gala S6 was an excellently styled device, and the S7 has managed to improve on that.</p>',
       'default-banner-1.jpg', 'v-slider-1.jpg',0,0, 1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);


/*test*/
insert into productos(id_producto, id_sub_categoria, nombre, palabra_clave, url ,imagen, precio, stock, id_cupon, id_promocion, id_top_banner, id_horizontal_slider, especificaciones, detalles, descripcion, default_banner, vertical_slider, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 'bfb22887-3d29-11ed-b973-025041000001', 'Korea Long Sofa Fabric In Blue Navy Color', 'korea Long', 'korea-long-sofa', 'korea-long-sofa.jpg', 67.99, 100, null, null,'ba3edff6-5021-11ed-89b3-025041000001','d3c74fad-5021-11ed-89b3-025041000001', 'korea Long', 'korea Long', 'korea Long','default-banner-1.jpg', 'v-slider-1.jpg', 1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);


/*insert tabla detalles*/
insert into detalles(id_detalle, id_producto, titulo, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'Color', 'Blanco', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into detalles(id_detalle, id_producto, titulo, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'Dimensions', '5.5 x 5.5 x 9.5 inches', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into detalles(id_detalle, id_producto, titulo, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'Weight', '6.61 pounds', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

/*insert tabla galerias*/
insert into galerias(id_galeria, id_producto, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'v1667714189/categories/068a12c0-25da-4324-aaa4-e2334cab3c18.jpg', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into galerias(id_galeria, id_producto, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'v1667714189/categories/068a12c0-25da-4324-aaa4-e2334cab3c18.jpg', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into galerias(id_galeria, id_producto, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'v1667714189/categories/068a12c0-25da-4324-aaa4-e2334cab3c18.jpg', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into galerias(id_galeria, id_producto, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', 'v1667714189/categories/068a12c0-25da-4324-aaa4-e2334cab3c18.jpg', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);


/*insert tabla reseñas*/
insert into resenas(id_resena, id_producto, id_cliente, calificacion, comentario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001','56453f11-5fec-11ed-890a-025041000001', 4 , 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable.', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into resenas(id_resena, id_producto, id_cliente, calificacion, comentario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', '6a063595-5fec-11ed-890a-025041000001', 3 , 'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original for', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into resenas(id_resena, id_producto, id_cliente, calificacion, comentario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', '7367e42d-5fec-11ed-890a-025041000001', 2 , 'ontrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock,', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into resenas(id_resena, id_producto, id_cliente, calificacion, comentario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001','56453f11-5fec-11ed-890a-025041000001', 4 , 'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable. ', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);

insert into resenas(id_resena, id_producto, id_cliente, calificacion, comentario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(uuid(),'b4dad049-637a-11ed-bb3b-025041000001', '6a063595-5fec-11ed-890a-025041000001', 5 , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 1, '18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);





select UUID();









select * from categorias;
select * from sub_categoria_titulos;
select * from sub_categorias;

select * from productos;
select * from maestros;
select * from promociones;
select * from top_banner;
select * from horizontal_slider;
select * from detalles;
select * from galerias;
select * from resenas;

delete  from horizontal_slider where id_horizontal_slider = 'b9b746f1-1994-4126-8b17-6c3256c8bfcd';
delete  from horizontal_slider where id_horizontal_slider = 'f8c206ed-a131-408a-bba5-4bc2eb0379ac';
