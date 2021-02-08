

CREATE DATABASE mall;


Use mall;

CREATE TABLE IF NOT EXISTS `pms_brand`(
    `id` BIGINT(20) AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `firstLetter` VARCHAR(20) NOT NULL COMMENT '首字母',
    `sort` INT(10),
    `factoryStatus` INT NOT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
    `showStatus` INT(10),
    `productCount` INT(10) COMMENT '产品数量',
    `productCommentCount` INT(10) COMMENT '产品评论数量',
    `logo` VARCHAR(20) NOT NULL COMMENT '品牌logo',
    `bigPic` VARCHAR(20) NOT NULL COMMENT '专区大图',
    `brandStory` VARCHAR(100) NOT NULL COMMENT '品牌故事',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 ;

