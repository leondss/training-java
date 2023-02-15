package com.leonds.datastructure.linkedlist;

/**
 * 单向环形链表
 * 应用场景 Josephu(约瑟夫）问题:
 * 设编号为1...n的n个人围坐一圈，约定编号为K(1<=k<=n)的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 *
 * @author Leon
 */
public class AnnularLinkedList {


    private People first = new People(0);

    /**
     * 获取最终出列的编号队列
     *
     * @param n 总共多少人
     * @param k 从几开始报数
     * @param m 数到m的人出列
     * @return
     */
    public String getNoQueue(int n, int k, int m) {

        return null;
    }

    private void add(int count) {
        People currentPeople = null;
        for (int i = 1; i <= count; i++) {
            People people = new People(i);
            if (i == 1) {
                first = people;
            } else {
                currentPeople.setNext(people);
            }
            people.setNext(first);
            currentPeople = people;
        }
    }

    private static class People {
        private int no;
        private People next;

        public People(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public People getNext() {
            return next;
        }

        public void setNext(People next) {
            this.next = next;
        }
    }
}
