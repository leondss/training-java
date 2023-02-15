package com.leonds.design.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 代理
 *
 * @author Leon
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // do something
        System.out.println("中介去挑选很多车");
        Object result = method.invoke(object, objects);
        // do something
        System.out.println("中介办理过户等手续");
        return result;
    }
}
