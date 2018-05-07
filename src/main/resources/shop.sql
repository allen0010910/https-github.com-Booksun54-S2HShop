/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50716
Source Host           : 120.77.223.41:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-05-07 16:11:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for GOODS
-- ----------------------------
DROP TABLE IF EXISTS `GOODS`;
CREATE TABLE `GOODS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `NAME` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `PIC` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `SAMARY` varchar(255) DEFAULT NULL COMMENT '商品简介',
  `TYPE` varchar(11) DEFAULT NULL COMMENT '商品类型',
  `PRICE` float(100,2) DEFAULT NULL COMMENT '商品零售价',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of GOODS
-- ----------------------------
INSERT INTO `GOODS` VALUES ('42', '雪碧', 'pic\\7f981831-94f3-484b-a8f2-708ca4b7e1ed.jpg', '好喝的雪碧', '饮料', '3.00');
INSERT INTO `GOODS` VALUES ('43', '芬达', 'pic\\8aed1317-a190-4276-825d-b55670b26731.jpg', '好喝的芬达', '饮料', '3.00');
INSERT INTO `GOODS` VALUES ('59', '可乐', 'pic\\3124047b-1f62-44b6-abca-5708e2c6b6a9.jpg', '好喝的可乐', '饮料', '2.00');
INSERT INTO `GOODS` VALUES ('60', '小可乐', 'pic\\e4273a69-c304-4b49-9234-6c4eb843c355.jpg', '好喝的小可乐', '饮料', '3.00');
INSERT INTO `GOODS` VALUES ('61', '合味道', 'pic\\95ced9c1-f9a1-427f-9b14-e3750e87321c.jpg', '进口的泡面', '泡面', '5.00');
INSERT INTO `GOODS` VALUES ('67', '213', 'pic\\f47c4bac-a968-422a-af60-3d2910f32551.jpg', '123', '21321', '31232.00');

-- ----------------------------
-- Table structure for MENU
-- ----------------------------
DROP TABLE IF EXISTS `MENU`;
CREATE TABLE `MENU` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ICON` varchar(255) DEFAULT NULL,
  `PARENT` int(11) DEFAULT NULL,
  `TIT` varchar(255) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of MENU
-- ----------------------------
INSERT INTO `MENU` VALUES ('1', 'am-icon-certificate', '0', '功能列表', '');
INSERT INTO `MENU` VALUES ('2', 'am-icon-male', '0', '管理员设置', null);
INSERT INTO `MENU` VALUES ('3', 'am-icon-home', '0', '库存管理', null);
INSERT INTO `MENU` VALUES ('5', 'am-icon-rmb', '0', '销售管理', 'stock_toStock.action');
INSERT INTO `MENU` VALUES ('6', 'am-icon-group', '0', '供应商管理', 'provider_toProvider.action');
INSERT INTO `MENU` VALUES ('7', 'am-icon-group', '3', '----仓库管理', 'warehouse_toWarehouse.action');
INSERT INTO `MENU` VALUES ('8', 'am-icon-cubes', '0', '商品管理', 'goods_toGoods.action');
INSERT INTO `MENU` VALUES ('9', 'am-icon-cubes', '2', '----管理员添加', 'user_register.action');
INSERT INTO `MENU` VALUES ('10', 'am-icon-cubes', '0', '订单管理', 'orders_toOrders.action');
INSERT INTO `MENU` VALUES ('12', 'am-icon-rmb', '2', '----修改头像', 'user_headPortrait.action');
INSERT INTO `MENU` VALUES ('13', 'am-icon-cubes', '2', '----修改密码', 'user_pwd.action');

-- ----------------------------
-- Table structure for ORDERS
-- ----------------------------
DROP TABLE IF EXISTS `ORDERS`;
CREATE TABLE `ORDERS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单的主键',
  `GOODSID` int(11) DEFAULT NULL COMMENT '货物的ID',
  `NUM` int(11) DEFAULT NULL COMMENT '订货数量',
  `DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '订货时间',
  `PRICE` float DEFAULT NULL COMMENT '订货单价',
  `USERID` int(11) DEFAULT NULL COMMENT '操作人员ID',
  `PNO` int(11) DEFAULT NULL COMMENT '进货商ID',
  `SUM` float DEFAULT NULL COMMENT '订货总价钱',
  `WLNO` int(255) DEFAULT NULL COMMENT '仓库ID',
  PRIMARY KEY (`ID`),
  KEY `FK_6kplqs3ipve3omere7jeuritw` (`GOODSID`),
  KEY `FK_o20yllox5k77lfee1btri2yb2` (`WLNO`),
  KEY `FK_jol6mk9n06xsda9micdhq4hh1` (`PNO`),
  CONSTRAINT `FK_6kplqs3ipve3omere7jeuritw` FOREIGN KEY (`GOODSID`) REFERENCES `GOODS` (`ID`),
  CONSTRAINT `FK_jol6mk9n06xsda9micdhq4hh1` FOREIGN KEY (`PNO`) REFERENCES `PROVIDER` (`PNO`),
  CONSTRAINT `FK_o20yllox5k77lfee1btri2yb2` FOREIGN KEY (`WLNO`) REFERENCES `WHLIST` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ORDERS
