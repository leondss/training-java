package com.leonds.jvm.heap;

public class JvmHeapDemo2 {
    public static void main(String[] args) {
        System.out.println("JvmHeapDemo2");
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
