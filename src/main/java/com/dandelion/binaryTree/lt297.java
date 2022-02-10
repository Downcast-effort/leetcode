package com.dandelion.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanghongwei
 * @version 1.0
 * @date 2022/2/9 17:03
 * @description
 */
public class lt297 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder serializeResult = new StringBuilder();

    public String serialize(TreeNode root) {

//        traverse(root);
//        postOrderTraverse(root);
        levelOrder(root);
        return serializeResult.toString();
    }

    /**
     * 编码
     * @param root
     */
    public void traverse(TreeNode root) {
        if (root == null) {
            serializeResult.append("#");
            serializeResult.append(",");
            return;
        }
        serializeResult.append(root.val).append(",");

        serialize(root.left);
        serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(",", -1)) {
            list.add(s);
        }
        return trverse1(list);
    }

    /**
     * 解码
     * @param list
     * @return
     */
    public TreeNode trverse1(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String first = list.removeFirst();
        if (first.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        TreeNode left = trverse1(list);
        TreeNode right = trverse1(list);
        root.left = left;
        root.right = right;
        return root;

    }


    /**
     * 后续遍历解码
     * @param root
     */
    public void postOrderTraverse(TreeNode root){
        if (root == null){
            serializeResult.append("#");
            serializeResult.append(",");
            return;
        }
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        serializeResult.append(root.val);
        serializeResult.append(",");

    }

    public TreeNode postOrderDesrilize(LinkedList<String> list){
        if (list.isEmpty()){
            return null;
        }
        String rootVal = list.removeLast();
        if (rootVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        TreeNode right = postOrderDesrilize(list);
        TreeNode left = postOrderDesrilize(list);
        root.left = left;
        root.right = right;

        return root;

    }

    /**
     * 层序遍历编码
     * @param root
     */
    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode r = queue.poll();
                serializeResult.append(r.val );
                serializeResult.append(",");
            if (r.left!=null){
                queue.offer(r.left);
            }
            if (r.right != null){
                queue.offer(r.right);
            }
        }

    }

    /**
     * 层序遍历解码
     * @param list
     * @return
     */
    public TreeNode levelOrderDeseri(LinkedList<String> list){
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        for(int i = 0;i< list.size();){
            TreeNode parent = queue.poll();
            String left = list.get(i+1);
            if (left != null){
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(new TreeNode(Integer.parseInt(left)));
            }
            String right = list.get(i+2);
            if (left != null){
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(new TreeNode(Integer.parseInt(right)));
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode rootleft = new TreeNode(2);
        TreeNode rightleft = new TreeNode(5);
        TreeNode rightright = new TreeNode(4);
        TreeNode rootright = new TreeNode(3, rightleft, rightright);


        TreeNode root = new TreeNode(1, rootleft, rootright);

        lt297 lt297 = new lt297();
        System.out.println(lt297.serialize(root));


        TreeNode node = lt297.deserialize("1,2,#,#,3,5,#,#,4,#,#,");
        System.out.println(node.toString());

    }
}
