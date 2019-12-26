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
			
			
			
			
			
			
			
			
			
insert into SDT_CO (phone, phan_tram) values ('0919222700',100);
insert into SDT_CO (phone, phan_tram) values ('0934192279',100);
insert into SDT_CO (phone, phan_tram) values ('0963016754',100);
insert into SDT_CO (phone, phan_tram) values ('0984172093',100);
insert into SDT_CO (phone, phan_tram) values ('0375551823',100);
insert into SDT_CO (phone, phan_tram) values ('0909592262',100);
insert into SDT_CO (phone, phan_tram) values ('0938507989',100);
insert into SDT_CO (phone, phan_tram) values ('0902971889',100);
insert into SDT_CO (phone, phan_tram) values ('0902900365',100);
insert into SDT_CO (phone, phan_tram) values ('0919419938',100);
insert into SDT_CO (phone, phan_tram) values ('0915400303',100);
insert into SDT_CO (phone, phan_tram) values ('0911135393',100);
insert into SDT_CO (phone, phan_tram) values ('0358817483',100);
insert into SDT_CO (phone, phan_tram) values ('0901387866',100);
insert into SDT_CO (phone, phan_tram) values ('0971794248',100);
insert into SDT_CO (phone, phan_tram) values ('0908143190',100);
insert into SDT_CO (phone, phan_tram) values ('0904030942',100);
insert into SDT_CO (phone, phan_tram) values ('0356143913',100);
insert into SDT_CO (phone, phan_tram) values ('0762585531',100);
insert into SDT_CO (phone, phan_tram) values ('0914225812',100);
insert into SDT_CO (phone, phan_tram) values ('0325114464',100);
insert into SDT_CO (phone, phan_tram) values ('0945181532',100);
insert into SDT_CO (phone, phan_tram) values ('0901324972',100);
insert into SDT_CO (phone, phan_tram) values ('0931498123',100);
insert into SDT_CO (phone, phan_tram) values ('0968942619',100);
insert into SDT_CO (phone, phan_tram) values ('0898189197',100);
insert into SDT_CO (phone, phan_tram) values ('0768468622',100);
insert into SDT_CO (phone, phan_tram) values ('0906856614',100);
insert into SDT_CO (phone, phan_tram) values ('0945498719',100);
insert into SDT_CO (phone, phan_tram) values ('0901324960',100);
insert into SDT_CO (phone, phan_tram) values ('0898248046',100);
insert into SDT_CO (phone, phan_tram) values ('0906693900',100);
insert into SDT_CO (phone, phan_tram) values ('0909455489',100);
insert into SDT_CO (phone, phan_tram) values ('0968498001',100);
insert into SDT_CO (phone, phan_tram) values ('0868888741',100);
insert into SDT_CO (phone, phan_tram) values ('0901958835',100);
insert into SDT_CO (phone, phan_tram) values ('0923480249',100);
insert into SDT_CO (phone, phan_tram) values ('0344543263',100);
insert into SDT_CO (phone, phan_tram) values ('0949388913',100);
insert into SDT_CO (phone, phan_tram) values ('0932302885',100);
insert into SDT_CO (phone, phan_tram) values ('0898188638',100);
insert into SDT_CO (phone, phan_tram) values ('0869157686',100);
insert into SDT_CO (phone, phan_tram) values ('0332998165',100);
insert into SDT_CO (phone, phan_tram) values ('0931854936',100);
insert into SDT_CO (phone, phan_tram) values ('0931173285',100);
insert into SDT_CO (phone, phan_tram) values ('0932098162',100);
insert into SDT_CO (phone, phan_tram) values ('0901302123',100);
insert into SDT_CO (phone, phan_tram) values ('0366654140',100);
insert into SDT_CO (phone, phan_tram) values ('0933902710',100);
insert into SDT_CO (phone, phan_tram) values ('0932308229',100);
insert into SDT_CO (phone, phan_tram) values ('0354133258',100);
insert into SDT_CO (phone, phan_tram) values ('0815879235',100);
insert into SDT_CO (phone, phan_tram) values ('0966381493',100);
insert into SDT_CO (phone, phan_tram) values ('0902781296',100);
insert into SDT_CO (phone, phan_tram) values ('0939427031',100);
insert into SDT_CO (phone, phan_tram) values ('0967634335',100);
insert into SDT_CO (phone, phan_tram) values ('0377911762',100);
insert into SDT_CO (phone, phan_tram) values ('0779992742',100);
insert into SDT_CO (phone, phan_tram) values ('0346447233',100);
insert into SDT_CO (phone, phan_tram) values ('0828354642',100);
insert into SDT_CO (phone, phan_tram) values ('0937054508',100);
insert into SDT_CO (phone, phan_tram) values ('0775414053',100);
insert into SDT_CO (phone, phan_tram) values ('0901259373',100);
insert into SDT_CO (phone, phan_tram) values ('0377538003',100);
insert into SDT_CO (phone, phan_tram) values ('0906978831',100);
insert into SDT_CO (phone, phan_tram) values ('0905994204',100);
insert into SDT_CO (phone, phan_tram) values ('0903778422',100);
insert into SDT_CO (phone, phan_tram) values ('0823421451',100);
insert into SDT_CO (phone, phan_tram) values ('0931173562',100);
insert into SDT_CO (phone, phan_tram) values ('0928416760',100);
insert into SDT_CO (phone, phan_tram) values ('0818106095',100);
insert into SDT_CO (phone, phan_tram) values ('0898205814',100);
insert into SDT_CO (phone, phan_tram) values ('0931145783',100);
insert into SDT_CO (phone, phan_tram) values ('0975219630',100);
insert into SDT_CO (phone, phan_tram) values ('0914125631',100);
insert into SDT_CO (phone, phan_tram) values ('0968286051',100);
insert into SDT_CO (phone, phan_tram) values ('0903135123',100);
insert into SDT_CO (phone, phan_tram) values ('0906352201',100);
insert into SDT_CO (phone, phan_tram) values ('0976521192',100);
insert into SDT_CO (phone, phan_tram) values ('0902321038',100);
insert into SDT_CO (phone, phan_tram) values ('0915838156',100);
insert into SDT_CO (phone, phan_tram) values ('0768756745',100);
insert into SDT_CO (phone, phan_tram) values ('0832567804',100);
insert into SDT_CO (phone, phan_tram) values ('0902578982',100);
insert into SDT_CO (phone, phan_tram) values ('0947640085',100);
insert into SDT_CO (phone, phan_tram) values ('0332951877',100);
insert into SDT_CO (phone, phan_tram) values ('0372762551',100);
insert into SDT_CO (phone, phan_tram) values ('0364929335',100);
insert into SDT_CO (phone, phan_tram) values ('0928412806',100);
insert into SDT_CO (phone, phan_tram) values ('0905560592',100);
insert into SDT_CO (phone, phan_tram) values ('0706315065',100);
insert into SDT_CO (phone, phan_tram) values ('0934982383',100);
insert into SDT_CO (phone, phan_tram) values ('0767127327',100);
insert into SDT_CO (phone, phan_tram) values ('0906983020',100);
insert into SDT_CO (phone, phan_tram) values ('0703705069',100);
insert into SDT_CO (phone, phan_tram) values ('0988628145',100);
insert into SDT_CO (phone, phan_tram) values ('0386877768',100);
insert into SDT_CO (phone, phan_tram) values ('0896203704',100);
insert into SDT_CO (phone, phan_tram) values ('0981177691',100);
insert into SDT_CO (phone, phan_tram) values ('0931106383',100);
insert into SDT_CO (phone, phan_tram) values ('0938313818',100);
insert into SDT_CO (phone, phan_tram) values ('0931176791',100);
insert into SDT_CO (phone, phan_tram) values ('0932142294',100);
insert into SDT_CO (phone, phan_tram) values ('0905807066',100);
insert into SDT_CO (phone, phan_tram) values ('0908599440',100);
insert into SDT_CO (phone, phan_tram) values ('0794804614',100);
insert into SDT_CO (phone, phan_tram) values ('0586725721',100);
insert into SDT_CO (phone, phan_tram) values ('0963107696',100);
insert into SDT_CO (phone, phan_tram) values ('0785444723',100);
insert into SDT_CO (phone, phan_tram) values ('0905862306',100);
insert into SDT_CO (phone, phan_tram) values ('0932193456',100);
insert into SDT_CO (phone, phan_tram) values ('0938510698',100);
insert into SDT_CO (phone, phan_tram) values ('0961791479',100);
insert into SDT_CO (phone, phan_tram) values ('0839197396',100);
insert into SDT_CO (phone, phan_tram) values ('0368233719',100);
insert into SDT_CO (phone, phan_tram) values ('0978026408',100);
insert into SDT_CO (phone, phan_tram) values ('0764975105',100);
insert into SDT_CO (phone, phan_tram) values ('0369313870',100);
insert into SDT_CO (phone, phan_tram) values ('0981371633',100);
insert into SDT_CO (phone, phan_tram) values ('0862426897',100);
insert into SDT_CO (phone, phan_tram) values ('0907127715',100);
insert into SDT_CO (phone, phan_tram) values ('0949755932',100);
insert into SDT_CO (phone, phan_tram) values ('0977521869',100);
insert into SDT_CO (phone, phan_tram) values ('0906757745',100);
insert into SDT_CO (phone, phan_tram) values ('0934513961',100);
insert into SDT_CO (phone, phan_tram) values ('0978382287',100);
