package com.danny.SpringIoCLearning.service.AOP;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
    public void save(){
        System.out.println("DB:保存用户");
    }
}
