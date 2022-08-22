show tables;

create table mem(
	idx int primary key auto_increment,
	userid varchar(100) not null,
	password varchar(100) not null,
	name varchar(100) not null
	role varchar(400) not null
);


insert into mem 
	(userid,password,name, role)
values
	('admin','123456','주인장','ROLE_USER,ROLE_ADMIN');

delete from mem;
