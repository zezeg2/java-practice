create user jdbc@'%' identified by 'jdbc';
create database memberdb;
grant all privileges on memberdb.* to jdbc@'%';

create table member (
    id varchar(10) primary key,
    pw varchar(10)  not null,
    name varchar(10),
    phone char(11) check(phone like '010%'),
    email varchar(30) unique,
    address varchar(50),
    indate datetime
);

insert into member(id,pw,name,email,phone,address,indate) value (?,?,?,?,?,?,?);

commit;
use memberdb;
select * from member;

commit;

SELECT COUNT(*) FROM member;