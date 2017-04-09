CREATE TABLE IF NOT EXISTS Arguments (
	id int(11) primary key auto_increment,
	argument1 int(11) NOT NULL,
	argument2 int(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS GCD (
	id int(11) primary key auto_increment,
	computedGCD int(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS USER(
	id int(11) primary key auto_increment,
	username varchar(100) NOT NULL,
	password varchar(100) NOT NULL
);

INSERT INTO USER (username, password) 
	SELECT 'gcdappuser', md5('password') FROM DUAL
WHERE NOT EXISTS (SELECT * FROM USER WHERE username = 'gcdappuser');