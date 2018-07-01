package com.baz.app.easy;
import com.baz.app.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-26
*/
class MaximumDepthOfBinaryTree{

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int depth = Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth + 1;
    }

    public int maxDepthBFS(TreeNode root){
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            count ++;
        }

        return count;
    }

    public int maxDepthDFS(TreeNode root){
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(max, temp);

            if(node.left != null){
                stack.push(node.left);
                value.push(temp + 1);
            }
            if(node.right != null){
                stack.push(node.right);
                value.push(temp + 1);
            }
        }

        return max;

    }

    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode t0 = new TreeNode(9);
        TreeNode t1 = new TreeNode(20);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(7);
        root.left = t0;
        root.right = t1;
        t1.left = t2;
        t1.right = t3;
        Utils.preOrderPrintTree(root);
        System.out.println("");
        System.out.println(maxDepth(root));
        System.out.println(maxDepthDFS(root));
        System.out.println(maxDepthBFS(root));
    }
}