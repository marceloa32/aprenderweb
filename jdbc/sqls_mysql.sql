create database teste_ma;

use teste_ma;

create table contatos(
	id bigint not null auto_increment,
	nome varchar(255),
	email varchar(255),
	endereco varchar(255),
	dataNascimento date,
	primary key(id)
);

select * from contatos;

drop table contatos;

use information_schema;
drop database teste_ma;