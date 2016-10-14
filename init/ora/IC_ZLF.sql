/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.4.0

Source Server         : 192.168.1.11_1521_ORCL
Source Server Version : 110200
Source Host           : 192.168.1.11:1521
Source Schema         : IC_ZLF

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2016-10-14 15:44:16
*/


-- ----------------------------
-- Table structure for DIC_DICTIONARY
-- ----------------------------
DROP TABLE "IC_ZLF"."DIC_DICTIONARY";
CREATE TABLE "IC_ZLF"."DIC_DICTIONARY" (
"ID" NUMBER(11) NOT NULL ,
"CODE" VARCHAR2(128 BYTE) NULL ,
"TEXT" VARCHAR2(128 BYTE) NULL ,
"DICTYPE_ID" NUMBER(11) NULL ,
"SEQ" NUMBER(5) NULL ,
"STATUS" NUMBER(1) NULL ,
"ISDEFAULT" NUMBER(1) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DIC_DICTIONARY
-- ----------------------------

-- ----------------------------
-- Table structure for DIC_DICTIONARY_TYPE
-- ----------------------------
DROP TABLE "IC_ZLF"."DIC_DICTIONARY_TYPE";
CREATE TABLE "IC_ZLF"."DIC_DICTIONARY_TYPE" (
"ID" NUMBER(11) NOT NULL ,
"CODE" VARCHAR2(128 BYTE) NULL ,
"NAME" VARCHAR2(128 BYTE) NULL ,
"SEQ" NUMBER(11) NULL ,
"DESCRIPTION" VARCHAR2(255 BYTE) NULL ,
"PID" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DIC_DICTIONARY_TYPE
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_RESOURCE
-- ----------------------------
DROP TABLE "IC_ZLF"."SYS_RESOURCE";
CREATE TABLE "IC_ZLF"."SYS_RESOURCE" (
"ID" NUMBER(11) NOT NULL ,
"NAME" VARCHAR2(128 BYTE) NULL ,
"URL" VARCHAR2(100 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(255 BYTE) NULL ,
"ICON" VARCHAR2(64 BYTE) NULL ,
"PID" NUMBER(11) NULL ,
"SEQ" NUMBER(5) NULL ,
"STATUS" NUMBER(1) NULL ,
"RESOURCE_TYPE" NUMBER(1) NULL ,
"CREATE_TIME" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_RESOURCE
-- ----------------------------
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('4', '权限列表', '/permission/index.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('6', '权限添加', '/permission/addPermission.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('7', '权限删除', '/permission/deletePermissionById.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('8', '用户列表', '/member/list.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('9', '在线用户', '/member/online.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('10', '用户Session踢出', '/member/changeSessionStatus.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('11', '用户激活&禁止', '/member/forbidUserById.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('12', '用户删除', '/member/deleteUserById.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('13', '权限分配', '/permission/addPermission2Role.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('14', '用户角色分配清空', '/role/clearRoleByUserIds.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('15', '角色分配保存', '/role/addRole2User.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('16', '角色列表删除', '/role/deleteRoleById.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('17', '角色列表添加', '/role/addRole.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('18', '角色列表', '/role/index.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('19', '权限分配', '/permission/allocation.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('20', '角色分配', '/role/allocation.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('21', '菜单管理', '/resource/page.shtml', null, null, null, null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_RESOURCE" VALUES ('22', '的撒旦', 'mem', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE "IC_ZLF"."SYS_ROLE";
CREATE TABLE "IC_ZLF"."SYS_ROLE" (
"ID" NUMBER(11) NOT NULL ,
"NAME" VARCHAR2(255 BYTE) NULL ,
"SEQ" NUMBER(5) NULL ,
"DESCRIPTION" VARCHAR2(255 BYTE) NULL ,
"ISDEFAULT" NUMBER(1) NULL ,
"TYPE" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO "IC_ZLF"."SYS_ROLE" VALUES ('1', '系统管理员', null, null, null, '888888');
INSERT INTO "IC_ZLF"."SYS_ROLE" VALUES ('3', '权限角色', null, null, null, '100003');
INSERT INTO "IC_ZLF"."SYS_ROLE" VALUES ('4', '用户中心', null, null, null, '100002');

-- ----------------------------
-- Table structure for SYS_ROLE_RESOURCE
-- ----------------------------
DROP TABLE "IC_ZLF"."SYS_ROLE_RESOURCE";
CREATE TABLE "IC_ZLF"."SYS_ROLE_RESOURCE" (
"ROLE_ID" NUMBER(11) NOT NULL ,
"RES_ID" NUMBER(11) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_ROLE_RESOURCE
-- ----------------------------
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '4');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '6');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '7');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '8');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '9');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '10');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '11');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '12');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '13');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '14');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '15');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '16');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '17');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '18');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '19');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '20');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('1', '21');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '4');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '6');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '7');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '13');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '14');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '15');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '16');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '17');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '18');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '19');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('3', '20');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('4', '8');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('4', '9');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('4', '10');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('4', '11');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('4', '12');
INSERT INTO "IC_ZLF"."SYS_ROLE_RESOURCE" VALUES ('30', '22');

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE "IC_ZLF"."SYS_USER";
CREATE TABLE "IC_ZLF"."SYS_USER" (
"ID" NUMBER(11) NOT NULL ,
"NICKNAME" VARCHAR2(50 BYTE) NULL ,
"EMAIL" VARCHAR2(128 BYTE) NULL ,
"PASSWORD" VARCHAR2(128 BYTE) NULL ,
"CREATE_TIME" DATE NULL ,
"LAST_LOGIN_TIME" DATE NULL ,
"STATUS" NUMBER(1) NULL ,
"AGE" NUMBER(5) NULL ,
"GENDER" NUMBER(1) NULL ,
"ISDEFAULT" NUMBER(1) NULL ,
"ORGANIZATION_ID" NUMBER(11) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO "IC_ZLF"."SYS_USER" VALUES ('1', '管理员', 'admin', '57eb72e6b78a87a12d46a7f5e9315138', TO_DATE('2016-06-16 11:15:33', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-10-11 09:23:42', 'YYYY-MM-DD HH24:MI:SS'), '1', null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_USER" VALUES ('11', 'soso', '8446666@qq.com', '57eb72e6b78a87a12d46a7f5e9315138', TO_DATE('2016-05-26 20:50:54', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-06-16 11:24:35', 'YYYY-MM-DD HH24:MI:SS'), '1', null, null, null, null);
INSERT INTO "IC_ZLF"."SYS_USER" VALUES ('12', '8446666', '8446666', '4afdc875a67a55528c224ce088be2ab8', TO_DATE('2016-05-27 22:34:19', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2016-06-15 17:03:16', 'YYYY-MM-DD HH24:MI:SS'), '1', null, null, null, null);

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE "IC_ZLF"."SYS_USER_ROLE";
CREATE TABLE "IC_ZLF"."SYS_USER_ROLE" (
"U_ID" NUMBER(11) NOT NULL ,
"R_ID" NUMBER(11) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO "IC_ZLF"."SYS_USER_ROLE" VALUES ('1', '1');
INSERT INTO "IC_ZLF"."SYS_USER_ROLE" VALUES ('11', '3');
INSERT INTO "IC_ZLF"."SYS_USER_ROLE" VALUES ('11', '4');
INSERT INTO "IC_ZLF"."SYS_USER_ROLE" VALUES ('11', '5');
INSERT INTO "IC_ZLF"."SYS_USER_ROLE" VALUES ('12', '4');
INSERT INTO "IC_ZLF"."SYS_USER_ROLE" VALUES ('15', '1');

-- ----------------------------
-- Sequence structure for IC_SEQ_ID
-- ----------------------------
DROP SEQUENCE "IC_ZLF"."IC_SEQ_ID";
CREATE SEQUENCE "IC_ZLF"."IC_SEQ_ID"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 99999999999
 START WITH 41
 CACHE 20;

-- ----------------------------
-- Indexes structure for table DIC_DICTIONARY
-- ----------------------------

-- ----------------------------
-- Checks structure for table DIC_DICTIONARY
-- ----------------------------
ALTER TABLE "IC_ZLF"."DIC_DICTIONARY" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DIC_DICTIONARY
-- ----------------------------
ALTER TABLE "IC_ZLF"."DIC_DICTIONARY" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table DIC_DICTIONARY_TYPE
-- ----------------------------

-- ----------------------------
-- Checks structure for table DIC_DICTIONARY_TYPE
-- ----------------------------
ALTER TABLE "IC_ZLF"."DIC_DICTIONARY_TYPE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DIC_DICTIONARY_TYPE
-- ----------------------------
ALTER TABLE "IC_ZLF"."DIC_DICTIONARY_TYPE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_RESOURCE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_RESOURCE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_RESOURCE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_RESOURCE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_RESOURCE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE_RESOURCE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_ROLE_RESOURCE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_ROLE_RESOURCE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "IC_ZLF"."SYS_ROLE_RESOURCE" ADD CHECK ("RES_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE_RESOURCE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_ROLE_RESOURCE" ADD PRIMARY KEY ("ROLE_ID", "RES_ID");

-- ----------------------------
-- Indexes structure for table SYS_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_USER
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_USER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_USER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_USER_ROLE" ADD CHECK ("U_ID" IS NOT NULL);
ALTER TABLE "IC_ZLF"."SYS_USER_ROLE" ADD CHECK ("R_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "IC_ZLF"."SYS_USER_ROLE" ADD PRIMARY KEY ("U_ID", "R_ID");
