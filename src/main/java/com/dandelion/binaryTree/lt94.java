package com.dandelion.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */

public class lt94 {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归中序遍历
     */
    static class Solution_recurrence {
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            middleOrder(root,result);
            return result;
        }
        public void middleOrder(TreeNode root,List<Integer> result){
            if (null == root){
                return;
            }
            middleOrder(root.left,result);
            result.add(root.val);
            middleOrder(root.right,result);
        }
    }

    /**
     * 迭代中序遍历
     */
    static class Solution_iteration{
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> tmpStack = new Stack<>();
            while(null != root || !tmpStack.empty()){
                while(null != root){
                    tmpStack.push(root);
                    root = root.left;
                }
                root = tmpStack.pop();
                result.add(root.val);
                root = root.right;

            }
            return result;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(8);

        TreeNode treeNode1 = new TreeNode(24,treeNode2,treeNode3);
        TreeNode treeNode4 = new TreeNode(3,null,treeNode5);

        TreeNode treeNode = new TreeNode(1,treeNode1,treeNode4);
        //
        System.out.println("递归解决方案:\n" + new Solution_recurrence().inorderTraversal(treeNode));
        //迭代解决方案
        System.out.println("递归解决方案:\n" + new Solution_iteration().inorderTraversal(treeNode));
    }

}




