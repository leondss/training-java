package com.leonds.datastructure.stack;

import java.util.Scanner;

/**
 * 用数组模拟栈
 * <p>
 * 栈是一个先入后出的有序列表
 *
 * @author Leon
 */
public class ArrayStack {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("==========================================");
            System.out.println("命令：");
            System.out.println("exit - 退出程序");
            System.out.println("show - 显示栈信息");
            System.out.println("push - 向栈中插入一个数据");
            System.out.println("pop - 取出栈中的数据");
            System.out.println("==========================================");
            System.out.print("请输入命令：");
            String key = scanner.next();
            switch (key) {
                case "exit":
                    loop = false;
                    scanner.close();
                    break;
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.print("请输入要插入的值：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int result = stack.pop();
                        System.out.println("出栈的值为" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }


    /**
     * 栈的大小
     */
    private final int maxSize;
    /**
     * 栈顶,默认为-1
     */
    private int top = -1;

    /**
     * 数组
     */
    private final int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }


    /**
     * 是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了，无法插入数据");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        System.out.println("栈信息为：");
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }
}
