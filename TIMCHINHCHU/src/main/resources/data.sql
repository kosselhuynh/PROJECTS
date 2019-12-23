/*
CREATE TABLE NHA_DAT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  list_id VARCHAR(250) NOT NULL,
  owner boolean NOT NULL,
  subject VARCHAR(250) NOT NULL,
  date_upload VARCHAR(250) NOT NULL,
  account_name VARCHAR(250) DEFAULT NULL,
  body CLOB(10k) DEFAULT NULL,
  
  address VARCHAR(250) DEFAULT NULL,
  ward_name VARCHAR(250) DEFAULT NULL,
  area_name VARCHAR(250) DEFAULT NULL,
  region_name VARCHAR(250) DEFAULT NULL,
  
  price VARCHAR(250) DEFAULT NULL,
  price_string VARCHAR(250) DEFAULT NULL,
  rooms VARCHAR(250) DEFAULT NULL,
 
  category_name VARCHAR(250) DEFAULT NULL,
  phone VARCHAR(15) DEFAULT NULL,
  type_name VARCHAR(250) DEFAULT NULL,
  chinh_chu boolean DEFAULT NULL
);
*/

/*
CREATE TABLE SDT_CO (
  phone VARCHAR(15) PRIMARY KEY,
  so_lan_dang_bai int NOT NULL
);*/


 /*
 CREATE TABLE catalogy_tinhtp (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  catalogy_name VARCHAR(255) NOT NULL
 
);
*/
  /*
  CREATE TABLE trending (
	  id INT AUTO_INCREMENT  PRIMARY KEY,
	  name_search VARCHAR(255) NOT NULL,
	  number_search int,
	  date_search timestamp
  );*/
  /*
   CREATE TABLE contact (
	  id INT AUTO_INCREMENT  PRIMARY KEY,
	  fullname VARCHAR(255) NOT NULL,
	  email VARCHAR(255) NOT NULL,
	  subject VARCHAR(255),
	  message VARCHAR(255),
	  date_send timestamp
  );*/
  /*
 INSERT INTO files (id, 	name, 	size, 	downloads, path_view, catalogy, date_upload) VALUES
  				('10001', 'office', '100KB', 111,	'LINK', 'OFFICE',sysdate()),
  				('10002', 'foxit', '1MB',	21,	'LINK', 'OFFICE',sysdate()),
  				('10003', 'unikey', '10MB', 999,	'LINK', 'OFFICE',sysdate());
  */
  /* CREATE TABLE user (
 	  user_id INT AUTO_INCREMENT  PRIMARY KEY,
 	  fullname VARCHAR(255) NOT NULL,
 	  email VARCHAR(255),
 	  password VARCHAR(255),
 	  confirm_password VARCHAR(255),
 	  role_id int not null
   );
   
    CREATE TABLE role (
	  role_id INT AUTO_INCREMENT  PRIMARY KEY,
 	  name VARCHAR(255) NOT NULL
   );
  
   alter table user
   add constraint user_fk1 foreign key (role_id)
   references role (role_id);
  */
  insert into role (role_id, name)
	values (1, 'ROLE_ADMIN');
	 
	insert into role (role_id, name)
	values (2, 'ROLE_USER');
  
    insert into user (user_id, fullname, email, password, confirm_password, role_id)
			values (1, 'dbadmim',  'tam@gmail.com','123456','123456',1);
  
  insert into user (user_id, fullname, email, password, confirm_password, role_id)
			values (2, 'Duong Hao', 'hao@gmail.com','123456','123456',2);
			
insert into SDT_CO (phone)
	values ('0983676415');
 

  