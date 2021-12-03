create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 correo varchar(45) not null,
 genero varchar(45) not null,
 edad int(11) not null,
 fecha_creacion date null,
 primary key (id)
);

create table preferencia (
   id int(11) not null auto_increment,
   id_usuario int(11) not null,
   menor_precio int(11),
   valoracion_vendedor int(11),
   envio_gratis int(11),
   producto_nuevo int(11),
   tienda_oficial int(11),
   primary key (id)
);

create table busqueda (
    id int(11) not null auto_increment,
    id_usuario int(11),
    palabra_buscada varchar(200) not null,
    categoria varchar(200),
    primary key (id)
);