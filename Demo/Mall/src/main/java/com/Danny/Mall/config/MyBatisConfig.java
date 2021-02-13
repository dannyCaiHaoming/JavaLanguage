package com.Danny.Mall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
* MyBatis配置类
*
*/

@Configuration
@MapperScan({"com.Danny.Mall.mbg.mapper","com.Danny.Mall.dao"})
public class MyBatisConfig {


}
