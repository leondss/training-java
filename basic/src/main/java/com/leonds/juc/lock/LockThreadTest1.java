package com.leonds.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间定制化通信
 * A 执行完通知 B
 * B 执行完通知 C
 * C 执行完通知 A
 *
 * @author Leon
 */
public class LockThreadTest1 {

    public static void main(String[] args) {
        Share share = new Share();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    share.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    share.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    share.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }

    static class Share {
        private int flag = 1;
        private Lock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();

        public void print5(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 1) {
                    c1.await();
                }

                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i + ":轮数:" + loop);
                }
                flag = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print10(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 2) {
                    c2.await();
                }

                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i + ":轮数:" + loop);
                }
                flag = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print15(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 3) {
                    c3.await();
                }

                for (int i = 0; i < 15; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + i + ":轮数:" + loop);
                }
                flag = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
