package com.leonds.string;

/**
 * @author Leon
 */
public class StringInternTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder().append("58").append("tongcheng").toString();
        System.out.println(str1 == str1.intern());

        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2 == str2.intern());
    }
}
