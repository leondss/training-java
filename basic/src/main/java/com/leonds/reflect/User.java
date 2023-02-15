package com.leonds.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Leon
 */
public class User {
    public static void main(String[] args) {
        try {
            // 1. 获取class对象
            Class clazz = Class.forName("com.leonds.reflect.User");

            // 2. 初始化对象
            Object o = clazz.newInstance();

            // 3. 获取方法
            Method setAge = clazz.getMethod("setAge", int.class);

            // 4. 调用方法
            setAge.invoke(o, 10);

            Field[] fields = clazz.getFields();

            Field[] declaredFields = clazz.getDeclaredFields();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
