
DROP DATABASE IF EXISTS website;
--
-- Create a new database.
CREATE DATABASE IF NOT EXISTS website;
--
-- Change the database to book_store.
USE website;
--
-- Change delimiter
DELIMITER //
--
-- Create tables in book_store database.
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS user;

create table address ( UserID INT NOT NULL AUTO_INCREMENT, street varchar(40) NOT NULL, 
city varchar(40) NOT NULL, state varchar(20) NOT NULL, zip varchar(5), PRIMARY KEY (UserID));

create table phone (UserID INT NOT NULL AUTO_INCREMENT, telephone varchar(10) NOT NULL,
 FOREIGN KEY (UserID) REFERENCES address (UserID));

create table user (UserID INT NOT NULL AUTO_INCREMENT, firstname VARCHAR(100) NOT NULL, lastname VARCHAR(100) NOT NULL, 
password VARCHAR(100) NOT NULL, email varchar(60) NOT NULL,FOREIGN KEY (UserID) REFERENCES address (UserID));

create table Author(AuthorID BIGINT NOT NULL,
                    AuthorFirstName VARCHAR(20),
                    AuthorLastName VARCHAR(20),
                    PRIMARY KEY (AuthorID));
                    
create table Book(BookID BIGINT NOT NULL,
                  ISBN VARCHAR(30) NOT NULL,
                  Title VARCHAR(100) NOT NULL,
                  Editor VARCHAR(50),
                  Edition VARCHAR(20),
                  Year INT,
                  AuthorID BIGINT NOT NULL AUTO_INCREMENT,
                  PRIMARY KEY (BookID),
                  FOREIGN KEY(AuthorID) REFERENCES Author(AuthorID));

