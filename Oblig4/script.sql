DROP SCHEMA IF EXISTS oblig4 CASCADE;
CREATE SCHEMA oblig4;
SET search_path = oblig4;

CREATE TABLE user1 
(
   firstname CHARACTER VARYING (20),
   lastname CHARACTER VARYING (20),
   phone CHARACTER VARYING(8),
   pwd_hash CHARACTER (64),
   pwd_salt CHARACTER (32),
   gender CHARACTER VARYING(10),
   PRIMARY KEY (phone)
);

