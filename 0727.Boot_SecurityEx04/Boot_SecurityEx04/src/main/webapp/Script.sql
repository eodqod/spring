DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE employee (
  empId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL
);

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);
DROP TABLE authorities;
create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null
    -- foreign key (username) references users (username)
);

 insert into users(username, password, enabled)values('admin','123456',true);
 insert into authorities(username,authority)values('admin','ROLE_ADMIN');
 
 insert into users(username, password, enabled)values('user','123456',true);
 insert into authorities(username,authority)values('user','ROLE_USER');

select * from employee;
select * from users;
select * from authorities;

commit;