-- ----------------------------
INSERT INTO `ORDERS` VALUES ('1', '43', '100', '2017-12-30 00:00:00', '2.5', '1', '1', '250', '2');
INSERT INTO `ORDERS` VALUES ('5', '42', '100', '2017-12-20 00:00:00', '100', '1', '1', '10000', '1');
INSERT INTO `ORDERS` VALUES ('8', '42', '123', '2017-12-20 00:00:00', '123123', '1', '1', '15159300000', '1');
INSERT INTO `ORDERS` VALUES ('9', '60', '1231', '2017-12-20 00:00:00', '123', '1', '1', '151413', '7');
INSERT INTO `ORDERS` VALUES ('10', '42', '1000', '2017-12-20 00:00:00', '3', '1', '1', '9', '1');

-- ----------------------------
-- Table structure for PROVIDER
-- ----------------------------
DROP TABLE IF EXISTS `PROVIDER`;
CREATE TABLE `PROVIDER` (
  `PNO` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID',
  `PNAME` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `PHONE` varchar(255) DEFAULT NULL COMMENT '供应商电话',
  `INFOR` varchar(255) DEFAULT NULL COMMENT '供应商描述信息',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '供应商地址',
  PRIMARY KEY (`PNO`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of PROVIDER
-- ----------------------------
INSERT INTO `PROVIDER` VALUES ('1', '老王2', '15928588629', '提供大量零食2', '高新区');
INSERT INTO `PROVIDER` VALUES ('2', '老张', '15928588629', '提供大量零食', '高新区');
INSERT INTO `PROVIDER` VALUES ('33', '啊实打实大', '撒大声地', '阿斯达所大所', '啊实打实大');

-- ----------------------------
-- Table structure for STOCK
-- ----------------------------
DROP TABLE IF EXISTS `STOCK`;
CREATE TABLE `STOCK` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售ID',
  `DATE` datetime DEFAULT NULL COMMENT '销售日期',
  `GOODSID` int(11) DEFAULT NULL COMMENT '商品ID',
  `MONEY` double DEFAULT NULL COMMENT '订单总金额',
  `NUM` int(11) DEFAULT NULL COMMENT '销售商品数量',
  `SELLPRICE` double DEFAULT NULL COMMENT '销售单价',
  `USERID` int(11) DEFAULT NULL COMMENT '管理员ID',
  `WLNO` int(11) DEFAULT NULL COMMENT '仓库ID',
  PRIMARY KEY (`ID`),
  KEY `FK_ae3a36lcv63lngqymmm3nnbh4` (`GOODSID`),
  KEY `FK_69vyomvecddtmqrv6s42b26xn` (`WLNO`),
  CONSTRAINT `FK_69vyomvecddtmqrv6s42b26xn` FOREIGN KEY (`WLNO`) REFERENCES `WHLIST` (`ID`),
  CONSTRAINT `FK_ae3a36lcv63lngqymmm3nnbh4` FOREIGN KEY (`GOODSID`) REFERENCES `GOODS` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of STOCK
-- ----------------------------
INSERT INTO `STOCK` VALUES ('1', '2017-12-31 00:00:00', '42', '98901', '999', '99', '1', '1');
INSERT INTO `STOCK` VALUES ('2', '2017-12-29 00:00:00', '43', '5000', '1000', '5', '1', '2');
INSERT INTO `STOCK` VALUES ('7', '2017-12-06 00:00:00', '60', '1000', '100', '10', '1', '7');
INSERT INTO `STOCK` VALUES ('10', '2017-12-20 00:00:00', '42', '300', '100', '3', '1', '1');
INSERT INTO `STOCK` VALUES ('12', '2017-12-20 00:00:00', '42', '276', '23', '12', '1', '1');
INSERT INTO `STOCK` VALUES ('13', '2017-12-01 00:00:00', '42', '14884', '122', '122', '1', '1');
INSERT INTO `STOCK` VALUES ('14', '2017-12-20 00:00:00', '42', '151659', '1233', '123', '1', '1');

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(15) DEFAULT NULL,
  `PIC` varchar(255) DEFAULT NULL,
  `USERID` varchar(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_26o4fboslhtcwvy0eug03fpk3` (`PIC`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of USER
-- ----------------------------
INSERT INTO `USER` VALUES ('1', '123', 'pic\\39463aa8-4010-44ee-b8ee-74404fc59135.jpg', 'root');
INSERT INTO `USER` VALUES ('2', '11', null, '1234');
INSERT INTO `USER` VALUES ('3', '66', null, '6666');
INSERT INTO `USER` VALUES ('4', '1237', null, '7777');
INSERT INTO `USER` VALUES ('5', '8', null, '8888');
INSERT INTO `USER` VALUES ('6', '33', null, '9633');
INSERT INTO `USER` VALUES ('7', '99', null, '4399');
INSERT INTO `USER` VALUES ('8', '222', null, '2222');
INSERT INTO `USER` VALUES ('9', '123', null, 'booksu');
INSERT INTO `USER` VALUES ('10', '123', null, 'sadda');
INSERT INTO `USER` VALUES ('11', '123', null, 'zxczxs');
INSERT INTO `USER` VALUES ('12', '123', null, 'asdsb');
INSERT INTO `USER` VALUES ('13', '123', null, 'nbmn');
INSERT INTO `USER` VALUES ('14', '123', null, 'wqeqw');
INSERT INTO `USER` VALUES ('15', '123', null, 'dfgg');
INSERT INTO `USER` VALUES ('16', '123', null, 'ji123');
INSERT INTO `USER` VALUES ('17', '123', null, 'fdss');
INSERT INTO `USER` VALUES ('18', '123', null, 'vcbc');
INSERT INTO `USER` VALUES ('19', '123', null, 'roots');
INSERT INTO `USER` VALUES ('20', '123', null, 'xzcz');
INSERT INTO `USER` VALUES ('21', '123', null, 'vcza');

-- ----------------------------
-- Table structure for WAREHOUSE
-- ----------------------------
DROP TABLE IF EXISTS `WAREHOUSE`;
CREATE TABLE `WAREHOUSE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库主键',
  `NAME` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `GOODID` int(11) DEFAULT NULL,
  `MIN` int(11) DEFAULT NULL COMMENT '最小警戒值',
  `NUM` int(11) DEFAULT NULL COMMENT '货物数量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of WAREHOUSE
-- ----------------------------
INSERT INTO `WAREHOUSE` VALUES ('3', '菜鸟驿站', '双流', null, null, null);
INSERT INTO `WAREHOUSE` VALUES ('4', '二手东', '成都市九眼桥第九个洞', null, null, null);
INSERT INTO `WAREHOUSE` VALUES ('5', '淘宝网', '杭州西湖畔', null, null, null);

-- ----------------------------
-- Table structure for WHLIST
-- ----------------------------
DROP TABLE IF EXISTS `WHLIST`;
CREATE TABLE `WHLIST` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存主键ID',
  `GOODID` int(11) DEFAULT NULL COMMENT '商品ID',
  `NUM` int(11) DEFAULT NULL COMMENT '库存数量',
  `WNO` int(11) DEFAULT NULL COMMENT '仓库号',
  `Min` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_7xvk1gl189wq1wjool61353h4` (`GOODID`),
  KEY `FK_gytxgj9vokfm1jgv6eb6ym9dd` (`WNO`),
  CONSTRAINT `FK_7xvk1gl189wq1wjool61353h4` FOREIGN KEY (`GOODID`) REFERENCES `GOODS` (`ID`),
  CONSTRAINT `FK_gytxgj9vokfm1jgv6eb6ym9dd` FOREIGN KEY (`WNO`) REFERENCES `WAREHOUSE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of WHLIST
-- ----------------------------
INSERT INTO `WHLIST` VALUES ('1', '42', '9746', '3', '100');
INSERT INTO `WHLIST` VALUES ('2', '43', '1000', '4', '100');
INSERT INTO `WHLIST` VALUES ('3', '59', '1000', '5', '100');
INSERT INTO `WHLIST` VALUES ('5', '42', '1000', '4', '100');
INSERT INTO `WHLIST` VALUES ('6', '43', '1000', '5', '100');
INSERT INTO `WHLIST` VALUES ('7', '60', '2231', '3', '200');
INSERT INTO `WHLIST` VALUES ('1005', '43', '12345', '3', '12322');
INSERT INTO `WHLIST` VALUES ('1006', '60', '123123', '4', '123');
