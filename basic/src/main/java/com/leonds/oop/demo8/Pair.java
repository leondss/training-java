package com.leonds.oop.demo8;

/**
 * 泛型
 * @author Leon
 */
public class Pair<T> {
    T first;
    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public String getText() {
        return "first=" + first + ", second=" + second;
    }

    public static void main(String[] args) {
        Pair<Integer> integerPair = new Pair<>(1, 2);
        System.out.println(integerPair.getText());

        Pair<String> stringPair = new Pair<>("leon", "liu");
        System.out.println(stringPair.getText());
    }
}
