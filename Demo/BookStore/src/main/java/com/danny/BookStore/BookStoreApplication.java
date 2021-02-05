package com.danny.BookStore;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danny.BookStore.entity.Book;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement
public class BookStoreApplication {

    @Autowired
    public AppConfig appConfig;

    public static void main(String[] args) {

//        BookStoreApplication application = new BookStoreApplication();

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        AppConfig config = context.getBean(AppConfig.class);
//
//        System.out.println(config);
////        SpringApplication.run(BookStoreApplication.class, args);


    }


    @Test
    public void test(){
        System.out.println(appConfig);
    }

}
