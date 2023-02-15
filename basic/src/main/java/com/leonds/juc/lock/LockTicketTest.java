package com.leonds.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leon
 */
public class LockTicketTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        for (int i = 0; i < 30; i++) {
            new Thread(ticket::sell, "A" + i).start();
        }

//        new Thread(ticket::sell, "A").start();
//        new Thread(ticket::sell, "B").start();
//        new Thread(ticket::sell, "C").start();
    }

    static class Ticket {
        private int count = 20;

        private final Lock lock = new ReentrantLock();

        public void sell() {
            try {
                // 先加锁
                lock.lock();
                if (count > 0) {
                    count--;
                    System.out.println(Thread.currentThread().getName() + ",当前余票：" + count);
                } else {
                    System.out.println(Thread.currentThread().getName() + "卖光了");
                }
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}
