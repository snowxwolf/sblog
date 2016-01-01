--文章表
CREATE TABLE `sblog`.`xwolf_article`(  
  `id` INT(15) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` VARCHAR(1000) COMMENT '标题',
  `author` VARCHAR(100) COMMENT '作者',
  `url` VARCHAR(1000) COMMENT '来源url',
  `type` VARCHAR(1000) COMMENT '文章类型',
  `publish_time` DATE COMMENT '发布日期',
  `status` VARCHAR(10) COMMENT '文章状态',
  `content` BLOB COMMENT '内容',
  `mini_type` VARCHAR(100) COMMENT '小的分类',
  `tag` VARCHAR(100) COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8;

--新闻表 
CREATE TABLE `sblog`.`xwolf_news`(  
  `id` INT(100) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` VARCHAR(100) COMMENT '新闻标题',
  `org` VARCHAR(100) COMMENT '来源',
  `url` VARCHAR(1000) COMMENT '对应链接',
  `status` VARCHAR(2) COMMENT '状态',
  `time` DATETIME COMMENT '发布时间',
  `text` BLOB COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=INNODB;
--文章分类表
CREATE TABLE `sblog`.`xwolf_type`(  
  `id` INT(100) NOT NULL AUTO_INCREMENT COMMENT '文章分类id',
  `name` VARCHAR(100) NOT NULL COMMENT '分类的名称',
  `parent_id` INT(100) COMMENT '上级分类',
  `descr` VARCHAR(1000),
  PRIMARY KEY (`id`)
) ENGINE=INNODB;
--文章标签表
CREATE TABLE `sblog`.`xwolf_tag`(  
  `id` INT(100) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL COMMENT '标签名称',
  `descr` VARCHAR(100) COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=INNODB;
--修改tag表结构
ALTER TABLE `sblog`.`xwolf_tag`   
  CHANGE `desc` `descr` VARCHAR(100) CHARSET utf8 COLLATE utf8_general_ci NULL  COMMENT '描述';
  --添加一个字段
  ALTER TABLE `sblog`.`xwolf_link`   
  ADD COLUMN `status` VARCHAR(5) NULL  COMMENT '状态' AFTER `descr`;
  
--日记类
  CREATE TABLE `sblog`.`xwolf_diary`(  
  `id` INT(15) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` VARCHAR(100) NOT NULL COMMENT '日记标题',
  `author` VARCHAR(100) COMMENT '作者',
  `content` BLOB COMMENT '内容',
  `time` DATE COMMENT '时间',
  `weather` VARCHAR(100) COMMENT '天气',
  `status` VARCHAR(100) COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;
--友情链接类
CREATE TABLE `sblog`.`xwolf_link`(  
  `id` INT(15) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` VARCHAR(100) NOT NULL COMMENT '名称',
  `url` VARCHAR(1000) COMMENT '来源url',
  `type` VARCHAR(100) COMMENT '链接的类别',
  `descr` VARCHAR(100) COMMENT '描述',
  `status` VARCHAR(10) COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=INNODB;

---用户表
CREATE TABLE `xwolf_user` (
  `ID` varchar(40) NOT NULL,
  `USERNAME` varchar(50) NOT NULL COMMENT '用户名',
  `PASSWD` varchar(100) NOT NULL COMMENT '密码',
  `REG_DATE` datetime NOT NULL COMMENT '注册时间',
  `REG_IP` varchar(100) DEFAULT NULL COMMENT '注册IP',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '备注',
  `STATUS` varchar(10) NOT NULL DEFAULT '''1''' COMMENT '状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
--上传文件表
CREATE TABLE `sblog`.`xwolf_uploader`(  
  `ID` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `FILE_NAME` VARCHAR(200) NOT NULL COMMENT '文件名称',
  `FILE_PATH` VARCHAR(1000) NOT NULL COMMENT '文件路径',
  `USER_ID` VARCHAR(50) COMMENT '上传用户ID',
  `UPLOAD_TIME` DATETIME COMMENT '上传时间',
  `REMARK` VARCHAR(1000) COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;

--菜单表
CREATE TABLE `sblog`.`xwolf_menu`(  
  `ID` INT(15) NOT NULL AUTO_INCREMENT,
  `parent_menu_id` INT(15) NOT NULL COMMENT '上一级菜单',
  `menu_name` VARCHAR(50) COMMENT '菜单名称',
  `url` VARCHAR(1500) COMMENT '对应URL',
  `icon` VARCHAR(100) COMMENT '对应图标',
  `create_time` DATETIME COMMENT '创建时间',
  `update_time` DATETIME COMMENT '更新时间',
  `create_user_id` VARCHAR(25) COMMENT '创建人',
  `update_user_id` VARCHAR(25) COMMENT '更新人',
  PRIMARY KEY (`ID`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;

  