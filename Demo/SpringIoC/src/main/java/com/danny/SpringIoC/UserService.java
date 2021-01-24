package com.danny.SpringIoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    User user;

    public UserService(@Autowired User user) {
        this.user = user;
        System.out.println("插入User");
    }
}
