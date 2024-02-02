create table REAL_ESTATE_AGENCY
(
    AGENCY_ID NUMBER not null
        constraint REAL_ESTATE_AGENCY_PK
            primary key,
    EMP_COUNT NUMBER,
    PASSWORD  VARCHAR2(100),
    M_FAMILY  VARCHAR2(255 char),
    M_NAME    VARCHAR2(255 char),
    M_PHONE   VARCHAR2(255 char),
    A_CITY    VARCHAR2(255 char),
    A_PHONE   VARCHAR2(255 char),
    A_NAME    VARCHAR2(255 char)
)
/

INSERT INTO DB_PROJ.REAL_ESTATE_AGENCY (AGENCY_ID, EMP_COUNT, PASSWORD, M_FAMILY, M_NAME, M_PHONE, A_CITY, A_PHONE, A_NAME) VALUES (302, 0, 'a', 'a', 'a', 'a', 'a', null, 'a');
