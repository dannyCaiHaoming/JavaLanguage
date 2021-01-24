package com.danny.SpringIoC;

public class Factory {

    public static User getJerry(){
        return new User("Jerry","2");
    }

    public static User getUser(){
        return new User();
    }

    public User getMax(){
        return new User("Max","3");
    }
}
