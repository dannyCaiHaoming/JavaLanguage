package com.danny.demo.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("jdbc.properties")
public class AppConfig {

//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService1 userService1 = context.getBean(UserService1.class);
//        userService1.register("bob@gmail.com","bob","bob");
//        userService1.register("alice@gmail.com","alice","alice");
//        User bob = userService1.getUserByName("bob");
//        System.out.println(bob);
//        User tom = userService1.register("tom@gmail.com","tom","tom");
//        System.out.println(tom);
//        System.out.println("Total :" + userService1.getUsers());
//        for (User u : userService1.getUsers(1)) {
//            System.out.println(u);
//        }
//        ((ConfigurableApplicationContext) context).close();
//    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService1 userService1 = context.getBean(UserService1.class);
        if (userService1.fetchUserByEmail("bob@gmail.com") == null) {
            userService1.register("bob@gmail.com","bob","bob");
        }
        if (userService1.fetchUserByEmail("alice@gmail.com") == null) {
            userService1.register("alice@gmail.com","alice","alice");
        }

        for (User u : userService1.getUsers(1)){
            System.out.println(u);
        }
        ((ConfigurableApplicationContext) context).close();
    }

    @Value("${jdbc.url}")
    String jdbcUrl;

    @Value("{jdbc.username}")
    String jdbcUsername;

    @Value("{jdbc.password}")
    String jdbcPassword;

    @Bean
    DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(jdbcUsername);
        config.setPassword(jdbcPassword);
        config.addDataSourceProperty("autoCommit","true");
        config.addDataSourceProperty("connectionTimeout","5");
        config.addDataSourceProperty("idleTimeout","60");
        return new HikariDataSource(config);
    }

    @Bean
    JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
