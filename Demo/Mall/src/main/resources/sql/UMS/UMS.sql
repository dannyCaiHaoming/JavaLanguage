
CREATE DATABASE IF NOT EXISTS mall;


Use mall;


--  ums_admin

CREATE TABLE IF NOT EXISTS `ums_admin` (
    `id` bigint AUTO_INCREMENT,
    `username` varchar(64) NOT NULL COMMENT '用户名',
    `password` varchar(64) NOT NULL COMMENT '密码',
    `icon` varchar(500) NOT NULL COMMENT '头像',
    `email` varchar(100),
    `nick_name` varchar(200),
    `note` varchar(500),
    `create_time` datetime,
    `status` int(1),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


---- ums_permission
CREATE TABLE IF NOT EXISTS `ums_permission` (
    `id` bigint AUTO_INCREMENT,
    `pid` bigint,
    `name` varchar(100) NOT NULL,
    `value` varchar(100) NOT NULL,
    `type` int(1) NOT NULL,
    `uri` varchar(100),
    `status` int(1),
    `create_time` datetime,
    `sort` int,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ums_admin_role_relation

CREATE TABLE IF NOT EXISTS `ums_admin_role_relation` (
    `id` bigint AUTO_INCREMENT,
    `admin_id` bigint NOT NULL COMMENT '用户id',
    `role_id` bigint NOT NULL COMMENT '用户role id',
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--  ums_role
CREATE TABLE IF NOT EXISTS `ums_role` (
    `id` bigint AUTO_INCREMENT,
    `name` varchar(100) NOT NULL COMMENT 'role名',
    `description` varchar(500) ,
    `admin_count` int,
    `create_time` datetime,
    `status` int(1) ,
    `sort` int,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--  ums_role_permission_relation
CREATE TABLE IF NOT EXISTS `ums_role_permission_relation` (
    `id` bigint AUTO_INCREMENT,
    `role_id` bigint NOT NULL,
    `permission_id` bigint NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `ums_admin_login_log` (
    `id` bigint AUTO_INCREMENT,
    `admin_id` bigint NOT NULL,
    `create_time` datetime,
    `ip` varchar(64),
    `address` varchar(100),
    `user_agent` varchar(100),
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `ums_admin_permission_relation` (
    `id` bigint AUTO_INCREMENT,
    `admin_id` bigint NOT NULL,
    `permission_id` bigint NOT NULL,
    `type` int(1),
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
