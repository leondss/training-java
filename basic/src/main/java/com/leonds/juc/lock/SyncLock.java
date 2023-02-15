package com.leonds.juc.lock;

/**
 * synchronized 是隐式的可重入锁，进入到同步方法后，子方法可自动得到锁
 *
 * @author Leon
 */
public class SyncLock {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread((() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "一级");
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "二级");
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() + "三级");
                    }
                }
            }
        }), "A").start();
    }
}
