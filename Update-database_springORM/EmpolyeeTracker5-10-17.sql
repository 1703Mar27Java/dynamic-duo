--------------------------------------------------------
--  File created - Wednesday-May-10-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ATTENDANCE_HISTORY
--------------------------------------------------------

  CREATE TABLE "ADMIN"."ATTENDANCE_HISTORY" 
   (	"A_HIST_ID" NUMBER(10,0), 
	"A_CLOCK_IN" TIMESTAMP (6), 
	"A_CLOCK_OUT" TIMESTAMP (6), 
	"A_DATE" TIMESTAMP (6), 
	"A_DIFF_HRS" NUMBER(10,0), 
	"A_TARDY" NUMBER(10,0), 
	"A_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMP_REQUESTS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."EMP_REQUESTS" 
   (	"E_REQ_ID" NUMBER(10,0), 
	"E_REQ_DESC" VARCHAR2(255 CHAR), 
	"E_REQ_END" TIMESTAMP (6), 
	"E_REQ_NAME" VARCHAR2(255 CHAR), 
	"E_REQ_START" TIMESTAMP (6), 
	"E_REQ_RESOLVER" NUMBER(10,0), 
	"E_REQ_TYPE" NUMBER(10,0), 
	"USER_U_ID" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REQUEST_HISTORY
--------------------------------------------------------

  CREATE TABLE "ADMIN"."REQUEST_HISTORY" 
   (	"RH_ID" NUMBER(10,0), 
	"RH_DAY_LEFT" NUMBER(10,0), 
	"RH_DAY_USED" NUMBER(10,0), 
	"RH_TOTAL_DAYS" NUMBER(10,0), 
	"RH_TYPE_ID" NUMBER(10,0), 
	"RH_USER_ID" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REQUEST_TYPE
--------------------------------------------------------

  CREATE TABLE "ADMIN"."REQUEST_TYPE" 
   (	"RT_ID" NUMBER(10,0), 
	"RT_DURATION" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."USERS" 
   (	"U_ID" NUMBER(10,0), 
	"U_EMAIL" VARCHAR2(255 CHAR), 
	"U_FIRST_NAME" VARCHAR2(255 CHAR), 
	"U_LAST_NAME" VARCHAR2(255 CHAR), 
	"U_PASSWORD" VARCHAR2(255 CHAR), 
	"U_USERNAME" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_ROLE
--------------------------------------------------------

  CREATE TABLE "ADMIN"."USER_ROLE" 
   (	"UR_ID" NUMBER(10,0), 
	"U_ROLE" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence ATTENDHIST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."ATTENDHIST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence REQHIST_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."REQHIST_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence REQID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."REQID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence REQTYPE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."REQTYPE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence ROLE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."ROLE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence UID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."UID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."USER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
REM INSERTING into ADMIN.ATTENDANCE_HISTORY
SET DEFINE OFF;
REM INSERTING into ADMIN.EMP_REQUESTS
SET DEFINE OFF;
REM INSERTING into ADMIN.REQUEST_HISTORY
SET DEFINE OFF;
REM INSERTING into ADMIN.REQUEST_TYPE
SET DEFINE OFF;
REM INSERTING into ADMIN.USERS
SET DEFINE OFF;
REM INSERTING into ADMIN.USER_ROLE
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "ADMIN"."USER_ROLE" ADD PRIMARY KEY ("UR_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."USER_ROLE" MODIFY ("U_ROLE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USER_ROLE" MODIFY ("UR_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table REQUEST_HISTORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."REQUEST_HISTORY" ADD PRIMARY KEY ("RH_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."REQUEST_HISTORY" MODIFY ("RH_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."USERS" ADD PRIMARY KEY ("U_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."USERS" MODIFY ("U_USERNAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("U_PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."USERS" MODIFY ("U_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EMP_REQUESTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."EMP_REQUESTS" ADD PRIMARY KEY ("E_REQ_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."EMP_REQUESTS" MODIFY ("E_REQ_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ATTENDANCE_HISTORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ATTENDANCE_HISTORY" ADD PRIMARY KEY ("A_HIST_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."ATTENDANCE_HISTORY" MODIFY ("A_HIST_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table REQUEST_TYPE
--------------------------------------------------------

  ALTER TABLE "ADMIN"."REQUEST_TYPE" ADD PRIMARY KEY ("RT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."REQUEST_TYPE" MODIFY ("RT_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ATTENDANCE_HISTORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ATTENDANCE_HISTORY" ADD CONSTRAINT "FK_N9PTCQUNWAUDG2KVXEPG31G9F" FOREIGN KEY ("A_USER_ID")
	  REFERENCES "ADMIN"."USERS" ("U_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EMP_REQUESTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."EMP_REQUESTS" ADD CONSTRAINT "FK_6NMKD985LS33H1R6WWVY58EFD" FOREIGN KEY ("USER_U_ID")
	  REFERENCES "ADMIN"."USERS" ("U_ID") ENABLE;
  ALTER TABLE "ADMIN"."EMP_REQUESTS" ADD CONSTRAINT "FK_S0SLR3ABIISTGXFITIFAI7K9M" FOREIGN KEY ("E_REQ_TYPE")
	  REFERENCES "ADMIN"."REQUEST_TYPE" ("RT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REQUEST_HISTORY
--------------------------------------------------------

  ALTER TABLE "ADMIN"."REQUEST_HISTORY" ADD CONSTRAINT "FK_35FARJGI8Y2Q63PRAIH5WL2VX" FOREIGN KEY ("RH_TYPE_ID")
	  REFERENCES "ADMIN"."REQUEST_TYPE" ("RT_ID") ENABLE;
  ALTER TABLE "ADMIN"."REQUEST_HISTORY" ADD CONSTRAINT "FK_BG2YMHQ89R6DTJHAP0V8BLMUO" FOREIGN KEY ("RH_USER_ID")
	  REFERENCES "ADMIN"."USERS" ("U_ID") ENABLE;
