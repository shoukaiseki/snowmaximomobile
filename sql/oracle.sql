CREATE TABLE TEST 
(
  A VARCHAR2(200) 
, ID NUMBER 
, B VARCHAR2(200) 
, C VARCHAR2(200) 
);

INSERT INTO "TEST" (A, ID, B, C) VALUES ('电饭锅', '1', '撒旦', '放水电费');
INSERT INTO "TEST" (A, ID, B, C) VALUES ('撒旦法', '2', 'asds', '申达股份三大');



CREATE TABLE TEST2
(
  NAME VARCHAR2(200) 
, ID NUMBER 
, VALUE VARCHAR2(200) 
);


INSERT INTO "TEST2" ( ID, NAME, VALUE) VALUES (1, 'ASUS', '华硕电脑');




  CREATE TABLE "TEST3" 
   (	"TEST3ID" NUMBER NOT NULL ENABLE, 
	"DESCRIPTION" VARCHAR2(50 CHAR), 
	"SITEID" VARCHAR2(8 CHAR), 
	"ORGID" VARCHAR2(8 CHAR), 
	"ALN01" VARCHAR2(50 CHAR), 
	"HASLD" NUMBER NOT NULL ENABLE, 
	"AMOUNT01" NUMBER(10,2), 
	"BIGINT01" NUMBER, 
	"DATE01" DATE, 
	"DATETIME01" DATE, 
	"DECIMAL01" NUMBER(16,2), 
	"DURATION01" FLOAT(126), 
	"FLOAT01" FLOAT(126), 
	"INTEGER01" NUMBER, 
	"LOWER01" VARCHAR2(50 CHAR), 
	"SMALLINT01" NUMBER, 
	"TIME01" DATE, 
	"UPPER01" VARCHAR2(50 CHAR), 
	"YORN01" NUMBER NOT NULL ENABLE, 
	"ROWSTAMP" VARCHAR2(40 CHAR) NOT NULL ENABLE
   )
   
   
   CREATE SEQUENCE  "TEST3IDSEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
