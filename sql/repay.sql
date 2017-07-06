/*
Navicat MySQL Data Transfer

Source Server         : fg
Source Server Version : 50717
Source Host           : localhost:5433
Source Database       : repay

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-06 14:19:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for budget
-- ----------------------------
DROP TABLE IF EXISTS `budget`;
CREATE TABLE `budget` (
  `budgetId` int(11) NOT NULL,
  `projectId` int(11) DEFAULT NULL,
  `budgetSum` float(8,2) DEFAULT NULL,
  `independentFees` float(8,2) DEFAULT NULL,
  `applyFees` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`budgetId`),
  KEY `FK_Relationship_4` (`projectId`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of budget
-- ----------------------------

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemId` int(11) NOT NULL,
  `itemName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for itembudget
-- ----------------------------
DROP TABLE IF EXISTS `itembudget`;
CREATE TABLE `itembudget` (
  `itemBudgetId` int(11) NOT NULL,
  `budgetId` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  `itemBudgetCost` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`itemBudgetId`),
  KEY `FK_Relationship_12` (`itemId`),
  KEY `FK_Relationship_13` (`budgetId`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`budgetId`) REFERENCES `budget` (`budgetId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itembudget
-- ----------------------------

-- ----------------------------
-- Table structure for itemcost
-- ----------------------------
DROP TABLE IF EXISTS `itemcost`;
CREATE TABLE `itemcost` (
  `itemCostId` int(11) NOT NULL,
  `summaryId` int(11) DEFAULT NULL,
  `schoolItemId` int(11) DEFAULT NULL,
  `itemCostName` varchar(20) DEFAULT NULL,
  `itemCost` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`itemCostId`),
  KEY `FK_Relationship_10` (`schoolItemId`),
  KEY `FK_Relationship_9` (`summaryId`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`schoolItemId`) REFERENCES `schoolitem` (`schoolItemId`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`summaryId`) REFERENCES `summary` (`summaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemcost
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `projectId` int(11) NOT NULL,
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
  PRIMARY KEY (`projectId`),
  KEY `FK_Relationship_2` (`userId`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for repay
-- ----------------------------
DROP TABLE IF EXISTS `repay`;
CREATE TABLE `repay` (
  `repayId` int(11) NOT NULL,
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
  KEY `FK_Relationship_6` (`projectId`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repay
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(10) DEFAULT NULL,
  `rolePermissions` varchar(100) DEFAULT NULL,
  `roleDescription` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for schoolitem
-- ----------------------------
DROP TABLE IF EXISTS `schoolitem`;
CREATE TABLE `schoolitem` (
  `schoolItemId` int(11) NOT NULL,
  `itemId` int(11) DEFAULT NULL,
  `schoolItemName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`schoolItemId`),
  KEY `FK_Relationship_11` (`itemId`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`itemId`) REFERENCES `item` (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoolitem
-- ----------------------------

-- ----------------------------
-- Table structure for summary
-- ----------------------------
DROP TABLE IF EXISTS `summary`;
CREATE TABLE `summary` (
  `summaryId` int(11) NOT NULL,
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
  PRIMARY KEY (`summaryId`),
  KEY `FK_Relationship_8` (`userId`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of summary
-- ----------------------------

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
  `travelId` int(11) NOT NULL,
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
  KEY `FK_Relationship_7` (`repayId`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`repayId`) REFERENCES `repay` (`repayId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of travel
-- ----------------------------

-- ----------------------------
-- Table structure for traveluser
-- ----------------------------
DROP TABLE IF EXISTS `traveluser`;
CREATE TABLE `traveluser` (
  `travelUserId` int(11) NOT NULL,
  `repayId` int(255) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userJob` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`travelUserId`),
  KEY `11` (`repayId`),
  CONSTRAINT `11` FOREIGN KEY (`repayId`) REFERENCES `repay` (`repayId`)
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
  KEY `FK_Relationship_1` (`roleId`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
