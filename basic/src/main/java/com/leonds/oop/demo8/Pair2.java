package com.leonds.oop.demo8;

/**
 * 泛型
 * <p>
 * 参数类型可以有多个
 *
 * @author Leon
 */
public class Pair2<T, U> {
    T first;
    U second;

    public Pair2(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public String getText() {
        return "first=" + first + ", second=" + second;
    }

    public static void main(String[] args) {
        Pair2<Integer, String> pair2 = new Pair2<>(1, "name");
        System.out.println(pair2.getText());
    }
}
