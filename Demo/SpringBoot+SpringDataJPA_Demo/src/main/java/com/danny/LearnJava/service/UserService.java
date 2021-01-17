package com.danny.LearnJava.service;

import com.danny.LearnJava.domain.User;

import java.util.List;

// 接口
public interface UserService {

    List<User> getAllUser();

    void saveUser(User user);
}
