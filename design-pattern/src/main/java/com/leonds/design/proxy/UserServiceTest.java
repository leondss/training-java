package com.leonds.design.proxy;

import java.lang.reflect.Proxy;

/**
 * 静态代理
 * - 通过实现与委托对象相同的接口来扩展原有对象的功能
 * - 缺点是接口修改时，代理类要跟着修改，工作量大，维护成本较高
 * <p>
 * 动态代理
 * - 不需要手动创建代理类，只需要编写动态处理器InvocationHandler
 * - 由虚拟机动态创建代理对象
 * <p>
 * cglib代理
 * - 由于JDk的动态代理必须要目标对象实现接口，对于没有实现接口的类无法使用动态代理
 * - cglib通过字节码技术为一个类创建子类，并在子类通过方法拦截器的方式拦截所有父类方法的调用
 *
 * @author Leon
 */
public class UserServiceTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // 静态代理
        System.out.println("静态代理->");
        UserService userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.buyCar();

        System.out.println();

        // 动态代理
        System.out.println("动态代理->");
        UserService userServiceDynamicProxy = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, new UserServiceDynamicProxy(userService));
        userServiceDynamicProxy.buyCar();

        System.out.println();

        // cglib 代理
        System.out.println("cglib 代理->");
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory();
        UserService userServiceCglibProxy = (UserService) cglibProxyFactory.getInstance(userService);
        userServiceCglibProxy.buyCar();
    }
}
