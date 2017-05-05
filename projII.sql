/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER pro2
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to pro2;
GRANT resource to pro2;
GRANT create session TO pro2;
GRANT create table TO pro2;
GRANT create view TO pro2;

conn pro2/p4ssw0rd

DROP TABLE ERS_USERS;
DROP TABLE ERS_USER_ROLES;
DROP TABLE ERS_REQUEST_STATUS;
DROP TABLE ERS_RESQUEST_TYPE;
DROP TABLE ERS_REQUESTS;
DROP TABLE HISTORY_OF_REQEUSTS;
DROP TABLE ATTENDANCE_HISTORY;




CREATE TABLE ERS_USER_ROLES(
  UR_ID NUMBER(*,0) PRIMARY KEY,
  UR_ROLE VARCHAR2(40)
)

CREATE TABLE ERS_USERS(
    U_ID NUMBER (*,0) PRIMARY KEY,
    U_USERNAME VARCHAR2(40) NOT NULL,
    U_PASSWORD VARCHAR2(40) NOT NULL,
    U_FIRSTNAME VARCHAR2(30),
    U_LASTNAME VARCHAR2(30),
    U_EMAIL VARCHAR2(100),
    UR_ID NUMBER(*,0) NOT NULL,
    CONSTRAINT unique_keys 
      UNIQUE (U_USERNAME, U_EMAIL),
    CONSTRAINT fk_supplier
      FOREIGN KEY (UR_ID)
      REFERENCES ERS_USER_ROLES(UR_ID)
);

CREATE TABLE ERS_REQUEST_STATUS(
  RS_ID NUMBER(*,0) PRIMARY KEY,
  RS_STATUS VARCHAR2(30) NOT NULL
);

CREATE TABLE ERS_REQUEST_TYPE(
  RT_ID NUMBER(*,0) PRIMARY KEY,
  RT_TYPE VARCHAR2(30) NOT NULL,
  RT_DURATION NUMBER
);

CREATE TABLE ERS_REQUESTS(
  R_ID NUMBER(*,0) PRIMARY KEY,
  U_ID_AUTHOR NUMBER(*,0) NOT NULL,
  RT_TYPE NUMBER(*,0) NOT NULL,
  RS_STATUS NUMBER(*,0) NOT NULL,
  R_SUBMITTED TIMESTAMP NOT NULL,
  R_RESOLVED TIMESTAMP,
  
  R_DESCRIPTION VARCHAR2(100),
  
  U_ID_RESOLVER NUMBER(*,0),
  
  CONSTRAINT fk_supplier1
      FOREIGN KEY (U_ID_AUTHOR)
      REFERENCES ERS_USERS(U_ID),
      
  CONSTRAINT fk_supplier2
      FOREIGN KEY (U_ID_RESOLVER)
      REFERENCES ERS_USERS(U_ID),
      
  CONSTRAINT fk_supplier3
      FOREIGN KEY (RT_TYPE)
      REFERENCES ERS_REQUEST_TYPE(RT_ID),
  
  CONSTRAINT fk_supplier4
      FOREIGN KEY (RS_STATUS)
      REFERENCES ERS_REQUEST_STATUS(RS_ID)
);

CREATE TABLE ers_history_of_request(
  R_HIST_ID NUMBER(*,0) PRIMARY KEY,
  U_ID_AUTHOR NUMBER (*,0) NOT NULL,
  RT_ID_HIST NUMBER(*,0) NOT NULL,
  TOTAL_COUNT NUMBER,
  NUMBER_USED NUMBER,
  NUMBER_LEFT NUMBER,
  
  CONSTRAINT fk_supplier5
    FOREIGN KEY (U_ID_AUTHOR)
    REFERENCES ERS_USERS(U_ID),
    
  CONSTRAINT fk_supplier6
    FOREIGN KEY (RT_ID_HIST)
    REFERENCES ERS_REQUEST_TYPE(RT_ID)
);

CREATE TABLE ers_attendance_history(
  ATTD_HIST_ID NUMBER(*,0) PRIMARY KEY,
  U_ID_HIST NUMBER (*,0) NOT NULL,
  CURR_DATE TIMESTAMP NOT NULL,
  CLOCK_IN TIMESTAMP,
  CLOCK_OUT TIMESTAMP,
  DIFFERENCE NUMBER NOT NULL,
  LATE NUMBER(2) NOT NULL,
  
   CONSTRAINT fk_supplier7
    FOREIGN KEY (U_ID_HIST)
    REFERENCES ERS_USERS(U_ID)
)

/*****************
auto-increment for users
******************/
CREATE SEQUENCE user_seq START WITH 1;

CREATE OR REPLACE TRIGGER user_trigger
BEFORE INSERT ON ers_users
FOR EACH ROW

BEGIN
  SELECT user_seq.NEXTVAL
  INTO   :new.u_id
  FROM   dual;
END;
/
/*****************
auto-increment for requests
******************/
CREATE SEQUENCE request_seq START WITH 1;

CREATE OR REPLACE TRIGGER request_trigger
BEFORE INSERT ON ers_requests
FOR EACH ROW

BEGIN
  SELECT request_seq.NEXTVAL
  INTO   :new.r_id
  FROM   dual;
END;
/

/*****************
auto-increment for attendance history
******************/
CREATE SEQUENCE attend_hist_seq START WITH 1;

CREATE OR REPLACE TRIGGER attend_hist_trigger
BEFORE INSERT ON ers_attendance_history
FOR EACH ROW

BEGIN
  SELECT attend_hist_seq.NEXTVAL
  INTO   :new.attd_hist_id
  FROM   dual;
END;
/

/*****************
auto-increment for request history
******************/
CREATE SEQUENCE requ_hist_seq START WITH 1;

CREATE OR REPLACE TRIGGER requ_hist_trigger
BEFORE INSERT ON  ers_history_of_request
FOR EACH ROW

BEGIN
  SELECT requ_hist_seq.NEXTVAL
  INTO   :new.r_hist_id
  FROM   dual;
END;
/

/*****************
auto time-stamp insertion
******************/
CREATE OR REPLACE TRIGGER timestamp_trigger 
BEFORE INSERT ON ers_requests
FOR EACH ROW
BEGIN
 :NEW.R_SUBMITTED := SYSDATE;
END;
