package com.danny.SpringIoCLearning.service.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

    @Before("execution(public * com.danny.SpringIoCLearning.service.AOP..*(..))")
    public void begin(){
        System.out.println("开始事务");
    }

    @After("execution(public * com.danny.SpringIoCLearning.service.AOP..*(..))")
    public void close(){
        System.out.println("关闭事务");
    }
}
