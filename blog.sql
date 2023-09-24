/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 20/09/2023 21:42:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for memory
-- ----------------------------
DROP TABLE IF EXISTS `memory`;
CREATE TABLE `memory`  (
  `memoryId` bigint(20) NOT NULL,
  `memoryTitle` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `video` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `audio` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `addTime` date NULL DEFAULT NULL,
  `userId` bigint(20) NULL DEFAULT NULL,
  `tag_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`memoryId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `firstname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `lastname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (7, '1', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (8, '2', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, '3', '3', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, '7', '7', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (11, '55', '55', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, '44', '44', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (13, '557', '55', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (14, '000', '000', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (15, '0005', '000', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (16, '00050', '000', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (17, '00000', '000', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (18, '123123', '123123', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (19, '155', '155', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (20, '123456@qq.com', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (21, '11', '11', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (22, '445', '44', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (23, '4444444', '4444444', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (24, 'sukang@qq.com', '123456', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (25, '444', '444', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
