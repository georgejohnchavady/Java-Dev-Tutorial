
CREATE TABLE books
(
  name varchar(100) NOT NULL,
  id varchar(11) NOT NULL ,
 author varchar(100) DEFAULT NULL,
 publishdate date DEFAULT NULL,
 PRIMARY KEY (id)
);