package com.dandelion.linklist;


/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class lt19 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy= new ListNode(0,head);
            ListNode first=head;
            ListNode second=dummy;
            for(int i=0;i<n;i++){
                first=first.next;
            }
            while(first!=null){
                first=first.next;
                second=second.next;
            }
            second.next=second.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(2, l12);
        ListNode l0 = new ListNode(6, l1);

        s.removeNthFromEnd(l0,2);


    }
}
