create database repository;

USE repository;

create table accounts(
	login varchar(20) NOT NULL primary key UNIQUE,
    name varchar(20) NOT NULL,
    surname varchar(30) NOT NULL,
    access smallint NOT NULL,
    role varchar(10)
);

insert into accounts values
	('Pedro', 'Petr', 'Petrov', 7, 'admin'),
    ('Vano', 'Ivan', 'Ivanov', 4, 'user'),
    ('Lex', 'Alexey', 'Sidorov', 5, 'user'),
    ('Usach', 'Dmitriy', 'Usachev', 6, 'manager'),
    ('Owner', 'Kulikov', 'Michael', 7, 'owner');