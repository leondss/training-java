package com.leonds.oop.demo1;

/**
 * 这个例子主要说明，父类构造方法里不应该调用可以被子类重写的方法，这样容易引起混淆，可以调用private方法
 *
 * @author Leon
 */
public class Child extends Base {
    private int num = 123;

    public Child() {
    }

    @Override
    public void test() {
        System.out.println(num);
    }


    public static void main(String[] args) {
        Child child = new Child();
        child.test();
        // 输出：
        // 0
        // 123
    }
}
