create database user_db;
create user 'brightTalkUser'@'%' identified by 'ThePassword';
grant all on user_db.* to 'brightTalkUser'@'%';


create table realm (id integer not null, description varchar(255), `key` varchar(32), name varchar(255), primary key (id));