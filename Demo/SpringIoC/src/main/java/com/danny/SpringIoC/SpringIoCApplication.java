package com.danny.SpringIoC;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

//@SpringBootApplication
@Configuration
@ComponentScan
public class SpringIoCApplication {

	public static void main(String[] args) {

//		SpringApplication.run(SpringIoCApplication.class, args);

		/*
		XML实现
		 */
		/// 方式一：
//		ClassPathResource resource = new ClassPathResource("application.xml");
//
//		BeanFactory beanFactory = new XmlBeanFactory(resource);

		// 方式二：
//		ApplicationContext cx = new ClassPathXmlApplicationContext("application.xml");
		//可使用多分xml
//		ApplicationContext cx = new ClassPathXmlApplicationContext(new String[]{
//				"application.xml","Spring-Module.xml"
//		});
////		User user = cx.getBean(User.class);
//		User user1 = (User)cx.getBean("user");
//		User user2 = (User) cx.getBean("user_jerry");
////		System.out.println(user);
//		System.out.println(user1.userName);
//		System.out.println(user2.userName);
//
//		Person p1 = (Person) cx.getBean("person");
//		System.out.println(p1);


		/*
		注解实现
		 */
		ApplicationContext cx = new AnnotationConfigApplicationContext(SpringIoCApplication.class);
		System.out.println("配置后----");
//		User user = cx.getBean(User.class);
//		User user1 = (User) cx.getBean("user");
//		System.out.println(user);
//		System.out.println(user1);

		UserService userService = cx.getBean(UserService.class);
		System.out.println(userService);
	}

}
