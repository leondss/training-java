package com.leonds.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition里的await方法和signalAll实现了和Object里面的wait和notifyAll类似的功能
 * @author Leon
 */
public class LockThreadTest {

    public static void main(String[] args) {
        Share share = new Share();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }

    static class Share {
        private int count;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void incr() throws InterruptedException {
            lock.lock();
            try {
                // 需要放在while循环中
                while (count != 0) {
                    condition.await();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + ":: " + count);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void decr() throws InterruptedException {
            lock.lock();
            try {
                // 需要放在while循环中
                while (count != 1) {
                    condition.await();
                }
                count--;
                System.out.println(Thread.currentThread().getName() + ":: " + count);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
