drop user if exists 'estore3'@'localhost';

create user 'estore3'@'localhost' identified by 'estore3123';
grant all privileges on estore3db.* to 'estore3'@'localhost';
flush privileges;

drop database if exists estore3db;

create database estore3db;