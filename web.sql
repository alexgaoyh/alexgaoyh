/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50612
Source Host           : 127.0.0.1:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2014-10-13 17:00:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sysman_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sysman_resource`;
CREATE TABLE `sysman_resource` (
  `pid` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `href` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `resourceType` int(11) DEFAULT NULL,
  `p_menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKA95124A0952CD7E7` (`p_menu_id`),
  CONSTRAINT `FKA95124A0952CD7E7` FOREIGN KEY (`p_menu_id`) REFERENCES `sysman_resource` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysman_resource
-- ----------------------------
INSERT INTO `sysman_resource` VALUES ('1', '2014-08-27 16:05:40', '0', '系统管理', '/', '系统管理', '1', '1', null);
INSERT INTO `sysman_resource` VALUES ('2', '2014-10-13 15:40:58', '0', '角色管理', '/admin/sysmanRole/list', '角色管理', '2', '1', '5');
INSERT INTO `sysman_resource` VALUES ('3', '2014-10-13 15:40:53', '0', '用户管理', '/admin/sysmanUser/list', '用户管理', '1', '1', '5');
INSERT INTO `sysman_resource` VALUES ('4', '2014-10-13 15:41:02', '0', '资源管理', '/admin/sysmanResource/list', '资源管理', '3', '1', '5');
INSERT INTO `sysman_resource` VALUES ('5', '2014-10-13 15:40:45', '0', '账号管理', '/', '账号管理', '1', '1', '1');
INSERT INTO `sysman_resource` VALUES ('6', '2014-10-13 15:50:53', '0', 'a', '/a', 'a', '2', '1', '1');

-- ----------------------------
-- Table structure for `sysman_role`
-- ----------------------------
DROP TABLE IF EXISTS `sysman_role`;
CREATE TABLE `sysman_role` (
  `pid` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `creater_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK7D89020860C1C1FC` (`creater_id`),
  CONSTRAINT `FK7D89020860C1C1FC` FOREIGN KEY (`creater_id`) REFERENCES `sysman_user` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysman_role
-- ----------------------------
INSERT INTO `sysman_role` VALUES ('1', '2014-10-13 15:51:07', '0', '系统管理员', '系统管理员', null);

-- ----------------------------
-- Table structure for `sysman_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sysman_role_resource`;
CREATE TABLE `sysman_role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  KEY `FK17BAC656127E527` (`role_id`),
  KEY `FK17BAC653B9CBFA7` (`resource_id`),
  CONSTRAINT `FK17BAC653B9CBFA7` FOREIGN KEY (`resource_id`) REFERENCES `sysman_resource` (`pid`),
  CONSTRAINT `FK17BAC656127E527` FOREIGN KEY (`role_id`) REFERENCES `sysman_role` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysman_role_resource
-- ----------------------------
INSERT INTO `sysman_role_resource` VALUES ('1', '5');
INSERT INTO `sysman_role_resource` VALUES ('1', '3');
INSERT INTO `sysman_role_resource` VALUES ('1', '2');
INSERT INTO `sysman_role_resource` VALUES ('1', '4');

-- ----------------------------
-- Table structure for `sysman_user`
-- ----------------------------
DROP TABLE IF EXISTS `sysman_user`;
CREATE TABLE `sysman_user` (
  `pid` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `position_desc` varchar(100) DEFAULT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `creater_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK7D8A6D5D60C1C1FC` (`creater_id`),
  CONSTRAINT `FK7D8A6D5D60C1C1FC` FOREIGN KEY (`creater_id`) REFERENCES `sysman_user` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysman_user
-- ----------------------------
INSERT INTO `sysman_user` VALUES ('1', '2014-09-24 09:48:16', '0', 'ab', '21232f297a57a5a743894a0e4a801fc3', 'a', 'a', 'a', 'admim', '1', 'admin', null);

-- ----------------------------
-- Table structure for `sysman_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sysman_user_role`;
CREATE TABLE `sysman_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKD0596186127E527` (`role_id`),
  KEY `FKD059618652A907` (`user_id`),
  CONSTRAINT `FKD0596186127E527` FOREIGN KEY (`role_id`) REFERENCES `sysman_role` (`pid`),
  CONSTRAINT `FKD059618652A907` FOREIGN KEY (`user_id`) REFERENCES `sysman_user` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysman_user_role
-- ----------------------------
INSERT INTO `sysman_user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `test_entity`
-- ----------------------------
DROP TABLE IF EXISTS `test_entity`;
CREATE TABLE `test_entity` (
  `pid` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `delete_flag` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_entity
-- ----------------------------
