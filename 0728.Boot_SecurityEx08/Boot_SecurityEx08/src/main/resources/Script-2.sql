DROP TABLE employee;
DROP TABLE roles;
DROP TABLE users;

CREATE TABLE employee (
  empId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL
);

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table roles (
    username varchar(50) not null,
    role varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('admin','123456',true);
insert into roles(username,role)values('admin','ROLE_ADMIN');
 
insert into users(username, password, enabled)values('user','123456',true);
insert into roles(username,role)values('user','ROLE_USER');

select * from users;
select * from roles;


