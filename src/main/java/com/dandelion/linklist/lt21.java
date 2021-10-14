package com.dandelion.linklist;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class lt21 {

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
        /**
         * 双指针
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (null == l1) {
                return l2;
            }
            if (null == l2) {
                return l1;
            }
            ListNode fir = new ListNode(0);
            ListNode tmp = fir;

            while (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    tmp.next = l2;
                    l2 = l2.next;
                } else {
                    tmp.next = l1;
                    l1 = l1.next;
                }
                tmp = tmp.next;
            }
            tmp.next = l1 == null ? l2 : l1;
            return fir.next;
        }

        public ListNode mergeTwoListNodes_Stack(ListNode l1,ListNode l2){
            if (null == l1) {
                return l2;
            }
            if (null == l2) {
                return l1;
            }

            if (l1.val >= l2.val){
                l2.next = mergeTwoListNodes_Stack(l1,l2.next);
                return l2;
            }else{
                l1.next = mergeTwoListNodes_Stack(l1.next,l2);
                return l1;
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(3, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l23 = new ListNode(9);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(4, l22);
        s.mergeTwoListNodes_Stack(l1, l2);
    }
}
