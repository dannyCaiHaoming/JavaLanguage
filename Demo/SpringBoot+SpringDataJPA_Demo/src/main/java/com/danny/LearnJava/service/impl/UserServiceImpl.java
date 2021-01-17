package com.danny.LearnJava.service.impl;

import com.danny.LearnJava.dao.UserRepository;
import com.danny.LearnJava.domain.User;
import com.danny.LearnJava.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    @Override
    public void saveUser(User user){
        User temp = user;
        temp.setActiState(User.ACTIVATION_SUCCESSFUL);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        date = calendar.getTime();
        temp.setTokenExptime(date);
        userRepository.saveAndFlush(temp);
    }
}
