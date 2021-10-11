package com.dandelion.linklist;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class lt2 {
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

    static class Soultion {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (null == l1 && l2 == l1) {
                return null;
            }
            int var = 0;

            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            while (l1 != null || l2 != null) {
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                int sum = val1 + val2 + var;
                var = sum / 10;
                int tmp = sum % 10;
                cur.next = new ListNode(tmp);
                cur = cur.next;

                if (null != l1) {
                    l1 = l1.next;
                }
                if (null != l2) {
                    l2 = l2.next;
                }
            }
            if (var == 1) {
                cur.next = new ListNode(var);
            }

            return pre.next;
        }
    }

    public static void main(String[] args) {
        Soultion s = new Soultion();

        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(5, l22);
        s.addTwoNumbers(l1, l2);
    }

}
