package com.danny.SpringIoCLearning;

import com.danny.SpringIoCLearning.service.MailService;
import com.danny.SpringIoCLearning.service.User;
import com.danny.SpringIoCLearning.service.UserService1;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

//@SpringBootApplication
public class SpringIoCLearningApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringIoCLearningApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService1 userService1 = context.getBean(UserService1.class);
        User user = userService1.login("bob@example.com", "password");
        System.out.println(user.getName());

        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("application.xml"));
        MailService mailService = factory.getBean(MailService.class);
        System.out.println(mailService.getTime());
    }

}
