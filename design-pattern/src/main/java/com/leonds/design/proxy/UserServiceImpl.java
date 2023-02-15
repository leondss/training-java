package com.leonds.design.proxy;

/**
 * @author Leon
 */
public class UserServiceImpl implements UserService {
    @Override
    public void buyCar() {
        System.out.println("用户自己去购买一辆车");
    }
}
