package com.dandelion.binaryTree;

/**
 * @author zhanghongwei
 * @version 1.0
 * @date 2022/2/9 15:40
 * @description
 */
public class lt1373 {

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

    public int maxSumBST(TreeNode root) {


        return 0;
    }


    /**
     * 判断是否为bst
     * @param root
     * @return
     */
    public boolean isBstTree(TreeNode root){
        if (root == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return  false;
        }
        int leftVal = root.left.val;
        int rightVal = root.left.val;
        if (leftVal > root.val || rightVal < root.val){
            return false;
        }
        boolean leftResult = isBstTree(root.left);
        boolean rightResult = isBstTree(root.right);
        return leftResult && rightResult;

    }


    public int findMax(TreeNode root){
        int max = Integer.MIN_VALUE;
        max = Math.max(max, root.val);
        while(root.right != null){
            max = Math.max(max, root.val);
            root = root.right;
        }

        return max;
    }
}
