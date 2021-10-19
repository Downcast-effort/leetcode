package com.dandelion.linklist;

/**
 * @author zhanghongwei
 * @version 1.0
 * @date 2021/10/19 16:04
 * @description给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */


public class lt24 {

    static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null){
                return null;
            }
            if (head.next == null){
                return head;
            }
            ListNode one = new ListNode(0,head);
            ListNode another = one;
            while(another.next != null && another.next.next != null){
                ListNode tmp1 = another.next;
                ListNode tmp2 = another.next.next;
                another.next = tmp2;
                tmp1.next = tmp2.next;
                tmp2.next = tmp1;
                another = tmp1;
            }


            return one.next;
        }
    }

    public static void main(String[] args){

        Solution solution = new Solution();
        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(3, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l2 = new ListNode(0, l1);
        ListNode l0 = new ListNode(9, l2);

        ListNode t = solution.swapPairs(l0);
        System.out.println(t);
    }
}
