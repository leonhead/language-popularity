CREATE DATABASE if not exists program_languages;
USE program_languages;

DROP TABLE if exists github_repository;
DROP TABLE if exists popularity;
DROP TABLE if exists program_language;


CREATE TABLE program_language(
    program_language_id int NOT NULL AUTO_INCREMENT,
    program_language_name varchar(40) NOT NULL UNIQUE,
    currency double,
    
    PRIMARY KEY (program_language_id)
   );

CREATE TABLE popularity(
	popularity_id int NOT NULL AUTO_INCREMENT,
    date_year int,
    currency double,
    program_language_id int,
    FOREIGN KEY (program_language_id) REFERENCES program_language(program_language_id),
    
	PRIMARY KEY (popularity_id)
);

CREATE TABLE github_repository(
    github_repository_id int NOT NULL AUTO_INCREMENT,
    github_id int NOT NULL UNIQUE,
	full_name varchar(255) NOT NULL UNIQUE,
    html_url varchar(255),
	stargazers_count int,
    program_language_id int,
    created long,
    FOREIGN KEY (program_language_id) REFERENCES program_language(program_language_id),

    PRIMARY KEY (github_repository_id)
);