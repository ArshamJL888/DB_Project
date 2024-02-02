create table PROPERTY
(
    PROPERTY_ID    NUMBER       not null
        constraint PROPERTY_PK
            primary key,
    TITLE          VARCHAR2(25) not null,
    CITY           VARCHAR2(25) not null,
    ZONE           VARCHAR2(25) not null,
    AREA           NUMBER       not null,
    USAGE          VARCHAR2(25) not null,
    NUMBER_OF_ROOM NUMBER       not null,
    AGE            NUMBER,
    REAL_ESTATE_ID NUMBER       not null
        constraint PROPERTY_REAL_ESTATE_AGENCY_AGENCY_ID_FK
            references REAL_ESTATE_AGENCY,
    DESCRIPTION    VARCHAR2(300),
    PROPERTY_TYPE  NUMBER,
    MORTGAGE_COST  NUMBER,
    SELL_COST      NUMBER,
    PRE_COST       NUMBER,
    MONTHLY_RENT   NUMBER
)
/

