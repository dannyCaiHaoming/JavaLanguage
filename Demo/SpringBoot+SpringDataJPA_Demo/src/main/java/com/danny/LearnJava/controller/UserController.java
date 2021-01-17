package com.danny.LearnJava.controller;


import com.danny.LearnJava.domain.User;
import com.danny.LearnJava.domain.base.ApiBaseResponse;
import com.danny.LearnJava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public void getAllUser(){

        List<User> allUser = userService.getAllUser();

        for (User user : allUser) {
            System.out.println(user);
        }
    }

    @GetMapping(value = "/user/all", produces = {"application/json;charset=UTF-8"})
    public ApiBaseResponse getUsers(){

        List<User> allUser = userService.getAllUser();

        for (User user : allUser) {
            System.out.println(user);
        }

        return ApiBaseResponse.responseOk(allUser);
    }

    //    @RequestMapping(value = "",method = RequestMethod.POST)
    @PostMapping(value = "/user/create")
    public ApiBaseResponse creteUser(User user){
        userService.saveUser(user);
        return ApiBaseResponse.responseOk(user);
    }



}
