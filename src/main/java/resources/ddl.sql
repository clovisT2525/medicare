create database medicare;
use medicare;
create table user(id int auto_increment, username varchar(255), password varchar(255), is_admin bool, primary key (id));
create table tag(id int auto_increment, name varchar(255), primary key(id));
create table seller(id int auto_increment, name varchar(255), primary key(id));
create table offer(id int auto_increment, name varchar(255), value_in_discount int, primary key(id));
create table medicine(id int auto_increment, name varchar(255), description varchar(255), seller_id int, price int, offer_id int, 
tag_id int, is_active bool, image_url varchar(255),
primary key(id), 
foreign key(seller_id) references seller(id), 
foreign key(offer_id) references offer(id),
foreign key(tag_id) references tag(id));


