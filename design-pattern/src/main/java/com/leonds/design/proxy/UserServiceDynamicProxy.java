package com.leonds.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * @author Leon
 */
public class UserServiceDynamicProxy implements InvocationHandler {
    private final Object object;

    public UserServiceDynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // do something
        System.out.println("中介去挑选很多车");
        Object result = method.invoke(object, args);
        // do something
        System.out.println("中介办理过户等手续");
        return result;
    }
}
