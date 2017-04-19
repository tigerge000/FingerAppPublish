/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1
 Source Database       : appinfo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 04/01/2017 15:45:12 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_appinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_appinfo`;
CREATE TABLE `t_appinfo` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `os` varchar(10) DEFAULT NULL COMMENT 'iOS,android,other',
  `env` varchar(10) DEFAULT NULL COMMENT '(环境)uat,beta,live',
  `appmode` varchar(10) DEFAULT NULL COMMENT 'debug,release',
  `version` int(15) DEFAULT NULL COMMENT '版本号',
  `branch_name` varchar(100) DEFAULT NULL COMMENT '分支名称',
  `des` varchar(100) DEFAULT NULL COMMENT '描述',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `qrcode_url` varchar(512) DEFAULT NULL,
  `file_url` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
