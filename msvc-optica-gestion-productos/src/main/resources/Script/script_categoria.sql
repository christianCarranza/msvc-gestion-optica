create database db_msvc_optica_gestion_productos;
use db_msvc_optica_gestion_productos;

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

/*tabla productos*/
create table productos(
	id_producto				varchar (36)  primary key not null,
    id_sub_categoria		varchar (36)  not null,
	nombre					varchar (100) not null,
	palabra_clave			varchar (50)  not null,
	url 					varchar (120) not null,
	imagen 					varchar (100) not null,
	precio					decimal (4,2) not null,
	stock				    int not null,			
	id_cupon				varchar (36),
	id_promocion			varchar (36),
	especificaciones		text  	not null,
	detalles				text 	not null,
	descripcion				text 	not null,
	default_banner			varchar (100) not null,
	vertical_slider			varchar (100) not null,
	estado 					int not null,
	usuario_creacion 		varchar (36) not null,
	fecha_creacion 			datetime not null,
	usuario_modificacion 	varchar (36),
	fecha_modificacion 		datetime,
    foreign key (id_sub_categoria) references sub_categorias(id_sub_categoria)
);

/*insert tabla categorias*/

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Consumer Electric', 'consumer-electric', 'comsumer-electric.jpg', 'icon-laundry', 2, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Clothing and Apparel', 'clothing-apparel', 'clothing-apparel.jpg', 'icon-shirt', 4, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Home, Garden and Kitchen', 'home-kitchen', 'home-kitchen.jpg', 'icon-lampshade', 5, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Health and Beauty', 'health-beauty', 'health-beauty.jpg', 'icon-heart-pulse', 23, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Jewelry and Watches', 'jewelry-watches', 'jewelry-watches.jpg', 'icon-diamond2', 3, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into categorias(id_categoria, nombre, url, imagen, icono, vista, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), 'Computer and Technology', 'computer-technology', 'computer-technology.jpg', 'icon-desktop', 45, 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/*insert tabla sub categoria titulos*/

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '18db30c7-3d1f-11ed-b973-025041000001', 'Electronic', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '18db30c7-3d1f-11ed-b973-025041000001', 'Accessories and Parts', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);
/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '9b3e407f-3d22-11ed-b973-025041000001', 'Mens', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '9b3e407f-3d22-11ed-b973-025041000001', 'Womens', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '9b3e407f-3d22-11ed-b973-025041000001', 'Kids', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '9b3f7a95-3d22-11ed-b973-025041000001', 'Home', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '9b3f7a95-3d22-11ed-b973-025041000001', 'Garden', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '9b3f7a95-3d22-11ed-b973-025041000001', 'Kitchen', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '335706e6-3d20-11ed-b973-025041000001', 'Health', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '335706e6-3d20-11ed-b973-025041000001', 'Beauty', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '3640334c-3d20-11ed-b973-025041000001', 'Jewelry', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '3640334c-3d20-11ed-b973-025041000001', 'Watches', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

/**/
insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '335706e6-3d20-11ed-b973-025041000001', 'Computer', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

insert into sub_categoria_titulos(id_sub_categoria_titulo, id_categoria, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values (UUID(), '335706e6-3d20-11ed-b973-025041000001', 'Technology', 1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);


/*insert tabla sub categoria*/

insert into sub_categorias(id_sub_categoria, id_sub_categoria_titulo, nombre, url , imagen , inventario, vista, estado , usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), '97a3fe30-3d23-11ed-b973-025041000001', 'Home Audio and Theathers', 'home-audio-theathers', 'home-audio-theathers.jpg', 10,	2,  1, '18db3141-3d1f-11ed-b973-025041000001', now(),null,null);

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

/*insert tabla productos*/

