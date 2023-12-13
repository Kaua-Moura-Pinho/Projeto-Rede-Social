create table usuario(
	idusuario serial primary key,
	primeironomeusuario varchar (20),
	sobrenomeusuario varchar(60),
	telefoneusuario char(11),
	generousuario varchar(9),
	emailusuario varchar(50),
	senhausuario varchar(30)
);

create table postagem(
	idpostagem serial primary key,
	conteudopostagem varchar (200),
	idusuario integer,
	constraint fk_idusuario
	foreign key (idusuario)
	references usuario (idusuario)
);