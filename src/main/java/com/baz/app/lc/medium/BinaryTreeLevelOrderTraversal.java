package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal implements Facebook {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
//        bfsHelper(root, list);
        dfsHelper(list, root, 0);
        return list;
    }

    private void bfsHelper(TreeNode node, List<List<Integer>> list){
        if(node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size -- > 0){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            list.add(temp);
        }

    }


    private void dfsHelper(List<List<Integer>> list, TreeNode node, int h){
        if(node == null) return;

        if(h >= list.size()){
            list.add(h, new ArrayList<>());
        }
        list.get(h).add(node.val);
        dfsHelper(list, node.left, h + 1);
        dfsHelper(list, node.right, h + 1);
    }


    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode r1l2 = new TreeNode(15);
        TreeNode r1r2 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        r1.left = r1l2;
        r1.right = r1r2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        levelOrder(root).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });

    }

}
