/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - sale
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sale`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`category_id`,`name`,`del_flag`) values ('4cd7d2c32bd44fdfbb78902ec647ed5d','文具',0),('753893c896b045a3a18b0f1804039093','日用品',0),('a3efa0816fb14a4787c62a5aa6655590','零食',0),('e509030e84ed4ba9994d7dff4988a020','饮品',0);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `good_id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `origin` varchar(20) DEFAULT NULL,
  `stock` int(8) DEFAULT NULL,
  `warehouse_id` varchar(32) DEFAULT NULL,
  `category_id` varchar(32) DEFAULT NULL,
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`good_id`),
  KEY `FK_Reference_6` (`warehouse_id`),
  KEY `FK_Reference_7` (`category_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`good_id`,`name`,`price`,`origin`,`stock`,`warehouse_id`,`category_id`,`del_flag`) values ('098c3ed447234ebbaf2d39a3f59835f4','优悦矿泉水','3.00','哈尔滨',178,'4d3bde71480e43d599c436ea673eb964','e509030e84ed4ba9994d7dff4988a020',0),('0a4d9cf14b4a449ea379c6b92fb05d55','椰子奶','3.00','海南',98,'498359201b4f4edbb137a6d0ba82d9b1','e509030e84ed4ba9994d7dff4988a020',0),('12cebd4dda85494099f674641db0d143','唐僧肉','3.50','温州',10,'ad2ee5024fde43feb3a26b81190deba8','a3efa0816fb14a4787c62a5aa6655590',0),('1bca949698144652a0f34bd6259e6bfe','快客钢笔','108.00','北京',100,'498359201b4f4edbb137a6d0ba82d9b1','4cd7d2c32bd44fdfbb78902ec647ed5d',0),('2e70d079865948b89d390c5ac4528cfe','康师傅红烧牛肉面（袋）','2.50','吉林',1078,'ad2ee5024fde43feb3a26b81190deba8','a3efa0816fb14a4787c62a5aa6655590',0),('2fa56f90c93e40f6b143e8775205f76a','康师傅冰红茶（瓶）','3.00','长春',56,'4d3bde71480e43d599c436ea673eb964','e509030e84ed4ba9994d7dff4988a020',0),('402881625c196a96015c19784f200002','子母奶','4.00','阳江',13,'498359201b4f4edbb137a6d0ba82d9b1','e509030e84ed4ba9994d7dff4988a020',0),('4effe3c372994b4ba550d89c6e568a8f','水杯','17.00','阳江',430,'4d3bde71480e43d599c436ea673eb964','753893c896b045a3a18b0f1804039093',0),('51245a3e5ef74f749a09dd69a1276e5a','可比克薯片','9.00','哈尔滨',244,'ad2ee5024fde43feb3a26b81190deba8','a3efa0816fb14a4787c62a5aa6655590',0),('5731efbc2799412a93a59169a9ffcd66','纳爱斯香皂','6.50','上海',587,'498359201b4f4edbb137a6d0ba82d9b1','753893c896b045a3a18b0f1804039093',0),('632d9429f58d42f3a04d516ff6a548cf','特仑苏','4.00','蒙古',999,'8b4ea76552764374932ea611468bf1a4','e509030e84ed4ba9994d7dff4988a020',0),('8dc70cb890de407999ad13cd275994f1','老北京鸡爪','1.50','福建',64,'ad2ee5024fde43feb3a26b81190deba8','a3efa0816fb14a4787c62a5aa6655590',0),('952a64e8dfd6488cb9eb9d21b16169f5','晨光签字笔（支）','3.00','上海',9966,'8b4ea76552764374932ea611468bf1a4','4cd7d2c32bd44fdfbb78902ec647ed5d',0),('9cf1700221da4bcd9a8df0a2788a6c14','作业本','1.00','山西',966,'8b4ea76552764374932ea611468bf1a4','4cd7d2c32bd44fdfbb78902ec647ed5d',0),('a983c1bd6e364a4895b79021584acf6c','一个鸡蛋雪糕（支）','1.00','山东',2056,'4d3bde71480e43d599c436ea673eb964','a3efa0816fb14a4787c62a5aa6655590',0),('bb9fcbd22dc14c7bb35df519cd893165','陈醋','25.00','山西太原',1410,'498359201b4f4edbb137a6d0ba82d9b1','753893c896b045a3a18b0f1804039093',0),('dec787ba8cc14e7a951670279c1f2818','奶茶','8.00','阳江',900,'ad2ee5024fde43feb3a26b81190deba8','a3efa0816fb14a4787c62a5aa6655590',1),('ebe99d6a1fc449b7a3ab42cbbb045503','清扬洗发露','25.00','北京',8,'8b4ea76552764374932ea611468bf1a4','753893c896b045a3a18b0f1804039093',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values ('402881625c20430b015c204690360000','超级管理员'),('402881625c20430b015c204710b50001','普通用户'),('402881625c20430b015c20474c7d0002','销售人员');

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `sale_id` varchar(32) NOT NULL,
  `handler_id` varchar(32) DEFAULT NULL,
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `FK_Reference_4` (`handler_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`handler_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sale` */

insert  into `sale`(`sale_id`,`handler_id`,`del_flag`) values ('402881625c2057f7015c20582eb10000','402881625c20430b015c2048f1fe0004',0),('402881625c2057f7015c2058df330005','402881625c20430b015c2048f1fe0004',0),('402881625c206859015c206de1210000','402881625c20430b015c2048f1fe0004',0),('402881625c20a770015c20a78ce70000','402881625c20430b015c2048f1fe0004',0),('402881625c20a8f4015c20a9218b0000','402881625c20430b015c2048f1fe0004',0);

/*Table structure for table `sale_goods` */

DROP TABLE IF EXISTS `sale_goods`;

CREATE TABLE `sale_goods` (
  `sale_goods_id` varchar(32) NOT NULL,
  `sale_id` varchar(32) DEFAULT NULL,
  `good_id` varchar(32) DEFAULT NULL,
  `good_name` varchar(20) DEFAULT NULL,
  `good_amount` int(8) DEFAULT NULL,
  PRIMARY KEY (`sale_goods_id`),
  KEY `FK_Reference_11` (`good_id`),
  KEY `FK_Reference_5` (`sale_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sale_goods` */

insert  into `sale_goods`(`sale_goods_id`,`sale_id`,`good_id`,`good_name`,`good_amount`) values ('402881625c2057f7015c2058771c0001','402881625c2057f7015c20582eb10000','1bca949698144652a0f34bd6259e6bfe','快客钢笔',4),('402881625c2057f7015c2058b62b0004','402881625c2057f7015c20582eb10000','2e70d079865948b89d390c5ac4528cfe','康师傅红烧牛肉面（袋）',5),('402881625c2057f7015c2058f4c40006','402881625c2057f7015c2058df330005','9cf1700221da4bcd9a8df0a2788a6c14','作业本',6),('402881625c2057f7015c205906710007','402881625c2057f7015c2058df330005','12cebd4dda85494099f674641db0d143','唐僧肉',2),('402881625c20a770015c20a7ab4b0002','402881625c20a770015c20a78ce70000','1bca949698144652a0f34bd6259e6bfe','快客钢笔',0),('402881625c20a770015c20a7ca410003','402881625c20a770015c20a78ce70000','8dc70cb890de407999ad13cd275994f1','老北京鸡爪',0),('402881625c20a770015c20a7e0000004','402881625c20a770015c20a78ce70000','5731efbc2799412a93a59169a9ffcd66','纳爱斯香皂',0),('402881625c20a8f4015c20a934d50001','402881625c20a8f4015c20a9218b0000','2e70d079865948b89d390c5ac4528cfe','康师傅红烧牛肉面（袋）',3),('402881625c20a8f4015c20a945d20002','402881625c20a8f4015c20a9218b0000','402881625c196a96015c19784f200002','子母奶',2),('402881625c20a8f4015c20a955620003','402881625c20a8f4015c20a9218b0000','8dc70cb890de407999ad13cd275994f1','老北京鸡爪',1);

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `stock_id` varchar(32) NOT NULL,
  `sign` int(1) DEFAULT NULL COMMENT '出入库订单区分标识(0表示入库，1表示出库)',
  `handler_id` varchar(32) DEFAULT NULL,
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `FK_Reference_9` (`handler_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`handler_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock` */

insert  into `stock`(`stock_id`,`sign`,`handler_id`,`del_flag`) values ('402881625c206ed5015c206ef5ba0000',0,'402881625c20430b015c2048f1fe0004',0),('402881625c208848015c20889d790000',1,'402881625c20430b015c2048f1fe0004',0),('402881625c20a040015c20a1fea10000',1,'402881625c20430b015c2048f1fe0004',0),('402881625c20a040015c20a33e980004',0,'402881625c20430b015c2048f1fe0004',0),('402881625c20a040015c20a39a1e0007',0,'402881625c20430b015c2048f1fe0004',0),('402881625c20a770015c20a83e0a0005',0,'402881625c20430b015c2048f1fe0004',0),('402881625c20a8f4015c20a95f830004',0,'402881625c20430b015c2048f1fe0004',0);

/*Table structure for table `stock_goods` */

DROP TABLE IF EXISTS `stock_goods`;

CREATE TABLE `stock_goods` (
  `stock_goods_id` varchar(32) NOT NULL,
  `stock_id` varchar(32) DEFAULT NULL,
  `good_id` varchar(32) DEFAULT NULL,
  `good_name` varchar(20) DEFAULT NULL,
  `good_amount` int(8) DEFAULT NULL,
  PRIMARY KEY (`stock_goods_id`),
  KEY `FK_Reference_10` (`good_id`),
  KEY `FK_Reference_8` (`stock_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`good_id`) REFERENCES `goods` (`good_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stock_goods` */

insert  into `stock_goods`(`stock_goods_id`,`stock_id`,`good_id`,`good_name`,`good_amount`) values ('402881625c20a040015c20a228bf0002','402881625c20a040015c20a1fea10000',NULL,'可比克薯片',0),('402881625c20a040015c20a240290003','402881625c20a040015c20a1fea10000',NULL,'晨光签字笔（支）',0),('402881625c20a040015c20a34dc00005','402881625c20a040015c20a33e980004',NULL,'子母奶',0),('402881625c20a040015c20a35f9f0006','402881625c20a040015c20a33e980004',NULL,'晨光签字笔（支）',0),('402881625c20a040015c20a3ad720008','402881625c20a040015c20a39a1e0007',NULL,'晨光签字笔（支）',0),('402881625c20a040015c20a3c2b60009','402881625c20a040015c20a39a1e0007',NULL,'优悦矿泉水',0),('402881625c20a770015c20a84c2e0006','402881625c20a770015c20a83e0a0005',NULL,'子母奶',0),('402881625c20a770015c20a85ea00007','402881625c20a770015c20a83e0a0005',NULL,'老北京鸡爪',0),('402881625c20a8f4015c20a96d710005','402881625c20a8f4015c20a95f830004',NULL,'特仑苏',2),('402881625c20a8f4015c20a987db0006','402881625c20a8f4015c20a95f830004',NULL,'快客钢笔',5);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_12` (`role_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`name`,`password`,`role_id`) values ('402881625c20430b015c2048f1fe0004','admin','admin','402881625c20430b015c204690360000'),('402881625c20430b015c2049c00b0006','毒豆芽','123','402881625c20430b015c204690360000');

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `warehouse_id` varchar(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sort` int(8) DEFAULT NULL,
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `warehouse` */

insert  into `warehouse`(`warehouse_id`,`name`,`sort`,`del_flag`) values ('498359201b4f4edbb137a6d0ba82d9b1','第三仓库',3,0),('4d3bde71480e43d599c436ea673eb964','第二仓库',2,0),('8b4ea76552764374932ea611468bf1a4','第四仓库',4,0),('ad2ee5024fde43feb3a26b81190deba8','第一仓库',1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
