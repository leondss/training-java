package com.leonds.oop.demo2;

/**
 * 创建对象时，初始化过程
 * <p>
 * 初始化顺序：
 * <p>
 * 父类(静态变量、静态语句块)
 * 子类(静态变量、静态语句块)
 * 父类(实例变量、普通语句块)
 * 父类(构造函数)
 * 子类(实例变量、普通语句块)
 * 子类(构造函数)
 *
 * @author Leon
 */
public class Child extends Base {
    public static int s;
    private int a;

    static {
        System.out.println("子类静态代码块， s: " + s);
        s = 10;
    }

    {
        System.out.println("子类实例代码块， a: " + a);
        a = 10;
    }

    public Child() {
        System.out.println("子类构造方法， a: " + a);
        a = 20;
    }

    public int getA() {
        return a;
    }

    protected void step() {
        System.out.println("child s: " + s + ", a: " + a);
    }


    public static void main(String[] args) {
        System.out.println("---- new Child()");
        Child c = new Child();
        System.out.println("\n---- c.action()");
        c.action();
        Base b = c;
        System.out.println("\n---- b.action()");
        b.action();
        System.out.println("\n---- b.s: " + b.s);
        System.out.println("\n---- c.s: " + c.s);
        System.out.println("\n---- b.a: " + b.getA());
        System.out.println("\n---- c.a: " + c.getA());

        /*
         * 输出结果：
         * ---- new Child()
         * 基类静态代码块， s: 0
         * 子类静态代码块， s: 0
         * 基类实例代码块， a: 0
         * 基类构造方法， a: 1
         * 子类实例代码块， a: 0
         * 子类构造方法， a: 10
         * ---- c.action()
         * start
         * child s: 10, a: 20
         * end
         * ---- b.action()
         * start
         * child s: 10, a: 20
         * end
         * ---- b.s: 1
         * ---- c.s: 10
         *
         * */
    }
}