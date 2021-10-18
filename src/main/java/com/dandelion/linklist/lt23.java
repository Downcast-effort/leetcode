package com.dandelion.linklist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhanghongwei
 * @version 1.0
 * @date 2021/10/18 11:14
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class lt23 {

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
         * 合并两个升序链表
         * @param node1
         * @param node2
         * @return
         */
        public ListNode mergerTwoListNode(ListNode node1,ListNode node2){
            if (null == node1){
                return node2;
            }
            if (null == node2){
                return node1;
            }

            while(null != node1 && null != node2){
                if (node1.val >= node2.val){
                    node2.next = mergerTwoListNode(node1,node2.next);
                    return node2;
                }else{
                    node1.next = mergerTwoListNode(node1.next,node2);
                    return node1;
                }
            }

            return null;
        }

        /**
         * 归并排序
         * @param lists
         * @return
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0){
                return null;
            }
            if (lists.length == 1){
                return lists[0];
            }

            ListNode currentNode = lists[0];
            for(int i = 1;i<lists.length;i++){
                ListNode nextNode = lists[i];
                currentNode = mergerTwoListNode(currentNode,nextNode);

            }
            return currentNode;
        }

        /**
         * 小根堆
         * @param lists
         * @return
         */
        public ListNode mergeKLists_Heap(ListNode[] lists){
            PriorityQueue<Integer> heapPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            for(int i = 0;i < lists.length;i++){
                ListNode tmpNode = lists[i];
                while(null != tmpNode){
                    heapPriorityQueue.offer(tmpNode.val);
                    tmpNode = tmpNode.next;
                }
            }
            ListNode pre = new ListNode(0);
            ListNode head = pre;
            while(!heapPriorityQueue.isEmpty()){
                ListNode ttNode = new ListNode(heapPriorityQueue.poll());
                pre.next = ttNode;
                pre = pre.next;
            }

            return head.next;
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();

        ListNode l13 = new ListNode(4);
        ListNode l12 = new ListNode(3, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l23 = new ListNode(9);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(4, l22);

        ListNode l33 = new ListNode(8);
        ListNode l32 = new ListNode(7, l33);
        ListNode l3 = new ListNode(5, l32);

        ListNode[] lists = {l1,l2,l3};
        t.mergeKLists_Heap(lists);
    }

}
