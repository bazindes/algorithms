package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list =  new ArrayList<>();
        bfsHelper(root, list);
        return list;
    }

    private void bfsHelper(TreeNode node, List<Double> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()){
            int size = q.size();
            int di = q.size();
            double avg = 0;
            while (size -- > 0){
                TreeNode cur = q.poll();
                avg += cur.val;
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            list.add(avg / di);
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
        averageOfLevels(root).forEach(s -> System.out.print(s + " "));
    }
}
