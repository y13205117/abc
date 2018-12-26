/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : yin
Source Server Version : 110200
Source Host           : :1521
Source Schema         : SCOTT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-12-26 23:35:18
*/


-- ----------------------------
-- Table structure for T_AWARDRECORD
-- ----------------------------
DROP TABLE "SCOTT"."T_AWARDRECORD";
CREATE TABLE "SCOTT"."T_AWARDRECORD" (
"A_ID" NUMBER(6) NOT NULL ,
"A_CAUSE" VARCHAR2(20 BYTE) NULL ,
"A_MONEY" NUMBER(6) NULL ,
"A_TIME" VARCHAR2(20 BYTE) NULL ,
"A_EID" NUMBER(6) NULL ,
"A_CID" NUMBER NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_AWARDRECORD
-- ----------------------------

-- ----------------------------
-- Table structure for T_CALCULATE
-- ----------------------------
DROP TABLE "SCOTT"."T_CALCULATE";
CREATE TABLE "SCOTT"."T_CALCULATE" (
"C_ID" NUMBER(6) NOT NULL ,
"C_TIME" VARCHAR2(20 BYTE) NULL ,
"C_RECONSIDER" NUMBER(6) DEFAULT 1  NULL ,
"C_CAUSE" VARCHAR2(50 BYTE) NULL ,
"C_EID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_CALCULATE
-- ----------------------------

-- ----------------------------
-- Table structure for T_DEPARTMENT
-- ----------------------------
DROP TABLE "SCOTT"."T_DEPARTMENT";
CREATE TABLE "SCOTT"."T_DEPARTMENT" (
"D_ID" NUMBER(6) NOT NULL ,
"D_NAME" VARCHAR2(20 BYTE) NULL ,
"D_CREATIONTIME" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_DEPARTMENT
-- ----------------------------

-- ----------------------------
-- Table structure for T_EMPLOYEE
-- ----------------------------
DROP TABLE "SCOTT"."T_EMPLOYEE";
CREATE TABLE "SCOTT"."T_EMPLOYEE" (
"E_ID" NUMBER(6) NOT NULL ,
"E_SALARY" NUMBER(8,2) NULL ,
"E_STATE" NUMBER(6) NULL ,
"E_TYPE" NUMBER(6) NULL ,
"E_JID" NUMBER(6) NULL ,
"E_PERFORMANCE" NUMBER(6) NULL ,
"E_VID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_EMPLOYEE
-- ----------------------------

-- ----------------------------
-- Table structure for T_GATECARD
-- ----------------------------
DROP TABLE "SCOTT"."T_GATECARD";
CREATE TABLE "SCOTT"."T_GATECARD" (
"G_ID" NUMBER(6) NOT NULL ,
"COLUMN_2" NUMBER NULL ,
"G_OFFICEHOURS" VARCHAR2(20 BYTE) NULL ,
"G_AFTERHOURS" VARCHAR2(20 BYTE) NULL ,
"G_STATE" NUMBER(6) NULL ,
"G_EID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_GATECARD
-- ----------------------------

-- ----------------------------
-- Table structure for T_GCSTATE
-- ----------------------------
DROP TABLE "SCOTT"."T_GCSTATE";
CREATE TABLE "SCOTT"."T_GCSTATE" (
"GC_ID" NUMBER(6) NULL ,
"GC_NAME" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_GCSTATE
-- ----------------------------
INSERT INTO "SCOTT"."T_GCSTATE" VALUES ('1', '正常');
INSERT INTO "SCOTT"."T_GCSTATE" VALUES ('2', '加班');
INSERT INTO "SCOTT"."T_GCSTATE" VALUES ('3', '迟到');
INSERT INTO "SCOTT"."T_GCSTATE" VALUES ('4', '早退');
INSERT INTO "SCOTT"."T_GCSTATE" VALUES ('5', '矿工');

-- ----------------------------
-- Table structure for T_JOB
-- ----------------------------
DROP TABLE "SCOTT"."T_JOB";
CREATE TABLE "SCOTT"."T_JOB" (
"J_ID" NUMBER(6) NOT NULL ,
"J_NAME" VARCHAR2(20 BYTE) NULL ,
"J_CREATIONTIME" VARCHAR2(20 BYTE) NULL ,
"J_DID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_JOB
-- ----------------------------

-- ----------------------------
-- Table structure for T_LEAVE
-- ----------------------------
DROP TABLE "SCOTT"."T_LEAVE";
CREATE TABLE "SCOTT"."T_LEAVE" (
"L_ID" NUMBER(6) NOT NULL ,
"L_CAUSE" VARCHAR2(20 BYTE) NULL ,
"L_TIME" VARCHAR2(20 BYTE) NULL ,
"L_EID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_LEAVE
-- ----------------------------

-- ----------------------------
-- Table structure for T_MEMBERSHOWCV
-- ----------------------------
DROP TABLE "SCOTT"."T_MEMBERSHOWCV";
CREATE TABLE "SCOTT"."T_MEMBERSHOWCV" (
"M_ID" NUMBER(6) NOT NULL ,
"M_RID" NUMBER(6) NULL ,
"M_VID" NUMBER(6) NULL ,
"M_TIME" VARCHAR2(20 BYTE) NULL ,
"M_STATE" NUMBER(6) DEFAULT 0  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_MEMBERSHOWCV
-- ----------------------------

-- ----------------------------
-- Table structure for T_RECRUIT
-- ----------------------------
DROP TABLE "SCOTT"."T_RECRUIT";
CREATE TABLE "SCOTT"."T_RECRUIT" (
"R_ID" NUMBER(6) NOT NULL ,
"R_THEME" VARCHAR2(20 BYTE) NULL ,
"R_CONTENT" VARCHAR2(100 BYTE) NULL ,
"R_REQUIRE" VARCHAR2(20 BYTE) NULL ,
"R_COUNT" NUMBER(6) NULL ,
"R_RELEASETIME" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_RECRUIT
-- ----------------------------

-- ----------------------------
-- Table structure for T_STATE
-- ----------------------------
DROP TABLE "SCOTT"."T_STATE";
CREATE TABLE "SCOTT"."T_STATE" (
"S_ID" NUMBER(6) NOT NULL ,
"S_NAME" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_STATE
-- ----------------------------
INSERT INTO "SCOTT"."T_STATE" VALUES ('1', '在职');
INSERT INTO "SCOTT"."T_STATE" VALUES ('2', '试用期');
INSERT INTO "SCOTT"."T_STATE" VALUES ('3', '离职');

-- ----------------------------
-- Table structure for T_TRAIN
-- ----------------------------
DROP TABLE "SCOTT"."T_TRAIN";
CREATE TABLE "SCOTT"."T_TRAIN" (
"T_ID" NUMBER(6) NOT NULL ,
"T_CONTENT" VARCHAR2(50 BYTE) NULL ,
"T_REQUIRED" VARCHAR2(50 BYTE) NULL ,
"T_STARTTIME" VARCHAR2(20 BYTE) NULL ,
"T_ENDTIME" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_TRAIN
-- ----------------------------

-- ----------------------------
-- Table structure for T_TRAINANDDEP
-- ----------------------------
DROP TABLE "SCOTT"."T_TRAINANDDEP";
CREATE TABLE "SCOTT"."T_TRAINANDDEP" (
"TAD_ID" NUMBER(6) NOT NULL ,
"TAD_DID" NUMBER(6) NULL ,
"TAD_TID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_TRAINANDDEP
-- ----------------------------

-- ----------------------------
-- Table structure for T_TRAINANDEMP
-- ----------------------------
DROP TABLE "SCOTT"."T_TRAINANDEMP";
CREATE TABLE "SCOTT"."T_TRAINANDEMP" (
"TAE_ID" NUMBER(6) NOT NULL ,
"TAE_EID" NUMBER(6) NULL ,
"TEA_TID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_TRAINANDEMP
-- ----------------------------

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE "SCOTT"."T_USER";
CREATE TABLE "SCOTT"."T_USER" (
"U_ID" NUMBER(6) DEFAULT NULL  NOT NULL ,
"U_NAME" VARCHAR2(20 BYTE) NOT NULL ,
"U_PASS" VARCHAR2(20 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO "SCOTT"."T_USER" VALUES ('1', 'yinhuaqi1', 'y64176712');
INSERT INTO "SCOTT"."T_USER" VALUES ('2', 'yinhuaqi2', 'y64176712');

-- ----------------------------
-- Table structure for T_VITAE
-- ----------------------------
DROP TABLE "SCOTT"."T_VITAE";
CREATE TABLE "SCOTT"."T_VITAE" (
"V_ID" NUMBER(6) NOT NULL ,
"V_NAME" VARCHAR2(20 BYTE) NULL ,
"V_BIRTH" VARCHAR2(20 BYTE) NULL ,
"V_SEX" VARCHAR2(6 BYTE) NULL ,
"V_PHONE" NUMBER(11) NULL ,
"V_ADDRESS" VARCHAR2(50 BYTE) NULL ,
"V_EMAIL" VARCHAR2(20 BYTE) NULL ,
"V_EDUCATION" VARCHAR2(20 BYTE) NULL ,
"V_UID" NUMBER(6) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_VITAE
-- ----------------------------
INSERT INTO "SCOTT"."T_VITAE" VALUES ('2', 'yinhuaqi1', '19900519', '男', '15021843599', '上海市', 'y13205117@gmail.com', '本科', '1');

-- ----------------------------
-- Sequence structure for SEQ_T_AWARDRECORD
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_AWARDRECORD";
CREATE SEQUENCE "SCOTT"."SEQ_T_AWARDRECORD"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_CALCULATE
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_CALCULATE";
CREATE SEQUENCE "SCOTT"."SEQ_T_CALCULATE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_DEPARTMENT
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_DEPARTMENT";
CREATE SEQUENCE "SCOTT"."SEQ_T_DEPARTMENT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_EMPLOYEE
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_EMPLOYEE";
CREATE SEQUENCE "SCOTT"."SEQ_T_EMPLOYEE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_GATECARD
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_GATECARD";
CREATE SEQUENCE "SCOTT"."SEQ_T_GATECARD"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_GCSTATE
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_GCSTATE";
CREATE SEQUENCE "SCOTT"."SEQ_T_GCSTATE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 6
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_JOB
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_JOB";
CREATE SEQUENCE "SCOTT"."SEQ_T_JOB"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_LEAVE
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_LEAVE";
CREATE SEQUENCE "SCOTT"."SEQ_T_LEAVE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_MEMBERSHOWCV
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_MEMBERSHOWCV";
CREATE SEQUENCE "SCOTT"."SEQ_T_MEMBERSHOWCV"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_RECRUIT
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_RECRUIT";
CREATE SEQUENCE "SCOTT"."SEQ_T_RECRUIT"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_STATE
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_STATE";
CREATE SEQUENCE "SCOTT"."SEQ_T_STATE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 4
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_TRAIN
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_TRAIN";
CREATE SEQUENCE "SCOTT"."SEQ_T_TRAIN"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_TRAINANDDEP
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_TRAINANDDEP";
CREATE SEQUENCE "SCOTT"."SEQ_T_TRAINANDDEP"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_TRAINANDEMP
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_TRAINANDEMP";
CREATE SEQUENCE "SCOTT"."SEQ_T_TRAINANDEMP"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 1
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_USER
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_USER";
CREATE SEQUENCE "SCOTT"."SEQ_T_USER"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 3
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SEQ_T_VITAE
-- ----------------------------
DROP SEQUENCE "SCOTT"."SEQ_T_VITAE";
CREATE SEQUENCE "SCOTT"."SEQ_T_VITAE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 999999
 START WITH 3
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Indexes structure for table T_AWARDRECORD
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_AWARDRECORD
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_AWARDRECORDTRIG" BEFORE INSERT ON "SCOTT"."T_AWARDRECORD" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_AWARDRECORD.nextval INTO :new.A_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_AWARDRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."T_AWARDRECORD" ADD CHECK ("A_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_AWARDRECORD
-- ----------------------------
ALTER TABLE "SCOTT"."T_AWARDRECORD" ADD PRIMARY KEY ("A_ID");

-- ----------------------------
-- Indexes structure for table T_CALCULATE
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_CALCULATE
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_CALCULATETRIG" BEFORE INSERT ON "SCOTT"."T_CALCULATE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_CALCULATE.nextval INTO :new.C_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_CALCULATE
-- ----------------------------
ALTER TABLE "SCOTT"."T_CALCULATE" ADD CHECK ("C_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_CALCULATE
-- ----------------------------
ALTER TABLE "SCOTT"."T_CALCULATE" ADD PRIMARY KEY ("C_ID");

-- ----------------------------
-- Indexes structure for table T_DEPARTMENT
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_DEPARTMENT
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_DEPARTMENTTRIG" BEFORE INSERT ON "SCOTT"."T_DEPARTMENT" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_DEPARTMENT.nextval INTO :new.D_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_DEPARTMENT
-- ----------------------------
ALTER TABLE "SCOTT"."T_DEPARTMENT" ADD CHECK ("D_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DEPARTMENT
-- ----------------------------
ALTER TABLE "SCOTT"."T_DEPARTMENT" ADD PRIMARY KEY ("D_ID");

-- ----------------------------
-- Indexes structure for table T_EMPLOYEE
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_EMPLOYEE
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_EMPLOYEETRIG" BEFORE INSERT ON "SCOTT"."T_EMPLOYEE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_EMPLOYEE.nextval INTO :new.E_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_EMPLOYEE
-- ----------------------------
ALTER TABLE "SCOTT"."T_EMPLOYEE" ADD CHECK ("E_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_EMPLOYEE
-- ----------------------------
ALTER TABLE "SCOTT"."T_EMPLOYEE" ADD PRIMARY KEY ("E_ID");

-- ----------------------------
-- Indexes structure for table T_GATECARD
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_GATECARD
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_GATECARDTRIG" BEFORE INSERT ON "SCOTT"."T_GATECARD" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_GATECARD.nextval INTO :new.G_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_GATECARD
-- ----------------------------
ALTER TABLE "SCOTT"."T_GATECARD" ADD CHECK ("G_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_GATECARD
-- ----------------------------
ALTER TABLE "SCOTT"."T_GATECARD" ADD PRIMARY KEY ("G_ID");

-- ----------------------------
-- Triggers structure for table T_GCSTATE
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_GCSTATETRIG" BEFORE INSERT ON "SCOTT"."T_GCSTATE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_GCSTATE.nextval INTO :new.GC_ID FROM dual;
  end;
-- ----------------------------
-- Indexes structure for table T_JOB
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_JOB
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_JOBTRIG" BEFORE INSERT ON "SCOTT"."T_JOB" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_JOB.nextval INTO :new.J_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_JOB
-- ----------------------------
ALTER TABLE "SCOTT"."T_JOB" ADD CHECK ("J_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_JOB
-- ----------------------------
ALTER TABLE "SCOTT"."T_JOB" ADD PRIMARY KEY ("J_ID");

-- ----------------------------
-- Indexes structure for table T_LEAVE
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_LEAVE
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_LEAVETRIG" BEFORE INSERT ON "SCOTT"."T_LEAVE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_LEAVE.nextval INTO :new.L_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_LEAVE
-- ----------------------------
ALTER TABLE "SCOTT"."T_LEAVE" ADD CHECK ("L_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_LEAVE
-- ----------------------------
ALTER TABLE "SCOTT"."T_LEAVE" ADD PRIMARY KEY ("L_ID");

-- ----------------------------
-- Indexes structure for table T_MEMBERSHOWCV
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_MEMBERSHOWCV
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_MEMBERSHOWCVTRIG" BEFORE INSERT ON "SCOTT"."T_MEMBERSHOWCV" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_MEMBERSHOWCV.nextval INTO :new.M_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_MEMBERSHOWCV
-- ----------------------------
ALTER TABLE "SCOTT"."T_MEMBERSHOWCV" ADD CHECK ("M_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_MEMBERSHOWCV
-- ----------------------------
ALTER TABLE "SCOTT"."T_MEMBERSHOWCV" ADD PRIMARY KEY ("M_ID");

-- ----------------------------
-- Indexes structure for table T_RECRUIT
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_RECRUIT
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_RECRUITTRIG" BEFORE INSERT ON "SCOTT"."T_RECRUIT" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_RECRUIT.nextval INTO :new.R_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_RECRUIT
-- ----------------------------
ALTER TABLE "SCOTT"."T_RECRUIT" ADD CHECK ("R_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_RECRUIT
-- ----------------------------
ALTER TABLE "SCOTT"."T_RECRUIT" ADD PRIMARY KEY ("R_ID");

-- ----------------------------
-- Indexes structure for table T_STATE
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_STATE
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_STATETRIG" BEFORE INSERT ON "SCOTT"."T_STATE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_STATE.nextval INTO :new.S_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_STATE
-- ----------------------------
ALTER TABLE "SCOTT"."T_STATE" ADD CHECK ("S_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_STATE
-- ----------------------------
ALTER TABLE "SCOTT"."T_STATE" ADD PRIMARY KEY ("S_ID");

-- ----------------------------
-- Indexes structure for table T_TRAIN
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_TRAIN
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_TRAINTRIG" BEFORE INSERT ON "SCOTT"."T_TRAIN" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_TRAIN.nextval INTO :new.T_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_TRAIN
-- ----------------------------
ALTER TABLE "SCOTT"."T_TRAIN" ADD CHECK ("T_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_TRAIN
-- ----------------------------
ALTER TABLE "SCOTT"."T_TRAIN" ADD PRIMARY KEY ("T_ID");

-- ----------------------------
-- Indexes structure for table T_TRAINANDDEP
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_TRAINANDDEP
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_TRAINANDDEPTRIG" BEFORE INSERT ON "SCOTT"."T_TRAINANDDEP" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_TRAINANDDEP.nextval INTO :new.TAD_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_TRAINANDDEP
-- ----------------------------
ALTER TABLE "SCOTT"."T_TRAINANDDEP" ADD CHECK ("TAD_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_TRAINANDDEP
-- ----------------------------
ALTER TABLE "SCOTT"."T_TRAINANDDEP" ADD PRIMARY KEY ("TAD_ID");

-- ----------------------------
-- Indexes structure for table T_TRAINANDEMP
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_TRAINANDEMP
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_TRAINANDEMPTRIG" BEFORE INSERT ON "SCOTT"."T_TRAINANDEMP" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_TRAINANDEMP.nextval INTO :new.TAE_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_TRAINANDEMP
-- ----------------------------
ALTER TABLE "SCOTT"."T_TRAINANDEMP" ADD CHECK ("TAE_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_TRAINANDEMP
-- ----------------------------
ALTER TABLE "SCOTT"."T_TRAINANDEMP" ADD PRIMARY KEY ("TAE_ID");

-- ----------------------------
-- Indexes structure for table T_USER
-- ----------------------------
CREATE UNIQUE INDEX "SCOTT"."T_USER_U_UNAME_UINDEX"
ON "SCOTT"."T_USER" ("U_NAME" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Triggers structure for table T_USER
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_USERTRIG" BEFORE INSERT ON "SCOTT"."T_USER" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_USER.nextval INTO :new.U_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_USER
-- ----------------------------
ALTER TABLE "SCOTT"."T_USER" ADD CHECK ("U_ID" IS NOT NULL);
ALTER TABLE "SCOTT"."T_USER" ADD CHECK ("U_NAME" IS NOT NULL);
ALTER TABLE "SCOTT"."T_USER" ADD CHECK ("U_PASS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_USER
-- ----------------------------
ALTER TABLE "SCOTT"."T_USER" ADD PRIMARY KEY ("U_ID");

-- ----------------------------
-- Indexes structure for table T_VITAE
-- ----------------------------

-- ----------------------------
-- Triggers structure for table T_VITAE
-- ----------------------------
CREATE OR REPLACE TRIGGER "SCOTT"."T_VITAETRIG" BEFORE INSERT ON "SCOTT"."T_VITAE" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
    SELECT SEQ_T_VITAE.nextval INTO :new.V_ID FROM dual;
  end;
-- ----------------------------
-- Checks structure for table T_VITAE
-- ----------------------------
ALTER TABLE "SCOTT"."T_VITAE" ADD CHECK ("V_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_VITAE
-- ----------------------------
ALTER TABLE "SCOTT"."T_VITAE" ADD PRIMARY KEY ("V_ID");
