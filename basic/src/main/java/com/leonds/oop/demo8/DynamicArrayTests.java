package com.leonds.oop.demo8;

/**
 * @author Leon
 */
public class DynamicArrayTests {
    public static void main(String[] args) {
        DynamicArray<Number> numberDynamicArray = new DynamicArray<>();


        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(1);
        arr.add(2);

        numberDynamicArray.addAll(arr);


//        DynamicArray<? extends Integer> arr2 = new DynamicArray<>();
//        arr2.add(1);

    }
}
