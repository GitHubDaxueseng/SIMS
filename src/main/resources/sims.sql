/*
Navicat MySQL Data Transfer

Source Server         : MyProject
Source Server Version : 50162
Source Host           : 127.0.0.1:3306
Source Database       : sims

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-12-14 13:35:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `TEACHER` varchar(255) DEFAULT NULL,
  `TEACHER_PWD` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `CLASSES_ID` int(255) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `GRADE` int(10) DEFAULT NULL,
  `TEACHER` varchar(255) DEFAULT NULL,
  `SCHOOL_ID` int(255) DEFAULT NULL,
  PRIMARY KEY (`CLASSES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=50130102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('50010101', '网络工程1班', '2015', '于显平', '5001');
INSERT INTO `classes` VALUES ('50010102', '软工1班', '2015', '李明', '5001');
INSERT INTO `classes` VALUES ('50010103', '计科3班', '2015', '高秀芝', '5001');
INSERT INTO `classes` VALUES ('50010104', '计科2班', '2015', '魏然', '5001');
INSERT INTO `classes` VALUES ('50010105', '信管1班', '2015', '简玉凡', '5001');
INSERT INTO `classes` VALUES ('50020101', '生科2班', '2015', '邢康宁', '5002');
INSERT INTO `classes` VALUES ('50020106', '信管2班', '2015', '王佳乐', '5001');
INSERT INTO `classes` VALUES ('50030101', '物理1班', '2015', '张吉娜', '5003');
INSERT INTO `classes` VALUES ('50040101', '地科1班', '2015', '李杰文', '5004');
INSERT INTO `classes` VALUES ('50050101', '旅游管理1班', '2015', '廖佳明', '5005');
INSERT INTO `classes` VALUES ('50060101', '社会工作1班', '2015', '王瑞新', '5006');
INSERT INTO `classes` VALUES ('50070101', '汉语言文学2班', '2015', '杜飞', '5007');
INSERT INTO `classes` VALUES ('50080101', '音乐学1班', '2015', '赵一帆', '5008');
INSERT INTO `classes` VALUES ('50090101', '法学1班', '2015', '李虹', '5009');
INSERT INTO `classes` VALUES ('50100101', '数学与应用数学1班', '2015', '陈卫荣', '5010');
INSERT INTO `classes` VALUES ('50110101', '自然保护与环境生态类', '2015', '李宇飞', '5011');
INSERT INTO `classes` VALUES ('50120101', '服装设计与工程', '2015', '王雪婷', '5012');
INSERT INTO `classes` VALUES ('50130101', '生物技术', '2015', '曾艳', '5013');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `SCHOOL_ID` int(255) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SCHOOL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('5001', '计算机与信息科学学院');
INSERT INTO `school` VALUES ('5002', '生命科学学院');
INSERT INTO `school` VALUES ('5003', '物理学院');
INSERT INTO `school` VALUES ('5004', '地理学院');
INSERT INTO `school` VALUES ('5005', '经济管理学院');
INSERT INTO `school` VALUES ('5006', '文化与社会发展学院');
INSERT INTO `school` VALUES ('5007', '文学院');
INSERT INTO `school` VALUES ('5008', '音乐学院');
INSERT INTO `school` VALUES ('5009', '法学院');
INSERT INTO `school` VALUES ('5010', '数学与统计学院');
INSERT INTO `school` VALUES ('5011', '资源环境学院');
INSERT INTO `school` VALUES ('5012', '纺织服装学院');
INSERT INTO `school` VALUES ('5013', '生物技术学院');
INSERT INTO `school` VALUES ('5014', '商贸学院');
INSERT INTO `school` VALUES ('5015', '动物科学学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `STUDENT_ID` varchar(255) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `CITIZEN_ID` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `POLITICAL_STATUS` varchar(255) DEFAULT NULL,
  `GRADE` int(10) DEFAULT NULL,
  `CLASSES_ID` int(255) DEFAULT NULL,
  `SCHOOL_ID` int(255) DEFAULT NULL,
  `STUDENT_PWD` varchar(255) DEFAULT '111111',
  PRIMARY KEY (`STUDENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('222015602053001', '金小美', '女', '2017-12-14 12:31:54', '13579796464', '湖南省', '团员', '2014', '50010103', '5014', '111111');
INSERT INTO `student` VALUES ('222015602053002', '陈爱明', '男', '2017-12-14 12:31:54', '15578781578', '贵州省', '党员', '2015', '50010103', '5014', '111111');
INSERT INTO `student` VALUES ('222015602053003', '洪金宝', '女', '2017-12-14 12:31:54', '18878963257', '湖南省', '团员', '2016', '50010103', '5014', '111111');
INSERT INTO `student` VALUES ('222015602053004', '毒舌攀', '男', '2017-12-14 12:31:54', '13388888888', '贵州省', '党员', '2017', '50010103', '5014', '111111');
INSERT INTO `student` VALUES ('222015602053005', '小旺旺', '女', '2017-12-14 12:31:54', '13579796464', '湖南省', '团员', '2018', '50010103', '5014', '111111');
INSERT INTO `student` VALUES ('222015602053006', '小梦龙', '男', '2017-12-14 12:31:54', '15578781578', '贵州省', '党员', '2019', '50010103', '5014', '111111');
INSERT INTO `student` VALUES ('50010101016', '周俊', '男', '2008-11-01 00:00:00', '142733199310260043', '四川', '团员', '2015', '50010101', '5001', '111111');
INSERT INTO `student` VALUES ('50010101018', '陈思美', '女', '2008-11-01 00:00:00', '320325197307032518', '重庆', '党员', '2015', '50010101', '5001', '111111');
INSERT INTO `student` VALUES ('50010101020', '张学双', '女', '2008-11-01 00:00:00', '522728197010110036', '湖南', '团员', '2015', '50010101', '5001', '111111');
INSERT INTO `student` VALUES ('50010101021', '周景会', '男', '2008-11-01 00:00:00', '452124196909293626', '贵州', '团员', '2015', '50010101', '5001', '111111');
INSERT INTO `student` VALUES ('50010101023', '胡景红', '男', '2008-11-01 00:00:00', '522628195812220013', '四川', '团员', '2015', '50010101', '5001', '111111');
INSERT INTO `student` VALUES ('50010102003', '刘浪', '女', '2008-11-01 00:00:00', '111202200806122321', '湖南', '党员', '2015', '50010102', '5001', '111111');
INSERT INTO `student` VALUES ('50010102004', '陈思', '女', '2008-11-01 00:00:00', '621211200812314587', '湖南', '群众', '2015', '50010102', '5001', '111111');
INSERT INTO `student` VALUES ('50010102006', '马大佬', '男', '2008-11-01 00:00:00', '521211200812314587', '四川', '团员', '2015', '50010102', '5001', '111111');
INSERT INTO `student` VALUES ('50010103004', '王昭君', '男', '2017-12-14 00:00:00', '50010103004', '湖南省', '团员', '2015', '50010101', '5014', '111111');
