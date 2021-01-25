package com.danny.SpringIoCLearning.service.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        System.out.println(Arrays.asList(target.getClass().getInterfaces()));
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object returnValue = method.invoke(target,args);
                System.out.println("关闭事务");
                return null;
            }
        });
    }
}
