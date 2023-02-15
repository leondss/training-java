package com.leonds.datastructure.linkedlist;

/**
 * 单向链表
 * 以节点的方式存储数据，每个节点包括data域、next域，next指向下一个节点
 * 各个节点不一定是连续存储的
 *
 * @author Leon
 */
public class SingleLinkedList {

    public static void main(String[] args) {

        StudentNode n1 = new StudentNode(1, "张三");
        StudentNode n2 = new StudentNode(2, "李四");
        StudentNode n3 = new StudentNode(3, "王五");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(n1);
        singleLinkedList.add(n2);
        singleLinkedList.add(n3);

        singleLinkedList.list();

        System.out.println("有效节点个数" + singleLinkedList.size());
    }

    /**
     * head节点不存放任何数据
     */
    private final StudentNode head = new StudentNode();

    /**
     * 在尾部添加一个节点
     * - 先找到尾节点，即next为null的节点
     * - 将尾节点的next指向新添加的节点
     *
     * @param node
     */
    public void add(StudentNode node) {
        // 由于head的值不能够改变，所以定义一个临时变量，指向head
        StudentNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void list() {
        StudentNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }

    /**
     * 获取有效节点的个数
     *
     * @return
     */
    public int size() {
        int size = 0;
        StudentNode temp = head.next;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 定义一个节点
     *
     * @author Leon
     */
    private static class StudentNode {
        private int no;
        private String name;
        private StudentNode next;

        public StudentNode() {
        }

        public StudentNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        @Override
        public String toString() {
            return "StudentNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public StudentNode getNext() {
            return next;
        }

        public void setNext(StudentNode next) {
            this.next = next;
        }
    }


}


