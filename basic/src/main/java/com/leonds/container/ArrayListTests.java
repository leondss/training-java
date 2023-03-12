package com.leonds.container;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Leon
 */
public class ArrayListTests {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

//        for (Integer integer : list) {
//            if (integer > 2) {
//                list.remove(integer);
//            }
//        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() > 2) {
                it.remove();
            }
        }
    }
}
