package com.leonds.basic;

import java.io.IOException;

/**
 * 注释
 * <p>
 * - 在Java中，注释分为单行注释、多行注释、文档注释
 * - 注释仅存在于源代码中，方便开发人员理解代码逻辑，并不会编译进字节码中
 * - 代码的注释不是越详细越好，我们应该通过优化代码，减少不必要的注释，表现力好的代码，本身就通俗易懂，不需要注释
 *
 * @author Leon
 */
public class Comments {
    public static void main(String[] args) {
        // 这是单行注释
        System.out.println("Hello world");

        /*
         * 这是多行注释，用的比较少
         */
    }

    /**
     * 这是文档注释，作用在方法上，可以使用很多注解，辅助说明方法
     *
     * @param name 名称；描述方法参数
     * @throws IOException 抛出什么异常
     */
    public void docComments(String name) throws IOException {

    }
}
