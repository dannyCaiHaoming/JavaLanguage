package com.danny.SpringIoCLearning.service.AOP;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUser{
    @Override
    public void save(){
        System.out.println("DB:保存用户");
    }
}
