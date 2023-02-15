package com.leonds.juc.sync;

/**
 * wait 方法会释放锁
 * 注意虚假唤醒问题，条件判断需要放在while循环中
 * @author Leon
 */
public class ThreadTest {

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

        public synchronized void incr() throws InterruptedException {
            // 需要放在while循环中
            while (count != 0) {
                this.wait();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + ":: " + count);
            this.notifyAll();
        }

        public synchronized void decr() throws InterruptedException {
            // 需要放在while循环中
            while (count != 1) {
                this.wait();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + ":: " + count);
            this.notifyAll();
        }
    }
}
