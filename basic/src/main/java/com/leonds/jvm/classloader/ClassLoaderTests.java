package com.leonds.jvm.classloader;

/**
 * @author Leon
 */
public class ClassLoaderTests {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);// sun.misc.Launcher$AppClassLoader@18b4aac2

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);// sun.misc.Launcher$ExtClassLoader@29453f44

        ClassLoader classLoader = ClassLoaderTests.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}
