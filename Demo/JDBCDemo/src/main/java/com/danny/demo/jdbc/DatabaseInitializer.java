package com.danny.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
     * 构造方法执行后，初始化，
     */
    @PostConstruct
    public void init(){
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users ("
                + "id BIGINT IDENTITY NOT NULL PRIMARY KEY, " //
                + "email VARCHAR(100) NOT NULL, " //
                + "password VARCHAR(100) NOT NULL, " //
                + "name VARCHAR(100) NOT NULL, " //
                + "UNIQUE (email))");
    }

}
