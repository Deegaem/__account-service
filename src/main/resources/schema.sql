CREATE TABLE IF NOT EXISTS account (account_id serial PRIMARY KEY,fname VARCHAR ( 255 ) NOT NULL,lname VARCHAR ( 255 ) NOT NULL,email VARCHAR ( 255 ) NOT NULL,username VARCHAR ( 50 ) NOT NULL,password VARCHAR ( 50 ) NOT NULL);
INSERT INTO account(fname,lname,email,username, password) VALUES ('Elsadiq','Hassan','elsadiq.hassan@gmx.ch','admin','admin');
INSERT INTO account(fname,lname,email,username, password) VALUES ('Hassan','Hassan','elsadiq.hassan@gmx.ch','guest','guest');
INSERT INTO account(fname,lname,email,username, password) VALUES ('Mohamed','Mohamed','elsadiq.hassan@gmx.ch','guest','guest');
INSERT INTO account(fname,lname,email,username, password) VALUES ('Ahmed','Mohamed','ahmed@gmx.ch','guest','guest');