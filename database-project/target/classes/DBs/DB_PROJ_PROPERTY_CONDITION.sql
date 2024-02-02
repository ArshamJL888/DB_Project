create table PROPERTY_CONDITION
(
    PROPERTY_ID       NUMBER not null
        primary key
        constraint PROPERTYCONDITION_PROPERTY_PROPERTY_ID_FK
            references PROPERTY,
    COOPERATIVE       VARCHAR2(1) default 0,
    BARTER            VARCHAR2(1) default 0,
    CONVERTIBLE       VARCHAR2(1) default 0,
    PRESALE           VARCHAR2(1) default 0,
    BUILDING_LOCATION VARCHAR2(1) default 0,
    LOAN              VARCHAR2(1) default 0,
    NEWLY_BUILT       VARCHAR2(1) default 0,
    EQUITY            VARCHAR2(1) default 0,
    SHOPPING_CENTER   VARCHAR2(1) default 0,
    MALL              VARCHAR2(1) default 0
)
/

