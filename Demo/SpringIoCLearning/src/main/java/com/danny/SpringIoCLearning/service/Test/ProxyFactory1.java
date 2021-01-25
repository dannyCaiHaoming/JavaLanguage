package com.danny.SpringIoCLearning.service.Test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory1 implements MethodInterceptor {

    //维护目标对象
    private Object target;
    public ProxyFactory1(Object target) {
        this.target = target;
    }
    /*给目标对象创建代理对象*/
    public Object getProxyInstance(){
        // 工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        en.setCallback(this);
        // 创建子类
        return en.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        Object returnValue = method.invoke(target,objects);
        System.out.println("关闭事务");
        return null;
    }
}
