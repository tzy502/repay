/*
Navicat MySQL Data Transfer

Source Server         : fg
Source Server Version : 50717
Source Host           : localhost:5433
Source Database       : repay

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-11 09:10:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for budget
-- ----------------------------
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `budgetId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `budgetSum` float(8,2) DEFAULT NULL,
  `independentFees` float(8,2) DEFAULT NULL,
  `applyFees` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`budgetId`),
  KEY `FK_Relationship_4` (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of budget
-- ----------------------------
INSERT INTO `budget` VALUES ('19', '10', '4.00', '2.00', '2.00');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '设备费');
INSERT INTO `item` VALUES ('2', '差旅费');
INSERT INTO `item` VALUES ('3', '会议费');
INSERT INTO `item` VALUES ('4', '材料费');
INSERT INTO `item` VALUES ('6', '劳务费');

-- ----------------------------
-- Table structure for itembudget
-- ----------------------------
DROP TABLE IF EXISTS `itembudget`;
CREATE TABLE `itembudget` (
  `itemBudgetId` int(11) NOT NULL AUTO_INCREMENT,
  `budgetId` int(11) DEFAULT NULL,
  `oItemId` int(11) DEFAULT NULL,
  `itemName` varchar(20) DEFAULT NULL,
  `itemBudgetCost` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`itemBudgetId`),
  KEY `FK_Relationship_12` (`itemName`),
  KEY `FK_Relationship_13` (`budgetId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itembudget
-- ----------------------------
INSERT INTO `itembudget` VALUES ('17', '19', '1', '设备费', '1.00');
INSERT INTO `itembudget` VALUES ('18', '19', '2', '差旅费', '2.00');
INSERT INTO `itembudget` VALUES ('19', '19', '3', '会议费', '1.00');
INSERT INTO `itembudget` VALUES ('20', '19', '4', '材料费', '1.00');

-- ----------------------------
-- Table structure for itemcost
-- ----------------------------
DROP TABLE IF EXISTS `itemcost`;
CREATE TABLE `itemcost` (
  `itemCostId` int(11) NOT NULL AUTO_INCREMENT,
  `summaryId` int(11) DEFAULT NULL,
  `oItemId` int(11) DEFAULT NULL,
  `itemCostName` varchar(20) DEFAULT NULL,
  `itemCost` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`itemCostId`),
  KEY `FK_Relationship_10` (`oItemId`),
  KEY `FK_Relationship_9` (`summaryId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemcost
-- ----------------------------
INSERT INTO `itemcost` VALUES ('4', '3', '1', '办公用品', '1.00');
INSERT INTO `itemcost` VALUES ('5', '3', '1', '通讯，邮寄费用', '2.00');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) DEFAULT NULL,
  `projectName` varchar(20) DEFAULT NULL,
  `projectType` varchar(20) DEFAULT NULL,
  `projectTypeId` varchar(20) DEFAULT NULL,
  `field` varchar(20) DEFAULT NULL,
  `fieldId` varchar(20) DEFAULT NULL,
  `source` varchar(20) DEFAULT NULL,
  `sourceId` varchar(20) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `isBudget` int(11) DEFAULT NULL,
  PRIMARY KEY (`projectId`),
  KEY `FK_Relationship_2` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('10', 'user', 'xamg1', 'das', '2w1', 'sda', 'sdas12', 'dsa', 'das', '2016-05-09', '2015-05-10', '3');

-- ----------------------------
-- Table structure for repay
-- ----------------------------
DROP TABLE IF EXISTS `repay`;
CREATE TABLE `repay` (
  `repayId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `company` varchar(10) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `annex` int(11) DEFAULT NULL,
  `annexPath` varchar(30) DEFAULT NULL,
  `checkDays` int(11) DEFAULT NULL,
  `checkPlane` float(8,2) DEFAULT NULL,
  `checkTrain` float(8,2) DEFAULT NULL,
  `checkTOther` float(8,2) DEFAULT NULL,
  `checkStay` float(8,2) DEFAULT NULL,
  `checkFood` float(8,2) DEFAULT NULL,
  `checkMi` float(8,2) DEFAULT NULL,
  `checkOther` float(8,2) DEFAULT NULL,
  `sum` float(8,2) DEFAULT NULL,
  `approvalId` varchar(10) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `applicationId` varchar(10) DEFAULT NULL,
  `cardNumber` varchar(20) DEFAULT NULL,
  `money` float(8,2) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `workerId` varchar(20) DEFAULT NULL,
  `auditor` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`repayId`),
  KEY `FK_Relationship_6` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repay
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(10) DEFAULT NULL,
  `rolePermissions` varchar(100) DEFAULT NULL,
  `roleDescription` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', null, null);

-- ----------------------------
-- Table structure for schoolitem
-- ----------------------------
DROP TABLE IF EXISTS `schoolitem`;
CREATE TABLE `schoolitem` (
  `schoolItemId` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) DEFAULT NULL,
  `schoolItemName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`schoolItemId`),
  KEY `FK_Relationship_11` (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoolitem
-- ----------------------------
INSERT INTO `schoolitem` VALUES ('1', '1', '办公用品');
INSERT INTO `schoolitem` VALUES ('2', '1', '通讯，邮寄费用');

-- ----------------------------
-- Table structure for summary
-- ----------------------------
DROP TABLE IF EXISTS `summary`;
CREATE TABLE `summary` (
  `summaryId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(10) DEFAULT NULL,
  `company` varchar(20) DEFAULT NULL,
  `projectId` varchar(20) DEFAULT NULL,
  `billCount` int(11) DEFAULT NULL,
  `sum` float(8,2) DEFAULT NULL,
  `workerId` varchar(20) DEFAULT NULL,
  `userName` varchar(10) DEFAULT NULL,
  `cardNumber` varchar(20) DEFAULT NULL,
  `money` float(8,2) DEFAULT NULL,
  `manager` varchar(20) DEFAULT NULL,
  `applicationId` varchar(20) DEFAULT NULL,
  `applicationDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`summaryId`),
  KEY `FK_Relationship_8` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of summary
-- ----------------------------
INSERT INTO `summary` VALUES ('3', 'user', 'wqe', '10', '1', '3.00', '323', 'sdaa', '12321312', '12.00', '', '', null);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
  `travelId` int(11) NOT NULL AUTO_INCREMENT,
  `repayId` int(11) DEFAULT NULL,
  `travelLocation` varchar(10) DEFAULT NULL,
  `travelProvince` varchar(10) DEFAULT NULL,
  `startData` date DEFAULT NULL,
  `endData` date DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  `plane` float(8,2) DEFAULT NULL,
  `train` float(8,2) DEFAULT NULL,
  `tasfficOther` char(10) DEFAULT NULL,
  `stayFees` float(8,2) DEFAULT NULL,
  `foodFees` float(8,2) DEFAULT NULL,
  `miFess` float(8,2) DEFAULT NULL,
  `other` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`travelId`),
  KEY `FK_Relationship_7` (`repayId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travel
-- ----------------------------

-- ----------------------------
-- Table structure for traveluser
-- ----------------------------
DROP TABLE IF EXISTS `traveluser`;
CREATE TABLE `traveluser` (
  `travelUserId` int(11) NOT NULL AUTO_INCREMENT,
  `repayId` int(255) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userJob` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`travelUserId`),
  KEY `11` (`repayId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of traveluser
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(10) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `userName` varchar(10) DEFAULT NULL,
  `userJob` varchar(10) DEFAULT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_Relationship_1` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'dasd', null, null, null);
INSERT INTO `user` VALUES ('user', '0', 'mks', 'job', '1234564655', 'ICy5YqxZB1uWSwcVLSNLcA==');
