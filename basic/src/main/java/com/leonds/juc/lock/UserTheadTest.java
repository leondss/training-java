package com.leonds.juc.lock;

/**
 * 主线程结束后，如果用户线程还在运行，则程序不会结束
 * 主线程结束后，如果是守护线程，则程序会结束，守护线程在后台继续执行
 *
 * @author Leon
 */
public class UserTheadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "用户线程");

        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName() + "主线程结束了...");
    }
}
