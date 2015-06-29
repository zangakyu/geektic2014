-- DROP ALL TABLES
DROP TABLE GEEKCONSULTATION IF EXISTS;
DROP TABLE GEEKINTEREST IF EXISTS;
DROP TABLE GEEK IF EXISTS;
DROP TABLE INTEREST IF EXISTS;
DROP SEQUENCE GEEKID_SEQ IF EXISTS;
DROP SEQUENCE INTERESTID_SEQ IF EXISTS;

--CREATE TABLES

-- 0 = geekete , 1 = geek
CREATE TABLE GEEK (id int, lastName varchar(30),firstName varchar(30),age int,sexe boolean,mail varchar(30));

CREATE TABLE INTEREST (id int, name varchar(30));

CREATE TABLE GEEKINTEREST(GEEKID int,INTERESTID int);

CREATE TABLE GEEKCONSULTATION (id int,date timestamp,fromIP varchar(11),geekid int);

-- PRIMARY KEYS
ALTER TABLE GEEK ADD CONSTRAINT PK_GEEK PRIMARY KEY(id);
ALTER TABLE INTEREST ADD CONSTRAINT PK_INTEREST PRIMARY KEY(id);
ALTER TABLE GEEKINTEREST ADD CONSTRAINT PK_GEEKINTEREST PRIMARY KEY(GEEKID,INTERESTID);
ALTER TABLE GEEKCONSULTATION ADD CONSTRAINT PK_GEEKCONSULTATION PRIMARY KEY(id);

-- FOREIGN KEYS
ALTER TABLE GEEKCONSULTATION ADD CONSTRAINT FK_GEEKCONSULTATION_GEEKID_GEEK FOREIGN KEY(GEEKID) REFERENCES GEEK(id);
ALTER TABLE GEEKINTEREST ADD CONSTRAINT FK_GEEKINTEREST_GEEKID_GEEK FOREIGN KEY(GEEKID) REFERENCES GEEK(id);
ALTER TABLE GEEKINTEREST ADD CONSTRAINT FK_GEEKINTEREST_INTERESTID_INTEREST FOREIGN KEY(INTERESTID) REFERENCES INTEREST(ID);

-- CREATE SEQUENCE
CREATE SEQUENCE GEEKID_SEQ;
CREATE SEQUENCE INTERESTID_SEQ;


-- DATA
INSERT INTO GEEK VALUES (NEXT VALUE FOR GEEKID_SEQ,'Elric','Edward',12,1,'edward.elric@gmail.com');
INSERT INTO GEEK VALUES (NEXT VALUE FOR GEEKID_SEQ,'Elric','Alphonse',11,1,'alphonse.elric@gmail.com');
INSERT INTO GEEK VALUES (NEXT VALUE FOR GEEKID_SEQ,'Winchester','Dean',26,1,'dean.winchester@gmail.com');
INSERT INTO GEEK VALUES (NEXT VALUE FOR GEEKID_SEQ,'Winchester','Sam',24,1,'sam.winchester@gmail.com');
INSERT INTO GEEK VALUES (NEXT VALUE FOR GEEKID_SEQ,'Simpson','Marge',39,0,'marge.simpson@gmail.com');
INSERT INTO GEEK VALUES (NEXT VALUE FOR GEEKID_SEQ,'Simpson','Homer',40,1,'homer.simpson@gmail.com');

INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'JAVA');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'C#');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'Alchemy');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'TDD');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'spring');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'linux');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'windows');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'hunting');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'hacking');
INSERT INTO INTEREST VALUES(NEXT VALUE FOR INTERESTID_SEQ,'TV');

INSERT INTO GEEKINTEREST VALUES(0,2);
INSERT INTO GEEKINTEREST VALUES(1,2);
INSERT INTO GEEKINTEREST VALUES(2,7);
INSERT INTO GEEKINTEREST VALUES(3,7);
INSERT INTO GEEKINTEREST VALUES(3,5);
INSERT INTO GEEKINTEREST VALUES(3,8);
INSERT INTO GEEKINTEREST VALUES(4,1);
INSERT INTO GEEKINTEREST VALUES(4,0);
INSERT INTO GEEKINTEREST VALUES(5,8);
INSERT INTO GEEKINTEREST VALUES(5,9);


