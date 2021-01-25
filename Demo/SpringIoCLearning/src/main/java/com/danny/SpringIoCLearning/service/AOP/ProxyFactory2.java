package com.danny.SpringIoCLearning.service.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory2 {

    private static Object target;
    private static AOP aop;

    public static Object getProxyInstance(Object target_,AOP aop_){
        target = target_;
        aop_ = aop_;
        return Proxy.newProxyInstance(target_.getClass().getClassLoader(),
                target_.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop.begin();
                        Object returnValue = method.invoke(proxy,args);
                        aop.close();
                        return null;
                    }
                });
    }

}
