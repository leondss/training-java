package com.leonds.juc.lock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList 线程不安全演示
 *
 * @author Leon
 */
public class ListThreadTest {

    public static void main(String[] args) {
        // 线程不安全
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>(); // 线程安全
//        List<String> list = Collections.synchronizedList(new ArrayList<>()); // 线程安全

        List<String> list = new CopyOnWriteArrayList<>();


        for (int i = 0; i < 30; i++) {
            new Thread((() -> {
                list.add(UUID.randomUUID().toString());

                System.out.println(list);
            }), String.valueOf(i)).start();
        }
    }
}
