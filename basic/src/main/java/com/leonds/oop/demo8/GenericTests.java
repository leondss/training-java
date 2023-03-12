package com.leonds.oop.demo8;

import java.util.List;

/**
 * 泛型
 *
 * @author Leon
 */
public class GenericTests {
    /**
     * 无限定通配符
     *
     * @param arr
     * @param elm
     * @return
     */
    public static int indexOf(List<?> arr, Object elm) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(elm)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> void add(T obj) {
    }
}
