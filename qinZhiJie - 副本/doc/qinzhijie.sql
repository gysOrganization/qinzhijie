

-- ----------------------------
-- Table structure for t_classification
-- ----------------------------
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
);

-- ----------------------------
-- Table structure for t_interlinkage
-- ----------------------------
DROP TABLE IF EXISTS `t_interlinkage`;
CREATE TABLE `t_interlinkage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(36) NOT NULL COMMENT '类型',
  `name` varchar(36) NOT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
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
);


CREATE TABLE `article` (
`id`  int NOT NULL AUTO_INCREMENT ,
`articleType`  int(2) NULL COMMENT '文章类型' ,
`articleTitle`  varchar(1000) NULL COMMENT '文章标题' ,
`articleKeyWord`  varchar(255) NULL COMMENT '文章关键字' ,
`dec`  varchar(1000) NULL COMMENT '描述' ,
`articleText`  text NULL COMMENT '详细内容' ,
`createTime`  datetime NULL COMMENT '创建时间' ,
`updateTime`  datetime NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`)
)
;
