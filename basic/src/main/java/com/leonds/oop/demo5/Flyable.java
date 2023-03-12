package com.leonds.oop.demo5;

/**
 * 接口
 *
 * @author Leon
 */
public interface Flyable {
    boolean flyable = false;

    void fly();

    default void hi() {
        System.out.println("hi");
    }
}
