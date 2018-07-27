package com.baz.app.google;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root){
        int d = 0;
        if (root == null) {
            return d;
        }
        d = bfs(root.left) + bfs(root.right);
        d = Math.max(diameterOfBinaryTree(root.left), d);
        d = Math.max(diameterOfBinaryTree(root.right), d);
        return d;
    }

    private int bfs(TreeNode node){
        int count = 0;
        if(node == null) return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                TreeNode n = queue.poll();
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
            count ++;
        }
        return count;
    }

    int max = 0;
    public int dp(TreeNode root){
        depth(root);
        return max;
    }
    public int depth(TreeNode node){
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        max = Math.max(max, l+r);
        return Math.max(l, r) + 1;
    }

    public void test(){
        TreeNode r = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        r.left = l1;
        r.right = r1;
        l1.left = l2;
        l1.right = r2;
        Utils.inOrderPrintTree(r);
        System.out.println();
        System.out.println(diameterOfBinaryTree(r));
        System.out.println(dp(r));
    }
}
