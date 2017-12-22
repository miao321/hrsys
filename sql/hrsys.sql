/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : hrsys

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-12-21 21:49:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_module`
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `moduleId` varchar(20) NOT NULL,
  `parentId` varchar(20) NOT NULL,
  `parentName` varchar(20) NOT NULL COMMENT '父节点名字',
  `moduleName` varchar(20) NOT NULL COMMENT '模块名',
  `layerNum` int(10) DEFAULT NULL COMMENT '层数',
  `isLeay` int(10) DEFAULT NULL COMMENT '是否是叶子节点',
  `cpermission` varchar(20) DEFAULT NULL COMMENT '权限标识',
  `state` int(10) DEFAULT NULL COMMENT '状态',
  `belong` varchar(50) DEFAULT NULL COMMENT '从属',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `orderNo` int(10) DEFAULT NULL COMMENT '排序号',
  `createBy` varchar(20) DEFAULT NULL COMMENT '创建人',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `updateBy` varchar(20) DEFAULT NULL COMMENT '修改人',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`moduleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------

-- ----------------------------
-- Table structure for `t_organization`
-- ----------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
  `organizationId` varchar(20) NOT NULL,
  `deptId` int(20) NOT NULL COMMENT '部门编号',
  `deptName` varchar(20) NOT NULL COMMENT '部门名称',
  `deptPhone` int(12) NOT NULL COMMENT '部门联系电话',
  `deptEmail` varchar(30) DEFAULT NULL COMMENT '部门传真号',
  `deptGrade` varchar(4) NOT NULL COMMENT '部门级别',
  `deptOlder` varchar(8) DEFAULT NULL COMMENT '部门负责人',
  `createBy` varchar(20) DEFAULT NULL COMMENT '创建人',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '批准成立时间',
  `updateBy` varchar(20) DEFAULT NULL COMMENT '修改人',
  `updateTime` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `deptSign` varchar(4) DEFAULT NULL COMMENT '部门标记，0：停用还，1：启用',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`organizationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_organization
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleId` varchar(20) NOT NULL,
  `roleName` varchar(20) NOT NULL COMMENT '角色名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `orderNo` int(20) DEFAULT NULL COMMENT '排序号',
  `createBy` varchar(20) DEFAULT NULL COMMENT '创建人',
  `createModule` varchar(20) DEFAULT NULL COMMENT '创建模块',
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `updateBy` varchar(20) DEFAULT NULL COMMENT '修改人',
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` varchar(20) NOT NULL,
  `userNo` varchar(30) NOT NULL COMMENT '职员编号',
  `userName` varchar(20) NOT NULL COMMENT '用户姓名',
  `userNickName` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `birthday` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出生日期',
  `age` int(4) NOT NULL COMMENT '年龄',
  `nativePlace` varchar(30) NOT NULL COMMENT '籍贯',
  `nation` varchar(20) NOT NULL COMMENT '民族',
  `culture` varchar(50) NOT NULL COMMENT '文化程度',
  `college` varchar(20) NOT NULL COMMENT '毕业学校',
  `body` varchar(8) NOT NULL DEFAULT '' COMMENT '健康情况',
  `marriage` varchar(10) NOT NULL COMMENT '婚姻状况',
  `idCard` varchar(20) NOT NULL COMMENT '身份证号码',
  `phone` varchar(12) NOT NULL COMMENT '手机号',
  `familyPhone` varchar(12) DEFAULT NULL COMMENT '家庭电话',
  `email` varchar(20) NOT NULL COMMENT '电子邮箱地址',
  `userAccount` varchar(20) NOT NULL COMMENT '职工账号',
  `deptId` int(20) NOT NULL COMMENT '部门编号',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
