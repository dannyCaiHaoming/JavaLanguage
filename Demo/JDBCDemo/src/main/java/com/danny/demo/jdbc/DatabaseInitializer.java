package com.danny.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

public class DatabaseInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
     * 构造方法执行后，初始化，
     */
    @PostConstruct
    public void init(){
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users (\" //\n" +
                "                + \"id BIGINT IDENTITY NOT NULL PRIMARY KEY, \" //\n" +
                "                + \"email VARCHAR(100) NOT NULL, \" //\n" +
                "                + \"password VARCHAR(100) NOT NULL, \" //\n" +
                "                + \"name VARCHAR(100) NOT NULL, \" //\n" +
                "                + \"UNIQUE (email))");
    }

}
