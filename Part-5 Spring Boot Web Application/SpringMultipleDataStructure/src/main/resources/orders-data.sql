delete from order_items;
delete from orders;

insert into orders(id, cust_name, cust_email) values(1,'John Cena','john@gmail.com');
insert into orders(id, cust_name, cust_email) values(2,'Salman Khan','salman@gmail.com');
insert into orders(id, cust_name, cust_email) values(3,'Amir Khan','amir@gmail.com');

insert into order_items(id, productcode,quantity,order_id) values(1,'order item1', 2, 1);
insert into order_items(id, productcode,quantity,order_id) values(2,'order item2', 1, 1);
insert into order_items(id, productcode,quantity,order_id) values(3,'order item3', 5, 1);
insert into order_items(id, productcode,quantity,order_id) values(4,'order item4', 2, 2);
insert into order_items(id, productcode,quantity,order_id) values(5,'order item5', 1, 2);