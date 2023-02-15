package com.leonds.basic;

/**
 * 数据类型
 *
 * @author Leon
 */
public class DataType {

    public static void main(String[] args) {
        wrapDataType();
    }


    /**
     * 8种基本数据类型：
     * int
     * long
     * byte
     * short
     * char
     * float
     * double
     * boolean
     */
    private void basicDataType() {
        int a = 100;
        long b = 10000000000L;
        short c = 1;
        byte d = 12;

        char n = 'n';

        float num = 3.14f;
        double num2 = 3.14;

        boolean flag = false;
    }

    /**
     * 包装类型
     */
    public static void wrapDataType() {
        // 自动装箱，实际上调用了Integer.valueOf()方法
        Integer a = 10;

        Integer b = new Integer(10);
    }
}
