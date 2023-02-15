package com.leonds.jvm.stack;

/**
 * @author Leon
 */
public class LocalVariablesTest {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
    }

    public void test1() {
        int b = 10;
    }
}

/*
0 iconst_1
1 istore_1
2 getstatic #2 <java/lang/System.out : Ljava/io/PrintStream;>
5 iload_1
6 invokevirtual #3 <java/io/PrintStream.println : (I)V>
9 return




 */
