package com.leonds.juc.lock;

/**
 * 死锁
 * <p>
 * 验证死锁：
 * 使用jps -l 查看进程id
 * 使用jstack <pid></pid> 查看堆栈信息
 *
 * @author Leon
 */
public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + " 获取到了锁a，试图获取锁b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + " 获取到了锁b");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + " 获取到了锁b，试图获取锁a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + " 获取到了锁a");
                }
            }
        }, "B").start();
    }
}
