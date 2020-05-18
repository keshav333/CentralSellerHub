insert into ecommerce(ecomm_id, ecomm_name) VALUES
(1,"Flipkart"),
(2,"Paytm"),
(3,"Myntra"),
(4,"Amazon"),
(5,"Ebay"),
(6,"IITB Products");

select * from product;
select * from product_ecommerce;
select * from seller;

insert into seller(seller_id, seller_address, seller_contact_no, seller_email_id, seller_name, seller_password, shop_name) VALUES
(1,'kanpur','9639369429','keshav@gmail.com','Keshav Gupta','1234','POP'),
(2,'bhopal','9753426643','eshita@gmail.com','Eshita Sharma','1234','CHUMBAK'),
(3,'akola','9404861652','lubaina@gmail.com','Lubaina Machinewala','1234','NAVBHARAT'),
(4,'indore','7415784685','shreya@gmail.com','Shreya Joshi','1234','WhiteFiled')

drop table ecommerce, ecommerce_seller, product_ecommerce, hibernate_sequence, product, SPRING_SESSION_ATTRIBUTES, seller

TRUNCATE seller

insert into ecommerce_seller(ecomm_seller_id, ecomm_email_id, ecomm_password, ecomm_id) VALUES
(1,"keshav@flipkart.com", "1234", 1),
(2,"keshav@paytm.com", "1234", 2),
(3,"keshav@myntra.com", "1234", 3),
(4,"keshav@amazon.com", "1234", 4),
(5,"keshav@ebay.com", "1234", 5),
(6,"keshav@iiitbp.com", "1234", 6),
(7,"eshita@flipkart.com", "1234", 1),
(8,"eshita@paytm.com", "1234", 2),
(9,"eshita@myntra.com", "1234", 3),
(10,"eshita@amazon.com", "1234", 4),
(11,"eshita@ebay.com", "1234", 5),
(12,"eshita@iiitbp.com", "1234", 6),
(13,"shreya@flipkart.com", "1234", 1),
(14,"shreya@paytm.com", "1234", 2),
(15,"shreya@myntra.com", "1234", 3),
(16,"shreya@amazon.com", "1234", 4),
(17,"shreya@ebay.com", "1234", 5),
(18,"shreya@iiitbp.com", "1234", 6),
(19,"lubaina@flipkart.com", "1234", 1),
(20,"lubaina@paytm.com", "1234", 2),
(21,"lubaina@myntra.com", "1234", 3),
(22,"lubaina@amazon.com", "1234", 4),
(23,"lubaina@ebay.com", "1234", 5),
(24,"lubaina@iiitbp.com", "1234", 6);


