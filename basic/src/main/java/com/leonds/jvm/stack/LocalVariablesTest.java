package com.leonds.jvm.stack;

/**
 * 局部变量表
 * @author Leon
 */
public class LocalVariablesTest {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
    }

    public void test1() {
        int b = 10;
    }
}
// javap -v /Users/leon/project/training/training-java/basic/target/classes/com/leonds/jvm/stack/LocalVariablesTest.class
/*
Classfile /Users/leon/project/training/training-java/basic/target/classes/com/leonds/jvm/stack/LocalVariablesTest.class
  Last modified 2023-3-8; size 674 bytes
  MD5 checksum f3998f59ce5c3db6331065ce14de95ad
  Compiled from "LocalVariablesTest.java"
public class com.leonds.jvm.stack.LocalVariablesTest
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #5.#23         // java/lang/Object."<init>":()V
   #2 = Fieldref           #24.#25        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Methodref          #26.#27        // java/io/PrintStream.println:(I)V
   #4 = Class              #28            // com/leonds/jvm/stack/LocalVariablesTest
   #5 = Class              #29            // java/lang/Object
   #6 = Utf8               <init>
   #7 = Utf8               ()V
   #8 = Utf8               Code
   #9 = Utf8               LineNumberTable
  #10 = Utf8               LocalVariableTable
  #11 = Utf8               this
  #12 = Utf8               Lcom/leonds/jvm/stack/LocalVariablesTest;
  #13 = Utf8               main
  #14 = Utf8               ([Ljava/lang/String;)V
  #15 = Utf8               args
  #16 = Utf8               [Ljava/lang/String;
  #17 = Utf8               a
  #18 = Utf8               I
  #19 = Utf8               test1
  #20 = Utf8               b
  #21 = Utf8               SourceFile
  #22 = Utf8               LocalVariablesTest.java
  #23 = NameAndType        #6:#7          // "<init>":()V
  #24 = Class              #30            // java/lang/System
  #25 = NameAndType        #31:#32        // out:Ljava/io/PrintStream;
  #26 = Class              #33            // java/io/PrintStream
  #27 = NameAndType        #34:#35        // println:(I)V
  #28 = Utf8               com/leonds/jvm/stack/LocalVariablesTest
  #29 = Utf8               java/lang/Object
  #30 = Utf8               java/lang/System
  #31 = Utf8               out
  #32 = Utf8               Ljava/io/PrintStream;
  #33 = Utf8               java/io/PrintStream
  #34 = Utf8               println
  #35 = Utf8               (I)V
{
  public com.leonds.jvm.stack.LocalVariablesTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 6: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/leonds/jvm/stack/LocalVariablesTest;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: iconst_1
         1: istore_1
         2: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         5: iload_1
         6: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
         9: return
      LineNumberTable:
        line 8: 0
        line 9: 2
        line 10: 9
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      10     0  args   [Ljava/lang/String;
            2       8     1     a   I

  public void test1();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=2, args_size=1
         0: bipush        10
         2: istore_1
         3: return
      LineNumberTable:
        line 13: 0
        line 14: 3
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       4     0  this   Lcom/leonds/jvm/stack/LocalVariablesTest;
            3       1     1     b   I
}
SourceFile: "LocalVariablesTest.java"

 */
