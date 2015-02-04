DROP TABLE USERS;
CREATE TABLE USERS (
    username VARCHAR(10) NOT NULL PRIMARY KEY,
    password VARCHAR(10),
    profile INTEGER,
    joinDate DATE NOT NULL
);
DROP TABLE POSTS;
CREATE TABLE POSTS (
    content VARCHAR(140) NOT NULL,
    author VARCHAR(10) NOT NULL,
    postDate DATE NOT NULL,
    id INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY
);
DROP TABLE PROFILES;
CREATE TABLE PROFILES (
    biography VARCHAR(1024),
    email VARCHAR(50),
    picture BLOB(200K),
    id INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY
);
INSERT INTO USERS (username,password,joinDate) VALUES
('johndoe','password','2013-04-29'),
('janedoe','password','2014-10-11'),
('jilljack','password','2015-01-27');
INSERT INTO POSTS (content,author,postDate) VALUES
('Hello, world!','johndoe','2013-04-29'),
('This is phun', 'janedoe','2014-10-11'),
('Stop already!','jilljack','2015-01-27');
INSERT INTO PROFILES (biography,email) VALUES
('I like long walks on the beach.', 'awesome@widgets.inc');
UPDATE USERS SET profile = 1 WHERE username = 'johndoe';