insert into productos(id_producto, id_sub_categoria, nombre, palabra_clave, url ,imagen, precio, stock, id_cupon, id_promocion, especificaciones, detalles, descripcion, default_banner, vertical_slider, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion)
values(UUID(), 'bfb22887-3d29-11ed-b973-025041000001', 'Korea Long Sofa Fabric In Blue Navy Color', '[\"sofa\",\"furniture\",home\"]', 'korea-long-sofa', 'korea-long-sofa.jpg', 67.99, 100, null, null, '<figure class=\"ml-3\">\n\n                                                            <figcaption>Color: <strong> Choose an option</strong></figcaption>\n\n                                                            <div class=\"ps-variant ps-variant--image\">\n\n                                                                <span class=\"ps-variant__tooltip\">Blue</span>\n\n                                                                <img src=\"img/products/detail/variants/small-1.jpg\" alt=\"\">\n\n                                                            </div>\n\n                                                            <div class=\"ps-variant ps-variant--image\">\n\n                                                                <span class=\"ps-variant__tooltip\"> Dark</span>\n\n                                                                <img src=\"img/products/detail/variants/small-2.jpg\" alt=\"\">\n\n                                                            </div>\n\n                                                            <div class=\"ps-variant ps-variant--image\">\n\n                                                                <span class=\"ps-variant__tooltip\"> pink</span>\n\n                                                                <img src=\"img/products/detail/variants/small-3.jpg\" alt=\"\">\n\n                                                            </div>\n\n                                                        </figure>\n\n                                                        <figure class=\"ml-3\">\n\n                                                            <figcaption>Size <strong> Choose an option</strong></figcaption>\n\n                                                            <div class=\"ps-variant ps-variant--size\"><span class=\"ps-variant__tooltip\">S</span><span class=\"ps-variant__size\">S</span></div>\n                                                            <div class=\"ps-variant ps-variant--size\"><span class=\"ps-variant__tooltip\"> M</span><span class=\"ps-variant__size\">M</span></div>\n                                                            <div class=\"ps-variant ps-variant--size\"><span class=\"ps-variant__tooltip\"> L</span><span class=\"ps-variant__size\">L</span></div>\n\n                                                        </figure>\n',
'<table class=\"table table-bordered ps-table ps-table--specification\">\n\n                                                        <tbody>\n\n                                                            <tr>\n                                                                <td>Color</td>\n                                                                <td>Black, Gray</td>\n                                                            </tr>\n                                                            <tr>\n                                                                <td>Style</td>\n                                                                <td>Ear Hook</td>\n                                                            </tr>\n                                                            <tr>\n                                                                <td>Wireless</td>\n                                                                <td>Yes</td>\n                                                            </tr>\n                                                            <tr>\n                                                                <td>Dimensions</td>\n                                                                <td>5.5 x 5.5 x 9.5 inches</td>\n                                                            </tr>\n                                                            <tr>\n                                                                <td>Weight</td>\n                                                                <td>6.61 pounds</td>\n                                                            </tr>\n                                                            <tr>\n                                                                <td>Battery Life</td>\n                                                                <td>20 hours</td>\n                                                            </tr>\n                                                            <tr>\n                                                                <td>Bluetooth</td>\n                                                                <td>Yes</td>\n                                                            </tr>\n\n                                                        </tbody>\n\n                                                    </table>\n',
'<h5>Embodying the Raw, Wayward Spirit of Rock "N" Roll</h5>\n\n                                                    <p>Embodying the raw, wayward spirit of rock ‘n’ roll, the Kilburn portable active stereo speaker takes the unmistakable look and sound of Marshall, unplugs the chords, and takes the show on the road.</p>\n\n                                                    <p>Weighing in under 7 pounds, the Kilburn is a lightweight piece of vintage styled engineering. Setting the bar as one of the loudest speakers in its class, the Kilburn is a compact, stout-hearted hero with a well-balanced audio which boasts a clear midrange and extended highs for a sound that is both articulate and pronounced. The analogue knobs allow you to fine tune the controls to your personal preferences while the guitar-influenced leather strap enables easy and stylish travel.</p>\n\n                                                    <img class=\"mb-30\" src=\"img/products/detail/content/description.jpg\" alt=\"\">\n\n                                                    <h5>What do you get</h5>\n\n                                                    <p>Sound of Marshall, unplugs the chords, and takes the show on the road.</p>\n\n                                                    <p>Weighing in under 7 pounds, the Kilburn is a lightweight piece of vintage styled engineering. Setting the bar as one of the loudest speakers in its class, the Kilburn is a compact, stout-hearted hero with a well-balanced audio which boasts a clear midrange and extended highs for a sound that is both articulate and pronounced. The analogue knobs allow you to fine tune the controls to your personal preferences while the guitar-influenced leather strap enables easy and stylish travel.</p>\n\n                                                    <p>The FM radio is perhaps gone for good, the assumption apparently being that the jury has ruled in favor of streaming over the internet. The IR blaster is another feature due for retirement – the S6 had it, then the Note5 didn’t, and now with the S7 the trend is clear.</p>\n\n                                                    <h5>Perfectly Done</h5>\n\n                                                    <p>Meanwhile, the IP68 water resistance has improved from the S5, allowing submersion of up to five feet for 30 minutes, plus there’s no annoying flap covering the charging port</p>\n                                                    \n                                                    <ul class=\"pl-0\">\n                                                        <li>No FM radio (except for T-Mobile units in the US, so far)</li>\n                                                        <li>No IR blaster</li>\n                                                        <li>No stereo speakers</li>\n                                                    </ul>\n\n                                                    <p>If you’ve taken the phone for a plunge in the bath, you’ll need to dry the charging port before plugging in. Samsung hasn’t reinvented the wheel with the design of the Galaxy S7, but it didn’t need to. The Gala S6 was an excellently styled device, and the S7 has managed to improve on that.</p>',
'default-banner-1.jpg', 'v-slider-1.jpg', 1,	'18db3141-3d1f-11ed-b973-025041000001',	now(),	null,	null);














select UUID();










select * from categorias;
select * from sub_categoria_titulos;
select * from sub_categorias;
select * from productos;



















