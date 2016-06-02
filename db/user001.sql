/*
Navicat MySQL Data Transfer

Source Server         : alicloud-test
Source Server Version : 50173
Source Host           : 121.40.172.165:3306
Source Database       : user001

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-05-10 10:48:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `deviceInfo`
-- ----------------------------
DROP TABLE IF EXISTS `deviceInfo`;
CREATE TABLE `deviceInfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `userId` bigint(20) NOT NULL COMMENT '业务唯一数字',
  `lng` varchar(32) NOT NULL COMMENT '经度',
  `lat` varchar(32) NOT NULL COMMENT '纬度',
  `deviceId` varchar(32) NOT NULL COMMENT '设备编号',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `mtime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `userId_index` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户位置信息';

-- ----------------------------
-- Records of deviceInfo
-- ----------------------------
INSERT INTO `deviceInfo` VALUES ('1', '24', '120.137472', '30.271451', 'ebe2fd68c1f92858a5bda7f3fc115d45', '2016-02-01 16:55:43', null);
INSERT INTO `deviceInfo` VALUES ('2', '8', '120.137467', '30.271447', '', '2016-02-01 17:26:24', null);
INSERT INTO `deviceInfo` VALUES ('3', '20', '120.137482', '30.271301', '1ff46e7a02c5320ba3eeb9eca3b4009b', '2016-02-01 18:02:53', null);
INSERT INTO `deviceInfo` VALUES ('4', '4', '120.106670', '30.266612', '3436aa307721a2ac6d7ad0a47d2ab12f', '2016-02-01 18:06:09', null);
INSERT INTO `deviceInfo` VALUES ('5', '32', '120.137520', '30.271162', 'cbe3539d71019ff29c858e1b1456f6ce', '2016-02-01 20:36:24', null);
INSERT INTO `deviceInfo` VALUES ('6', '12', '120.137668', '30.271455', '', '2016-02-02 13:57:06', null);
INSERT INTO `deviceInfo` VALUES ('7', '40', '120.137671', '30.271456', 'b64b1a9a01b70f0993907c0b484a5319', '2016-02-02 14:15:54', null);
INSERT INTO `deviceInfo` VALUES ('8', '16', '120.137756', '30.270937', '727054c8b99e263365b175236a76e542', '2016-02-02 18:04:04', null);
INSERT INTO `deviceInfo` VALUES ('9', '52', '120.137483', '30.271308', 'f50aaaeee8058687bd5303ea5cf77a0c', '2016-02-03 11:09:28', null);
INSERT INTO `deviceInfo` VALUES ('10', '48', '120.1374959309896', '30.27123236762153', '66741dedbb5990c5abe73ec07703c542', '2016-02-03 12:02:45', null);
INSERT INTO `deviceInfo` VALUES ('11', '56', '120.137573', '30.271229', '6007d37316bc32982e271b7da47e7443', '2016-02-03 12:09:38', null);
INSERT INTO `deviceInfo` VALUES ('12', '64', '120.364752', '30.301182', 'e2bba3a4ca8daa00e2bad075984e9ec6', '2016-02-04 14:08:08', null);
INSERT INTO `deviceInfo` VALUES ('13', '68', '120.137383', '30.271160', '3436aa307721a2ac6d7ad0a47d2ab12f', '2016-02-24 19:25:32', null);
INSERT INTO `deviceInfo` VALUES ('15', '84', '120.216109', '30.246342', '2f381a8d39dd98a7f0a778c70692f7ef', '2016-03-08 16:56:56', null);
INSERT INTO `deviceInfo` VALUES ('14', '72', '120.137611', '30.271191', '00bf27480e3493a364560519e79b943d', '2016-02-25 17:17:11', null);
INSERT INTO `deviceInfo` VALUES ('16', '36', '120.159081', '30.177273', 'd8489151639af2c575c423d0e33ac10f', '2016-04-23 13:44:15', null);

-- ----------------------------
-- Table structure for `friendGourp`
-- ----------------------------
DROP TABLE IF EXISTS `friendGourp`;
CREATE TABLE `friendGourp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userId` bigint(20) NOT NULL COMMENT '用户Id',
  `groupName` varchar(16) NOT NULL COMMENT '分组Id',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `mtime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='好友分组表';

-- ----------------------------
-- Records of friendGourp
-- ----------------------------

-- ----------------------------
-- Table structure for `userAccountLog`
-- ----------------------------
DROP TABLE IF EXISTS `userAccountLog`;
CREATE TABLE `userAccountLog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userId` bigint(20) NOT NULL COMMENT '用户Id',
  `nickName` varchar(16) DEFAULT NULL COMMENT '昵称',
  `ctime` datetime NOT NULL COMMENT '时间',
  `toUser` varchar(16) NOT NULL COMMENT '交易对方',
  `amount` decimal(9,2) NOT NULL COMMENT '金额',
  `balanceAvailable` decimal(9,2) NOT NULL COMMENT '可用金额',
  `type` datetime NOT NULL COMMENT '类型@ 产生这条记录的操作',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户资金记录表';

-- ----------------------------
-- Records of userAccountLog
-- ----------------------------

-- ----------------------------
-- Table structure for `userFriends`
-- ----------------------------
DROP TABLE IF EXISTS `userFriends`;
CREATE TABLE `userFriends` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userId` bigint(20) NOT NULL COMMENT '用户Id',
  `fuserId` bigint(20) NOT NULL COMMENT '好友Id',
  `remarkName` varchar(32) DEFAULT NULL COMMENT '备注姓名',
  `groupId` bigint(20) NOT NULL DEFAULT '1' COMMENT '分组Id',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '验证好友状态@ 1 已经添加',
  `ctime` datetime NOT NULL COMMENT '创建时间',
  `mtime` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `index_fuserId` (`fuserId`),
  KEY `index_userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userFriends
-- ----------------------------
INSERT INTO `userFriends` VALUES ('1', '8', '1', null, '1', '1', '2016-02-01 17:36:41', '2016-02-01 17:36:41', null);
INSERT INTO `userFriends` VALUES ('2', '8', '21', null, '0', '0', '2016-02-01 17:40:56', null, null);
INSERT INTO `userFriends` VALUES ('3', '8', '13', null, '1', '1', '2016-02-01 17:48:50', '2016-02-01 17:48:50', null);
INSERT INTO `userFriends` VALUES ('4', '20', '1', null, '0', '0', '2016-02-01 17:57:09', null, null);
INSERT INTO `userFriends` VALUES ('7', '8', '53', null, '1', '1', '2016-02-03 11:48:12', '2016-02-03 11:48:12', null);
INSERT INTO `userFriends` VALUES ('6', '4', '27', null, '1', '1', '2016-02-02 19:31:42', '2016-02-02 19:31:42', null);
INSERT INTO `userFriends` VALUES ('12', '56', '22', null, '1', '1', '2016-02-04 12:12:24', '2016-02-04 12:12:24', null);
INSERT INTO `userFriends` VALUES ('13', '4', '13', null, '1', '1', '2016-02-18 14:55:32', '2016-02-18 14:55:32', null);
INSERT INTO `userFriends` VALUES ('14', '4', '68', null, '1', '1', '2016-03-08 15:33:53', '2016-03-08 15:33:53', null);
INSERT INTO `userFriends` VALUES ('15', '68', '4', null, '1', '1', '2016-03-08 15:33:53', '2016-03-08 15:33:53', null);
INSERT INTO `userFriends` VALUES ('16', '48', '4', null, '1', '1', '2016-03-08 15:35:44', '2016-03-08 15:35:44', null);
INSERT INTO `userFriends` VALUES ('17', '4', '48', null, '1', '1', '2016-03-08 15:35:44', '2016-03-08 15:35:44', null);
INSERT INTO `userFriends` VALUES ('18', '4', '50', null, '1', '1', '2016-03-08 15:38:12', '2016-03-08 15:38:12', null);

-- ----------------------------
-- Table structure for `userInfo`
-- ----------------------------
DROP TABLE IF EXISTS `userInfo`;
CREATE TABLE `userInfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '��������',
  `userId` bigint(20) NOT NULL COMMENT 'ҵ��Ψһ����',
  `signature` varchar(64) DEFAULT NULL COMMENT '����ǩ��',
  `balance` decimal(9,2) DEFAULT '0.00' COMMENT '���',
  `ctime` datetime NOT NULL COMMENT '����ʱ��',
  `mtime` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='�û�������Ϣ';

-- ----------------------------
-- Records of userInfo
-- ----------------------------
INSERT INTO `userInfo` VALUES ('1', '4', null, '620.00', '2016-02-01 15:44:52', '2016-02-03 20:11:10');
INSERT INTO `userInfo` VALUES ('2', '8', 'test03', '54.54', '2016-02-01 15:50:32', '2016-02-01 19:30:23');
INSERT INTO `userInfo` VALUES ('3', '12', null, '0.00', '2016-02-01 15:52:45', '2016-02-01 15:55:31');
INSERT INTO `userInfo` VALUES ('4', '16', '16', '920.00', '2016-02-01 15:55:20', '2016-03-11 15:39:20');
INSERT INTO `userInfo` VALUES ('5', '20', '无个性，不签名；有个性，再签名。', '627.01', '2016-02-01 16:35:04', '2016-03-07 15:58:24');
INSERT INTO `userInfo` VALUES ('6', '24', 'test2316', '0.00', '2016-02-01 16:55:36', '2016-02-01 17:01:02');
INSERT INTO `userInfo` VALUES ('7', '32', null, '0.00', '2016-02-01 20:27:21', '2016-02-03 15:41:15');
INSERT INTO `userInfo` VALUES ('8', '36', null, '0.00', '2016-02-02 10:52:11', null);
INSERT INTO `userInfo` VALUES ('9', '40', null, '0.00', '2016-02-02 14:15:48', null);
INSERT INTO `userInfo` VALUES ('10', '48', null, '5516.53', '2016-02-02 20:04:00', '2016-02-03 11:58:31');
INSERT INTO `userInfo` VALUES ('11', '52', null, '0.00', '2016-02-03 11:09:16', '2016-03-07 14:52:07');
INSERT INTO `userInfo` VALUES ('12', '56', null, '0.00', '2016-02-03 12:01:10', '2016-02-03 13:57:57');
INSERT INTO `userInfo` VALUES ('13', '64', null, '0.00', '2016-02-04 14:08:02', null);
INSERT INTO `userInfo` VALUES ('14', '68', null, '0.00', '2016-02-22 16:12:12', '2016-02-24 19:27:59');
INSERT INTO `userInfo` VALUES ('15', '72', null, '1.00', '2016-02-25 17:15:33', '2016-02-25 17:18:14');
INSERT INTO `userInfo` VALUES ('16', '76', null, '0.00', '0000-00-00 00:00:00', null);
INSERT INTO `userInfo` VALUES ('17', '84', null, '0.00', '2016-03-08 16:56:20', null);
INSERT INTO `userInfo` VALUES ('18', '88', null, '0.00', '2016-03-11 11:01:28', null);

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` bigint(20) NOT NULL COMMENT '业务唯一数字ID',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `nickName` varchar(16) DEFAULT NULL COMMENT '昵称',
  `sex` int(1) DEFAULT '0' COMMENT '性别 男 1  女 2',
  `ctime` datetime NOT NULL COMMENT '注册时间',
  `mtime` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 正常',
  `backgroundImage` varchar(64) DEFAULT '/def/groundLogo.jpg' COMMENT '背景图',
  `treamNum` varchar(32) NOT NULL COMMENT '请客号',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `userSource` varchar(16) NOT NULL COMMENT '用户来源@',
  `height` int(3) DEFAULT NULL COMMENT '身高(cm)',
  `headIcon` varchar(100) DEFAULT NULL COMMENT '头像',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `photo` varchar(1024) DEFAULT NULL COMMENT '相册列表',
  `signature` varchar(128) DEFAULT NULL COMMENT '签名',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '余额',
  `deviceId` varchar(32) DEFAULT NULL,
  `lng` varchar(32) DEFAULT NULL COMMENT '经度',
  `lat` varchar(32) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('164', '13207111717', '姘翠富楸', '2', '2016-04-02 09:47:53', '2016-04-02 09:47:53', '1', null, '13207111717', '2016-04-02 09:47:53', '', null, 'test', '2016-04-02 09:47:53', '0.00', null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('168', '13703755054', '芒果布丁', '2', '2016-04-02 10:58:20', '2016-04-02 10:58:20', '1', null, '13703755054', '2016-04-02 10:58:20', '', null, 'test', '2016-04-02 10:58:20', '0.00', null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('172', '15300851333', '流连苏', '2', '2016-04-05 14:26:38', '2016-04-05 14:26:38', '1', null, '15300851333', '2016-04-05 14:26:38', '', null, 'test', '2016-04-05 14:26:38', '0.00', null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('176', '13020260002', null, null, '2016-04-06 14:30:06', null, '2', null, '13020260002', null, '', null, null, null, '0.00', null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('180', '15708243968', null, '0', '2016-04-22 16:50:41', null, '2', '/def/groundLogo.jpg', '15708243968', null, '', null, null, null, null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('184', '13037905596', null, '0', '2016-04-25 09:54:50', null, '2', '/def/groundLogo.jpg', '13037905596', null, '', null, null, null, null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('188', '15001957230', null, '0', '2016-04-27 11:20:27', null, '2', '/def/groundLogo.jpg', '15001957230', null, '', null, null, null, null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('192', '13807322840', null, '0', '2016-04-27 11:37:24', null, '2', '/def/groundLogo.jpg', '13807322840', null, '', null, null, null, null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('208', '13708403691', '发起者', '1', '2016-04-29 14:00:45', null, '1', '/def/groundLogo.jpg', '13708403691', '2016-04-29 14:00:45', 'junit', null, 'def/a2341a21', '2016-04-29 14:00:45', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('212', '15102027898', '发起者', '1', '2016-04-29 14:02:44', null, '1', '/def/groundLogo.jpg', '15102027898', '2016-04-29 14:02:44', 'junit', null, 'def/a2341a21', '2016-04-29 14:02:44', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('216', '15206252127', '鍙戣捣鑰', '1', '2016-04-29 14:04:19', null, '1', '/def/groundLogo.jpg', '15206252127', '2016-04-29 14:04:19', 'junit', null, 'def/a2341a21', '2016-04-29 14:04:19', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('220', '13501973487', '发起者', '1', '2016-04-29 14:13:46', null, '1', '/def/groundLogo.jpg', '13501973487', '2016-04-29 14:13:46', 'junit', null, 'def/a2341a21', '2016-04-29 14:13:46', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('224', '15104185729', '发起者', '1', '2016-04-29 14:17:16', null, '1', '/def/groundLogo.jpg', '15104185729', '2016-04-29 14:17:16', 'junit', null, 'def/a2341a21', '2016-04-29 14:17:30', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('228', '15103234621', '发起者', '1', '2016-04-29 14:26:31', null, '1', '/def/groundLogo.jpg', '15103234621', '2016-04-29 14:26:31', 'junit', null, 'def/a2341a21', '2016-04-29 14:26:54', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('232', '13708295383', '发起者', '1', '2016-04-29 14:30:19', null, '1', '/def/groundLogo.jpg', '13708295383', '2016-04-29 14:30:19', 'junit', null, 'def/a2341a21', '2016-04-29 14:31:04', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('236', '13201714646', '发起者', '1', '2016-04-29 14:53:52', null, '1', '/def/groundLogo.jpg', '13201714646', '2016-04-29 14:53:52', 'junit', null, 'def/a2341a21', '2016-04-29 14:55:54', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('240', '15105550561', '发起者', '1', '2016-04-29 15:02:42', null, '1', '/def/groundLogo.jpg', '15105550561', '2016-04-29 15:02:42', 'junit', null, 'def/a2341a21', '2016-04-29 15:04:16', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('244', '15001170155', '发起者', '1', '2016-04-29 15:05:23', null, '1', '/def/groundLogo.jpg', '15001170155', '2016-04-29 15:05:23', 'junit', null, 'def/a2341a21', '2016-04-29 15:05:31', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('248', '15207875414', '发起者', '1', '2016-04-29 15:16:37', null, '1', '/def/groundLogo.jpg', '15207875414', '2016-04-29 15:16:37', 'junit', null, 'def/a2341a21', '2016-04-29 15:16:38', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('252', '13603447113', '发起者', '1', '2016-04-29 17:20:17', null, '1', '/def/groundLogo.jpg', '13603447113', '2016-04-29 17:20:17', 'junit', null, 'def/a2341a21', '2016-04-29 17:20:19', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('256', '13700964322', '发起者', '1', '2016-04-29 17:26:17', null, '1', '/def/groundLogo.jpg', '13700964322', '2016-04-29 17:26:17', 'junit', null, 'def/a2341a21', '2016-04-29 17:26:18', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('260', '15502718447', '发起者', '1', '2016-04-29 17:35:27', null, '1', '/def/groundLogo.jpg', '15502718447', '2016-04-29 17:35:27', 'junit', null, 'def/a2341a21', '2016-04-29 17:35:28', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('264', '13000675262', '发起者', '1', '2016-04-29 17:40:44', null, '1', '/def/groundLogo.jpg', '13000675262', '2016-04-29 17:40:44', 'junit', null, 'def/a2341a21', '2016-04-29 17:40:45', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('268', '15955694035', null, '0', '2016-05-03 16:44:53', null, '2', '/def/groundLogo.jpg', '15955694035', null, '', null, null, null, null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('272', '15902984731', '发起者', '1', '2016-05-03 17:12:18', null, '1', '/def/groundLogo.jpg', '15902984731', '2016-05-03 17:12:18', 'junit', null, 'def/a2341a21', '2016-05-03 17:12:18', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('276', '15108838057', '发起者', '1', '2016-05-03 17:21:10', null, '1', '/def/groundLogo.jpg', '15108838057', '2016-05-03 17:21:10', 'junit', null, 'def/a2341a21', '2016-05-03 17:21:10', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('280', '15603585463', '发起者', '1', '2016-05-03 17:25:17', null, '1', '/def/groundLogo.jpg', '15603585463', '2016-05-03 17:25:17', 'junit', null, 'def/a2341a21', '2016-05-03 17:25:17', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('284', '13108171440', '发起者', '1', '2016-05-03 17:30:00', null, '1', '/def/groundLogo.jpg', '13108171440', '2016-05-03 17:30:00', 'junit', null, 'def/a2341a21', '2016-05-03 17:30:00', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('288', '13301868824', '发起者', '1', '2016-05-03 17:33:34', null, '1', '/def/groundLogo.jpg', '13301868824', '2016-05-03 17:33:34', 'junit', null, 'def/a2341a21', '2016-05-03 17:33:34', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('292', '13305631938', '发起者', '1', '2016-05-03 17:35:42', null, '1', '/def/groundLogo.jpg', '13305631938', '2016-05-03 17:35:42', 'junit', null, 'def/a2341a21', '2016-05-03 17:35:42', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('296', '13402495301', '发起者', '1', '2016-05-03 17:36:59', null, '1', '/def/groundLogo.jpg', '13402495301', '2016-05-03 17:36:59', 'junit', null, 'def/a2341a21', '2016-05-03 17:36:59', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('300', '13602433166', '发起者', '1', '2016-05-03 17:53:17', null, '1', '/def/groundLogo.jpg', '13602433166', '2016-05-03 17:53:17', 'junit', null, 'def/a2341a21', '2016-05-03 17:53:17', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('304', '15205088734', '发起者', '1', '2016-05-03 17:56:22', null, '1', '/def/groundLogo.jpg', '15205088734', '2016-05-03 17:56:22', 'junit', null, 'def/a2341a21', '2016-05-03 17:56:22', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('308', '15007396098', '发起者', '1', '2016-05-03 17:57:58', null, '1', '/def/groundLogo.jpg', '15007396098', '2016-05-03 17:57:58', 'junit', null, 'def/a2341a21', '2016-05-03 17:57:58', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('312', '15701488774', '发起者', '1', '2016-05-03 18:01:24', null, '1', '/def/groundLogo.jpg', '15701488774', '2016-05-03 18:01:24', 'junit', null, 'def/a2341a21', '2016-05-03 18:01:24', null, null, '100.00', null, null, null);
INSERT INTO `users` VALUES ('316', '15306082711', '发起者', '1', '2016-05-03 18:09:57', null, '1', '/def/groundLogo.jpg', '15306082711', '2016-05-03 18:09:57', 'junit', null, 'def/a2341a21', '2016-05-03 18:09:57', null, null, '100.00', null, null, null);
INSERT INTO `users` VALUES ('320', '13808695983', '发起者', '1', '2016-05-03 18:11:29', null, '1', '/def/groundLogo.jpg', '13808695983', '2016-05-03 18:11:29', 'junit', null, 'def/a2341a21', '2016-05-03 18:11:29', null, null, '100.00', null, null, null);
INSERT INTO `users` VALUES ('324', '15305790629', '鍙戣捣鑰', '1', '2016-05-04 13:33:16', null, '1', '/def/groundLogo.jpg', '15305790629', '2016-05-04 13:33:16', 'junit', null, 'def/a2341a21', '2016-05-04 13:33:16', null, null, '100.00', null, null, null);
INSERT INTO `users` VALUES ('328', '15002636902', '发起者', '1', '2016-05-04 13:34:59', null, '1', '/def/groundLogo.jpg', '15002636902', '2016-05-04 13:34:59', 'junit', null, 'def/a2341a21', '2016-05-04 13:34:59', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('332', '15907332631', '鍙戣捣鑰', '1', '2016-05-04 13:40:35', null, '1', '/def/groundLogo.jpg', '15907332631', '2016-05-04 13:40:35', 'junit', null, 'def/a2341a21', '2016-05-04 13:40:35', null, null, '300.00', null, null, null);
INSERT INTO `users` VALUES ('336', '13808063374', '发起者', '1', '2016-05-04 13:47:52', null, '1', '/def/groundLogo.jpg', '13808063374', '2016-05-04 13:47:52', 'junit', null, 'def/a2341a21', '2016-05-04 13:47:52', null, null, '400.00', null, null, null);
INSERT INTO `users` VALUES ('340', '15308305559', '发起者', '1', '2016-05-04 13:52:36', null, '1', '/def/groundLogo.jpg', '15308305559', '2016-05-04 13:52:36', 'junit', null, 'def/a2341a21', '2016-05-04 13:52:36', null, null, '100.00', null, null, null);
INSERT INTO `users` VALUES ('344', '13303520044', '发起者', '1', '2016-05-04 14:06:15', null, '1', '/def/groundLogo.jpg', '13303520044', '2016-05-04 14:06:15', 'junit', null, 'def/a2341a21', '2016-05-04 14:06:16', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('348', '15306861503', '发起者', '1', '2016-05-04 14:09:01', null, '1', '/def/groundLogo.jpg', '15306861503', '2016-05-04 14:09:01', 'junit', null, 'def/a2341a21', '2016-05-04 14:09:02', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('352', '15705638114', '发起者', '1', '2016-05-04 14:14:26', null, '1', '/def/groundLogo.jpg', '15705638114', '2016-05-04 14:14:26', 'junit', null, 'def/a2341a21', '2016-05-04 14:14:26', null, null, '200.00', null, null, null);
INSERT INTO `users` VALUES ('356', '15858267521', '避比', '1', '2016-05-04 15:15:30', '2016-05-04 15:17:55', '1', '/def/groundLogo.jpg', '15858267521', '1998-05-04 00:00:00', '', null, 'avatar/164/95D65D018A52C0D28DA94AE451958BB0', '2016-05-04 15:17:55', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('360', '13002882697', '发起者', '1', '2016-05-05 12:11:44', null, '1', '/def/groundLogo.jpg', '13002882697', '2016-05-05 12:11:39', 'junit', null, 'def/a2341a21', '2016-05-05 12:11:50', null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('364', '13020260009', null, '0', '2016-05-09 14:34:51', null, '2', '/def/groundLogo.jpg', '13020260009', null, '', null, null, null, null, null, '0.00', null, null, null);
INSERT INTO `users` VALUES ('368', '13408588533', null, '0', '2016-05-09 14:53:13', null, '2', '/def/groundLogo.jpg', '13408588533', null, 'appStore', null, null, null, null, null, '0.00', null, null, null);
