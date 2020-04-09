delete from addresses;
delete from users;

insert into users(id, name, email,disabled) values(1,'John Cena','john@gmail.com', false);
insert into users(id, name, email,disabled) values(2,'Salman Khan','salman@gmail.com', false);
insert into users(id, name, email,disabled) values(3,'Amitr Khan','amir@gmail.com', true);

insert into addresses(id,city,user_id) values(1, 'Pune',1);
insert into addresses(id,city,user_id) values(2, 'Landon',1);
insert into addresses(id,city,user_id) values(3, 'Newyork',2);
insert into addresses(id,city,user_id) values(4, 'Mumbai',3);
insert into addresses(id,city,user_id) values(6, 'Washington',3);