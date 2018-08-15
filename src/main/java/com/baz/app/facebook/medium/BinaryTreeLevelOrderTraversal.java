package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfsHelper(root, list);
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
