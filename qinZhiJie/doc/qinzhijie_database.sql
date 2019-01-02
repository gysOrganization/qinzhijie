/*
SQLyog Professional v12.08 (32 bit)
MySQL - 5.1.49-community-log : Database - qinzhijie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qinzhijie` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `qinzhijie`;

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleType` int(2) DEFAULT NULL COMMENT '文章类型',
  `articleTitle` varchar(1000) DEFAULT NULL COMMENT '文章标题',
  `articleKeyWord` varchar(255) DEFAULT NULL COMMENT '文章关键字',
  `desc` varchar(1000) DEFAULT NULL COMMENT '描述',
  `articleText` text COMMENT '详细内容',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `createBy` varchar(255) DEFAULT NULL,
  `updateBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_article` */

insert  into `t_article`(`id`,`articleType`,`articleTitle`,`articleKeyWord`,`desc`,`articleText`,`createTime`,`updateTime`,`createBy`,`updateBy`) values (3,3,'3','3','3','3','2018-12-25 14:51:13','2018-12-25 14:51:13','sys','sys'),(4,3,'3','3','3','3','2018-12-25 14:51:13','2018-12-25 14:51:13','sys','sys'),(5,3,'3','3','3','3','2018-12-25 14:51:13','2018-12-25 14:51:13','sys','sys'),(6,3,'3','3','3','3','2018-12-25 14:51:14','2018-12-25 14:51:14','sys','sys'),(7,3,'3','3','3','3','2018-12-25 14:51:17','2018-12-25 14:51:17','sys','sys'),(8,3,'3','3','3','3','2018-12-25 14:51:22','2018-12-25 14:51:22','sys','sys'),(9,3,'3','3','3','3','2018-12-25 14:51:23','2018-12-25 14:51:23','sys','sys');

/*Table structure for table `t_bigpicture` */

DROP TABLE IF EXISTS `t_bigpicture`;

CREATE TABLE `t_bigpicture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type` varchar(255) DEFAULT NULL COMMENT '大图类型',
  `pictureName` varchar(500) DEFAULT NULL COMMENT '图片名称',
  `pictureUrl` varchar(500) DEFAULT NULL COMMENT '图片url',
  `createby` varchar(255) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateby` varchar(255) DEFAULT NULL COMMENT '更新人',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_bigpicture` */

insert  into `t_bigpicture`(`id`,`type`,`pictureName`,`pictureUrl`,`createby`,`createTime`,`updateby`,`updateTime`) values (3,'3','3','3','sys','2018-12-25 15:56:58','sys','2018-12-25 15:56:58'),(4,'3','3','3','sys','2018-12-25 15:56:58','sys','2018-12-25 15:56:58'),(5,'3','3','3','sys','2018-12-25 15:56:59','sys','2018-12-25 15:56:59');

/*Table structure for table `t_classification` */

DROP TABLE IF EXISTS `t_classification`;

CREATE TABLE `t_classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(36) NOT NULL COMMENT '分类名称',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父id',
  `compositor` tinyint(3) DEFAULT '1' COMMENT '排序',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_classification` */

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uuid` varchar(255) DEFAULT NULL COMMENT 'uuid,用于下载图片',
  `path` varchar(1000) DEFAULT NULL COMMENT '文件路径',
  `fileType` varchar(255) DEFAULT NULL COMMENT '图片类型',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `createTime` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `updateBy` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

/*Table structure for table `t_interlinkage` */

DROP TABLE IF EXISTS `t_interlinkage`;

CREATE TABLE `t_interlinkage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(36) NOT NULL COMMENT '类型',
  `name` varchar(36) NOT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_interlinkage` */

/*Table structure for table `t_member` */

DROP TABLE IF EXISTS `t_member`;

CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(255) DEFAULT NULL COMMENT '成员分类',
  `name` varchar(500) DEFAULT NULL COMMENT '成员名称',
  `pictureLink` varchar(500) DEFAULT NULL COMMENT '头像图片url',
  `profile` varchar(1000) DEFAULT NULL COMMENT '简介',
  `desc` varchar(3000) DEFAULT NULL COMMENT '详细描述',
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_member` */

insert  into `t_member`(`id`,`type`,`name`,`pictureLink`,`profile`,`desc`,`createBy`,`createTime`,`updateBy`,`updateTime`) values (3,'3','3','3','3','3','3',NULL,'3',NULL),(4,'3','3','3','3','3','3',NULL,'3',NULL),(5,'3','3','3','3','3','3',NULL,'3',NULL),(6,'3','3','3','3','3','3',NULL,'3',NULL),(7,'3','3','3','3','3','3',NULL,'3',NULL),(8,'3','3','3','3','3','3',NULL,'3',NULL),(9,'4','4','4','4','4','3',NULL,'sys','2018-12-25 12:37:07');

/*Table structure for table `t_music` */

DROP TABLE IF EXISTS `t_music`;

CREATE TABLE `t_music` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID(音频表)',
  `name` varchar(500) DEFAULT NULL COMMENT '音频名称',
  `musicianId` varchar(500) DEFAULT NULL COMMENT '演奏者ID',
  `wavUrl` varchar(1000) DEFAULT NULL COMMENT 'wav音乐文件路径',
  `cueUrl` varchar(1000) DEFAULT NULL COMMENT 'cue文件路径',
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_music` */

/*Table structure for table `t_musician` */

DROP TABLE IF EXISTS `t_musician`;

CREATE TABLE `t_musician` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '古琴家主键',
  `name` varchar(255) DEFAULT NULL COMMENT '古琴家名称',
  `picUrl` varchar(1500) DEFAULT NULL COMMENT '古琴家图片url',
  `descUrl` varchar(1000) DEFAULT NULL COMMENT '古琴家简述txturl',
  `desc` text COMMENT '简述内容',
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateBy` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_musician` */

/*Table structure for table `t_musicofviolin` */

DROP TABLE IF EXISTS `t_musicofviolin`;

CREATE TABLE `t_musicofviolin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID（琴曲）',
  `name` varchar(500) DEFAULT NULL COMMENT '琴曲名称',
  `createrName` varchar(255) DEFAULT NULL COMMENT '原创作者名称',
  `desc` text COMMENT '琴曲内容',
  `descUrl` varchar(500) DEFAULT NULL COMMENT '琴曲url',
  `age` varchar(255) DEFAULT NULL COMMENT '琴曲年代',
  `createTime` datetime DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_musicofviolin` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(36) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `telephone` varchar(36) DEFAULT NULL COMMENT '电话',
  `email` varchar(36) DEFAULT NULL COMMENT '邮箱',
  `trueName` varchar(36) DEFAULT NULL COMMENT '真实姓名',
  `isAdmin` tinyint(1) DEFAULT '0' COMMENT '是否是admin 0不是1是',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
