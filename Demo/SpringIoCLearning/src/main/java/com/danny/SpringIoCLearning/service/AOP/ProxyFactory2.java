package com.danny.SpringIoCLearning.service.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory2 {

//    private static Object target;
//    private static AOP aop;

//    public static Object getProxyInstance(Object target_, AOP aop_){
//        target = target_;
//        aop = aop_;
//        return Proxy.newProxyInstance(target_.getClass().getClassLoader(),
//                target_.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println(aop);
//                        aop.begin();
//                        Object returnValue = method.invoke(target,args);
//                        aop.close();
//                        return null;
//                    }
//                });
//    }

    public Object getProxyInstance(final Object target_, final AOP aop_){
        return Proxy.newProxyInstance(target_.getClass().getClassLoader(),
                target_.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aop_.begin();
                        Object returnValue = method.invoke(target_,args);
                        aop_.close();
                        return null;
                    }
                });
    }

}
