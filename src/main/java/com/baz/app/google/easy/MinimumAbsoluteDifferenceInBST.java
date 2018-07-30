package com.baz.app.google.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root){

        int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        if(root.left != null){
            minL = Math.min(Math.abs(root.val - root.left.val) , getMinimumDifference(root.left));

        }
        if(root.right != null){
            minR = Math.min(Math.abs(root.val - root.right.val) , getMinimumDifference(root.right));
        }

        return Math.min(minL, minR);
    }

    private int dfs(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(node);
        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()){
            TreeNode tem = stack.pop();
//            System.out.println(tem.val);
            list.add(tem.val);
            if(tem.left == null && tem.right == null){

            }else {
                if(tem.left != null){
                    stack.push(tem.left);
                }
                if(tem.right != null){
                    stack.push(tem.right);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i == j) continue;
                min = Math.min(Math.abs(list.get(i) - list.get(j)) , min);
            }
        }

        return min;
    }

    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference2(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference2(root.right);

        return min;
    }

    public void test(){
        TreeNode root = new TreeNode(5);
        TreeNode r1 = new TreeNode(7);
        TreeNode l1 = new TreeNode(4);
        root.right = r1;
        root.left = l1;
        TreeNode r2 = new TreeNode(8);
        TreeNode l2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(getMinimumDifference2(root));
    }
}
