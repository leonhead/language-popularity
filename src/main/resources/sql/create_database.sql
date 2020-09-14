CREATE DATABASE if not exists program_languages;
USE program_languages;

DROP TABLE if exists github_repository;
DROP TABLE if exists program_language;

CREATE TABLE program_language(
    program_language_id int NOT NULL AUTO_INCREMENT,
    program_language_name varchar(40) UNIQUE,
    
    PRIMARY KEY (program_language_id)
   );

CREATE TABLE github_repository(
    github_repository_id int NOT NULL AUTO_INCREMENT,
	full_name varchar(40),
    html_url varchar(40),
	stargazers_count int,
    program_language_id int,
    FOREIGN KEY (program_language_id) REFERENCES program_language(program_language_id),

    PRIMARY KEY (github_repository_id)
);