package com.leonds.design.proxy;

/**
 * 代理类
 *
 * @author Leon
 */
public class UserServiceProxy implements UserService {
    private final UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void buyCar() {
        System.out.println("中介去挑选很多车");
        userService.buyCar();
        System.out.println("中介办理过户等手续");
    }
}
