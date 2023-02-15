package com.leonds.oop.demo3;

/**
 * 继承可能破坏封装是因为子类和父类之间可能存在实现细节的依赖。子类修改时，往往需要考虑父类的实现细节，反过来也是如此。
 *
 * @author Leon
 */
public class Child extends Base {
    private long sum;

    @Override
    public void add(int number) {
        super.add(number);
        sum += number;
    }

    @Override
    public void addAll(int[] numbers) {
        super.addAll(numbers);
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
    }

    public long getSum() {
        return sum;
    }


    public static void main(String[] args) {
        Child c = new Child();
        c.addAll(new int[]{1, 2, 3});
        System.out.println(c.getSum());
    }
}