package com.leonds.oop.demo4;

/**
 * 父类和子类具有同名变量时：
 * <p>
 * 子类中定义的成员变量和父类中定义的成员变量相同时，则父类中的成员变量不能被继承。
 * 实际上，即使子类声明了与父类完全一样的成员变量，也不会覆盖掉父类的成员变量。而是在子类实例化时，会同时定义两个成员变量，子类也可以同时访问到这两个成员变量，但父类不能访问到子类的成员变量（父类不知道子类的存在）。
 * 在方法中使用成员变量时：方法在父类中定义和执行，则使用父类的成员变量，方法在子类中定义（包括覆盖父类方法）和执行，则使用子类的成员变量。
 * 直接访问成员变量时：看引用类型所属的类，即看左边；Parent c = new Child()；访问 c.变量 时显示的是Parent中的变量数据
 *
 * @author Leon
 */
public class Child extends Base {
    int i = 2;

    public static void main(String[] args) {
        Child b = new Child();
        b.print();
        System.out.println(b.i);

        Base c = b;
        System.out.println(c.i);

        /*
         输出结果：
            i=1
            2
            1
         */
    }
}
