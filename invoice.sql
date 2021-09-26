/*
 Navicat Premium Data Transfer

 Source Server         : db_invoice
 Source Server Type    : PostgreSQL
 Source Server Version : 120008
 Source Host           : localhost:5433
 Source Catalog        : db_invoice
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120008
 File Encoding         : 65001

 Date: 26/09/2021 00:26:39
*/


-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS "public"."invoice";
CREATE TABLE "public"."invoice" (
  "id_invoice" int8 NOT NULL DEFAULT nextval('invoice_id_invoice_seq'::regclass),
  "amount" numeric(10,2),
  "state" int4
)
;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO "public"."invoice" VALUES (7, 15000.00, 1);
INSERT INTO "public"."invoice" VALUES (3, 5500.00, 1);
INSERT INTO "public"."invoice" VALUES (6, 10000.00, 1);
INSERT INTO "public"."invoice" VALUES (2, 6000.00, 1);
INSERT INTO "public"."invoice" VALUES (1, 5000.00, 2);
INSERT INTO "public"."invoice" VALUES (4, 4500.00, 1);
INSERT INTO "public"."invoice" VALUES (5, 2500.00, 1);

-- ----------------------------
-- Primary Key structure for table invoice
-- ----------------------------
ALTER TABLE "public"."invoice" ADD CONSTRAINT "invoice_pkey" PRIMARY KEY ("id_invoice");
