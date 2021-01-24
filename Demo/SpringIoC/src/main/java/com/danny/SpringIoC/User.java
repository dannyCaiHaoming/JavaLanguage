package com.danny.SpringIoC;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {
    public String userName;
    public String id;


    public User() {
        System.out.println("空User");
    }

    public User(String userName,String id) {
        this.userName = userName;
        this.id = id;
    }

}
