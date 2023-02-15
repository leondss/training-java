package com.leonds.datastructure.linkedlist;

/**
 * 双向链表
 * 双向链表的节点，包括data域、next域和pre域
 *
 * @author Leon
 */
public class BothWayLinkedList {

    public static void main(String[] args) {

        StudentNode n1 = new StudentNode(1, "张三");
        StudentNode n2 = new StudentNode(2, "李四");
        StudentNode n3 = new StudentNode(3, "王五");

        BothWayLinkedList bothWayLinkedList = new BothWayLinkedList();
        bothWayLinkedList.add(n1);
        bothWayLinkedList.add(n2);
        bothWayLinkedList.add(n3);

        bothWayLinkedList.del(2);

        bothWayLinkedList.list();

//        System.out.println("有效节点个数" + bothWayLinkedList.size());
    }


    private final StudentNode head = new StudentNode();

    /**
     * 在尾部添加一个节点
     * - 先找到尾节点，即next为null的节点
     * - 将尾节点的next指向新添加的节点
     * - 将新节点的pre指向最后一个节点
     *
     * @param node
     */
    public void add(StudentNode node) {
        // 由于head的值不能够改变，所以定义一个临时变量，指向head
        StudentNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        node.setPre(temp);
        temp.setNext(node);
    }

    public void del(int no) {
        StudentNode temp = head;

        while (true) {
            if (temp.getNo() == no) {
                temp.getPre().setNext(temp.getNext());
                if (temp.getNext() != null) {
                    temp.getNext().setPre(temp.getPre());
                }
                return;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 遍历
     */
    public void list() {
        StudentNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }


    /**
     * 双向链表的节点，包括data域，next和pre
     * pre - 指向前一个节点
     * next - 指向后一个节点
     *
     * @author Leon
     */
    private static class StudentNode {
        private int no;
        private String name;
        private StudentNode pre;
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

        public StudentNode getPre() {
            return pre;
        }

        public void setPre(StudentNode pre) {
            this.pre = pre;
        }


    }
}
