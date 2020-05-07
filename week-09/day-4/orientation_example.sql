show databases;
create database orientationexample;
use orientationexample;
show databases;
create table applicants(
id int unsigned not null auto_increment primary key,
name varchar(60) not null,
country varchar(60) not null,
age int unsigned not null);
show tables;
describe applicants;
insert into applicants values
(null, 'Borivoj Soucek', 'Czech Republic', 24),
(null, 'Papp patricia', 'Hungary', 33);
select * from applicants;
insert into applicants values
(null, 'Kocsis Ivett', 'Hungary', 37),
(null, 'Slavomik Vykukal', 'Czech Republic', 20),
(null, 'Bruno Malik', 'Czech Republic', 31),
(null, 'Veronika Lukesova', 'Czech Republic', 18),
(null, 'Szekely Miklos', 'Hungary', 29),
(null, 'Hegedus Benjamin', 'Hungary', 37),
(null, 'Nela Machova', 'Czech Republic', 20),
(null, 'Balog Rajmund', 'Hungary', 39),
(null, 'Major Borbala', 'Hungary', 35),
(null, 'Evelina Horvathova', 'Czech Republic', 23),
(null, 'Vaszoly Vivien', 'Hungary', 40),
(null, 'Lada Styskaloova', 'Czech Republic', 27),
(null, 'Dagmar Benesova', 'Czech Republic', 33);
select * from applicants;
SELECT name FROM applicants
WHERE country = 'Czech Republic'
ORDER BY age ASC
LIMIT 5;