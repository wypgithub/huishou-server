/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : huishou

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-08-27 22:53:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cs_collection
-- ----------------------------
DROP TABLE IF EXISTS `cs_collection`;
CREATE TABLE `cs_collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `collection_time` datetime NOT NULL,
  `st_id` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_collection
-- ----------------------------
INSERT INTO `cs_collection` VALUES ('19', '2018-08-27 22:47:28', '1', '2');

-- ----------------------------
-- Table structure for cs_stinfo
-- ----------------------------
DROP TABLE IF EXISTS `cs_stinfo`;
CREATE TABLE `cs_stinfo` (
  `questionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `questiondescribe` varchar(255) NOT NULL,
  `questionanswer` varchar(255) NOT NULL,
  `stnd` float NOT NULL,
  `stzt` int(11) NOT NULL,
  `questionselect` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `questiontype` int(11) NOT NULL,
  `questionknowsid` bigint(20) NOT NULL,
  PRIMARY KEY (`questionid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_stinfo
-- ----------------------------
INSERT INTO `cs_stinfo` VALUES ('1', '地球大小取决于直径1', 'C', '1', '1', '{\r\n	\"A\": \"很小\",\r\n	\"B\": \"很小\",\r\n	\"C\": \"很小\",\r\n	\"D\": \"很小\"\r\n\r\n}', '地球有多大?', '1', '1');
INSERT INTO `cs_stinfo` VALUES ('2', '地球大小取决于直径2', 'A', '1', '1', '{\r\n	\"A\": \"很小\",\r\n	\"B\": \"很小\",\r\n	\"C\": \"很小\",\r\n	\"D\": \"很小\"\r\n\r\n}', '地球有多大?', '1', '1');
INSERT INTO `cs_stinfo` VALUES ('3', '地球大小取决于直径3', 'B', '1', '1', '{\r\n	\"A\": \"很小\",\r\n	\"B\": \"很小\",\r\n	\"C\": \"很小\",\r\n	\"D\": \"很小\"\r\n\r\n}', '地球有多大?', '1', '1');

-- ----------------------------
-- Table structure for cs_xdinfo
-- ----------------------------
DROP TABLE IF EXISTS `cs_xdinfo`;
CREATE TABLE `cs_xdinfo` (
  `xdid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sfkq` int(11) NOT NULL,
  `xdmc` varchar(255) NOT NULL,
  PRIMARY KEY (`xdid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_xdinfo
-- ----------------------------
INSERT INTO `cs_xdinfo` VALUES ('1', '1', '小学');
INSERT INTO `cs_xdinfo` VALUES ('2', '1', '中学');
INSERT INTO `cs_xdinfo` VALUES ('3', '1', '大学');

-- ----------------------------
-- Table structure for cs_xkinfo
-- ----------------------------
DROP TABLE IF EXISTS `cs_xkinfo`;
CREATE TABLE `cs_xkinfo` (
  `xkid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sfkq` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `xknr` varchar(255) NOT NULL,
  `xdid` bigint(20) NOT NULL,
  PRIMARY KEY (`xkid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_xkinfo
-- ----------------------------
INSERT INTO `cs_xkinfo` VALUES ('1', '1', 'yw', '语文', '1');
INSERT INTO `cs_xkinfo` VALUES ('2', '1', 'sx', '数学', '1');
INSERT INTO `cs_xkinfo` VALUES ('3', '1', 'yy', '英语', '1');
INSERT INTO `cs_xkinfo` VALUES ('4', '1', 'wl', '物理', '1');

-- ----------------------------
-- Table structure for cs_xninfo
-- ----------------------------
DROP TABLE IF EXISTS `cs_xninfo`;
CREATE TABLE `cs_xninfo` (
  `xnid` bigint(20) NOT NULL AUTO_INCREMENT,
  `sfkq` int(11) NOT NULL,
  `xnnr` varchar(255) NOT NULL,
  `xkid` int(11) NOT NULL,
  PRIMARY KEY (`xnid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_xninfo
-- ----------------------------
INSERT INTO `cs_xninfo` VALUES ('1', '1', '第一学期', '1');
INSERT INTO `cs_xninfo` VALUES ('2', '1', '第二学期', '1');

-- ----------------------------
-- Table structure for cs_zjinfo
-- ----------------------------
DROP TABLE IF EXISTS `cs_zjinfo`;
CREATE TABLE `cs_zjinfo` (
  `zjid` bigint(20) NOT NULL AUTO_INCREMENT,
  `xknr` varchar(255) NOT NULL,
  `ylxn` int(11) NOT NULL,
  PRIMARY KEY (`zjid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_zjinfo
-- ----------------------------
INSERT INTO `cs_zjinfo` VALUES ('1', '第一章', '1');
INSERT INTO `cs_zjinfo` VALUES ('2', '第二章', '1');

-- ----------------------------
-- Table structure for cs_zsdinfo
-- ----------------------------
DROP TABLE IF EXISTS `cs_zsdinfo`;
CREATE TABLE `cs_zsdinfo` (
  `zsdxh` bigint(20) NOT NULL AUTO_INCREMENT,
  `zsdmc` varchar(255) NOT NULL,
  `ylzj` int(11) NOT NULL,
  PRIMARY KEY (`zsdxh`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_zsdinfo
-- ----------------------------
INSERT INTO `cs_zsdinfo` VALUES ('1', '大灰狼的故事', '1');
INSERT INTO `cs_zsdinfo` VALUES ('2', '99乘法口诀', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `balance` double DEFAULT NULL,
  `integral` double DEFAULT NULL,
  `mi_bao` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registered_date` datetime NOT NULL,
  `school` varchar(255) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `vip_term` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
