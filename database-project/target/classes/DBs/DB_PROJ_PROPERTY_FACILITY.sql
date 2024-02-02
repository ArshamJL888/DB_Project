create table PROPERTY_FACILITY
(
    PROPERTY_ID            NUMBER not null
        primary key
        constraint PROPERTYFACILITY_PROPERTY_PROPERTY_ID_FK
            references PROPERTY,
    PARKING                VARCHAR2(1) default 0,
    LOBBY                  VARCHAR2(1) default 0,
    ELEVATOR               VARCHAR2(1) default 0,
    POOL                   VARCHAR2(1) default 0,
    SAUNA                  VARCHAR2(1) default 0,
    GYM                    VARCHAR2(1) default 0,
    BUILDING_GUARD         VARCHAR2(1) default 0,
    BALCONY                VARCHAR2(1) default 0,
    ROOFTOP_GARDEN         VARCHAR2(1) default 0,
    AIR_CONDITION          VARCHAR2(1) default 0,
    CONFERENCE_HALL        VARCHAR2(1) default 0,
    JACUZZI                VARCHAR2(1) default 0,
    CENTRAL_ANTENNA        VARCHAR2(1) default 0,
    REMOTE_CONTROLLED_DOOR VARCHAR2(1) default 0
)
/

