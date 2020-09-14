CREATE DATABASE if not exists language;
USE language;

DROP TABLE if exists Repository;
DROP TABLE if exists Language;

CREATE TABLE Language (
    id int NOT NULL,

    PRIMARY KEY (id)
   );

CREATE TABLE Repository(
    id int NOT NULL,
    
    PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES Language(id)
);