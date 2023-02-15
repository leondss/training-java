package com.leonds.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * <p>
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * -Xms和-Xmx设置一样的值，就可以避免堆自动扩展
 * -XX:+HeapDumpOnOutOfMemoryError 可以让虚拟机在出现内存溢出异常的时候Dump出当前的内存堆转储快照以便进行事后分析
 *
 * @author Leon
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
