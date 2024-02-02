create table MY_USERS
(
    ID           NUMBER not null
        primary key,
    NAME         VARCHAR2(45) default 'karbar eziz',
    FNAME        VARCHAR2(45),
    EMAIL        VARCHAR2(45)
        unique,
    PHONE_NUMBER VARCHAR2(45)
        unique
)
/

INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (3052, null, null, 'ali@gamil.com', null);
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (3053, null, null, 'al2i@gamil.com', null);
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (3102, null, null, 'mamadi@gamil.com', null);
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (3152, null, null, 'vvv@gamil.com', null);
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (3252, 'happy user', null, '"danial@gamil.com"', null);
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (2002, null, null, null, null);
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (1, 'tffffst', 'at', 'test', '134');
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (12, 'mad', 'a', 'mad@', 'wow');
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (2952, 'made', 'aest', 'foad', 'kr');
INSERT INTO DB_PROJ.MY_USERS (ID, NAME, FNAME, EMAIL, PHONE_NUMBER) VALUES (3002, 'adam', 'aest', 'fosad', 'krff');
