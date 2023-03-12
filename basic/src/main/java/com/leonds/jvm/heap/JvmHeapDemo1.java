package com.leonds.jvm.heap;

public class JvmHeapDemo1 {
    public static void main(String[] args) {
        System.out.println("JvmHeapDemo1");
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
