/*
 Navicat Premium Data Transfer

 Source Server         : db_operation
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3309
 Source Schema         : db_operation

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 26/09/2021 00:25:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation`  (
  `id_operation` mediumint NOT NULL AUTO_INCREMENT,
  `id_invoice` bigint NULL DEFAULT NULL,
  `amount` decimal(10, 2) NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id_operation`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operation
-- ----------------------------
INSERT INTO `operation` VALUES (42, 1, 5000.00, '2021-09-25 17:31:55');
INSERT INTO `operation` VALUES (53, 7, 15000.00, '2021-09-25 17:31:55');

SET FOREIGN_KEY_CHECKS = 1;
