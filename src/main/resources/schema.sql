DROP TABLE IF EXISTS customers;
CREATE TABLE customers(id int not null auto_increment primary key, firstName VARCHAR(255), lastName VARCHAR(255));
insert into customers (firstName, lastName) values ('patrick', 'hawk');
insert into customers (firstName, lastName) values ('monica', 'summer');