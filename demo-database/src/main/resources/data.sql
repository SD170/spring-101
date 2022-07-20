--Spring autoconfigures this file and runs all the queries

--create table person
--(
--   id integer not null,
--   name varchar(255) not null,
--   location varchar(255),
--   birth_date timestamp,
--   primary key(id)
--);
 

-- CURRENT_TIMESTAMP() not sysdate()
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(100007,  'Cristiano Ronaldo', 'Portugal',CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(1000010,  'Lionel Messi', 'Argentina',CURRENT_TIMESTAMP());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 
VALUES(100011,  'Neymar Jr', 'Brazil',CURRENT_TIMESTAMP());