package com.danny.BookStore;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@MapperScan
@PropertySource("jdbc.properties")
public class AppConfig {

    @Bean
    SqlSessionFactoryBean createSqlSessionFactoryBean(@Autowired DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    DataSource createDataSource(@Value("${jdbc.url}") String jdbcUrl,
                                @Value("${jdbc.username}") String jdbcUsername,
                                @Value("${jdbc.password}") String jdbcPassword,
                                @Value("${jdbc.driver}") String jdbcDriverclass
    ) throws Exception {

        System.out.println(jdbcUrl);

        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setUser(jdbcUsername);
        pool.setPassword(jdbcPassword);
        pool.setJdbcUrl(jdbcUrl);
        pool.setDriverClass(jdbcDriverclass);

        pool.setMaxPoolSize(30);
        pool.setMinPoolSize(10);

        pool.setAutoCommitOnClose(false);
        pool.setCheckoutTimeout(10000);

        pool.setAcquireRetryAttempts(2);

        return  pool;
    }

    @Bean
    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
