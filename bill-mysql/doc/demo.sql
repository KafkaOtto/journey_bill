/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 26/01/2021 10:37:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `bill`;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'first name',
  `last_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'last name',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'encoded password',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
  `role` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user role',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `unique_email` (`email`)
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'san', 'zhang', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '1@qq.com', 'USER');
INSERT INTO `user` VALUES (2, 'a', 'b', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '2@qq.com', 'USER');
INSERT INTO `user` VALUES (3, 'c', 'd', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '3@qq.com', 'USER');
INSERT INTO `user` VALUES (5, 'e', 'f', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '4@qq.com', 'USER');
INSERT INTO `user` VALUES (6, 'g', 'h', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '5@qq.com', 'USER');
INSERT INTO `user` VALUES (7, 'i', 'j', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '6@qq.com', 'USER');
INSERT INTO `user` VALUES (8, 'l', 'm', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '7@qq.com', 'USER');
INSERT INTO `user` VALUES (9, 'n', 'o', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '8@qq.com', 'USER');
INSERT INTO `user` VALUES (10, 'p', 'q', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '9@qq.com', 'USER');
INSERT INTO `user` VALUES (11, 'r', 's', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '10@qq.com', 'USER');
INSERT INTO `user` VALUES (17, 't', 'u', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '11@qq.com', 'USER');
INSERT INTO `user` VALUES (18, 'v', 'w', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '12@qq.com', 'USER');
INSERT INTO `user` VALUES (19, 'x', 'y', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '13@qq.com', 'USER');
INSERT INTO `user` VALUES (20, 'z', 'ab', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '14@qq.com', 'USER');
INSERT INTO `user` VALUES (21, 'cd', 'ef', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '15@qq.com', 'USER');
INSERT INTO `user` VALUES (22, 'gh', 'ij', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '16@qq.com', 'USER');
INSERT INTO `user` VALUES (23, 'kl', 'mn', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '17@qq.com', 'USER');
INSERT INTO `user` VALUES (24, 'op', 'qr', '$2a$10$.6mcEOKBNjsOBhHFhHxPDuv2QKscC9KZSqouKa0ZhBtwz6h54dJWq', '18@qq.com', 'USER');

SET FOREIGN_KEY_CHECKS = 1;
