--admin
create table admins(admin_email varchar2(100) unique,password varchar2(12) not null);

insert into admins values('vinothgandhi33@gmail.com','vinoth@33');

drop table admins cascade CONSTRAINTS;
select * from admins;
commit;
-------------------------------------------------------------------------------------------------------------------------
--users
create table users1(user_id int generated always as identity start with 1 primary key,Name varchar2(100)not null,
password varchar2(100)not null,mobile_no int not null,email_id varchar2(50) unique,Address varchar2(100) not null,wallet int default 5000);

drop table users1 cascade CONSTRAINTS;
desc users1;
select * from users1;
---------------------------------------------------------------------------------------------------------------------------------------------------
update users1 set wallet=wallet-? where user_id=?;
--useraddress

--create table useraddress (User_Address_id int primary key,Address_line1 varchar2(100) not null,
--Address_line2 varchar2(100) not null,City varchar2(100)not null,Postal_code int not null,Country varchar2(100)not null,
--Email varchar2(50) not null,Mobile_no int not null,User_id int,foreign key(User_id)references users1(User_id)) ;
 desc useraddress;
 drop table useraddress;
 ------------------------------------------------------------------------------------------------------------------------------------
 
 --UserPayment
 
 /*create table Userpayment(Payment_id int primary key,Payment_type varchar2(100) not null,Account_no int not null,Expiry date not null,
 User_id int,foreign key(User_id)references users1(User_id));
  drop table Userpayment;
  desc Userpayment;*/
 
 -----------------------------------------------------------------------------------------------------------------------------------
 
 --Products
 
 create table Product (products_id int generated always as identity start with 101 primary key,
 Brand_name varchar2(100),Brand_type varchar2(100),Brand_size int,color varchar2(50),prices int,manufacture_date date);

drop table product cascade CONSTRAINTS;
select * from Product
;
alter table product add product_images varchar2(1000);

-----------------------------------------------------------------------------------------------------------------------------------------

--ProductInventory
 
 --create table Productinventory(Productinventory_id int primary key,Quantity int not null);
 
 ----------------------------------------------------------------------------------------------------------------------------------------
 
 --Ordersdetails
 
 create table Orders_details(Order_id int generated always as identity start with 501 primary key,products_id int, User_id int,
 Quantity int not null,Price int not null,order_date date,foreign key(User_id)
 references users1(user_id), foreign key(products_id) references Product(products_id));
 
  select * from Orders_details;
  
  alter table Orders_details add Status varchar2(100) default'Not Delivered';
  drop table  Orders_details cascade CONSTRAINTS;
  DESC Orderss1;
  delete from Orders_details where products_id=145;
 ----------------------------------------------------------------------------------------------------------------------------------------
 
 --Orderitems
 
 --create table Orderitems1(Item_id int primary key,Quantity int not null,Order_id int,products_id int,foreign key(Order_id)
 --references Orders1(Order_id),foreign key(products_id) references products1(products_id));
 
 -----------------------------------------------------------------------------------------------------------------------------------------
 
 --cartitems
 
 create table Cart_details(Cartitems_id int generated always as identity start with 2001  primary key,
 products_id int, User_id int ,quantity int not null,price int not null,foreign key(products_id) references product(products_id),
 foreign key(User_id)references users1(user_id));
 
 drop taBLE Cart_details cascade CONSTRAINTS;
  select * from  Cart_details; 
  delete from Cart_details where  products_id=145;
 -------------------------------------------------------------------------------------------------------------------------------------------
 
 --InvoiceDetails
 
 create table Invoicebill(Invoicebill_id int generated always as identity start with 5001 primary key,User_id int,Order_id int,
  foreign key(Order_id) references Orders_details(Order_id),
 foreign key(User_id)references users1(User_id));
 select * from  Invoicebill;
  drop table Invoicebill cascade CONSTRAINTS;
  desc Invoicebill;
 -------------------------------------------------------------------------------------------------------------------------------------------
 alter table users1 add Wallet int not null;
 alter table users1 modify Wallet int default 5000;
 
 --------------------------------------------------------------------------------------------------------------------------------------------
 select * from Orders_details where User_id=1;
 
 
 
 update users1 set wallet=500 where email_id='gowtham2@gmail.com';
 commit;
 
 
 select wallet from users1 where email_id='gowtham2@gmail.com';
 
 
 delete from product where products_id=103;
 commit;
 
 
 select sum(price),products_id from  Orders_details where status='Not Delivered' and order_date between '09-01-22' and '18-01-22' group BY products_id ;
 
 
 
 update Orders_details set status='delievered' where Order_id=565;
 commit;
 
 