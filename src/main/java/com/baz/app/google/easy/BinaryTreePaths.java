package com.baz.app.google.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.*;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        List<String> list = new ArrayList<>();
//        dfs(root , list);
//        bfs(root , list);
        list = recursion(root);
        return list;
    }

    private List<String> recursion(TreeNode node){
        List<String> list = new ArrayList<>();
        if(node == null) return list;
        if(node.left == null && node.right == null){
            list.add(node.val + "");
            return list;
        }
        for(String s : recursion(node.left)){
            list.add(node.val + "->" + s);
        }
        for(String s : recursion(node.right)){
            list.add(node.val + "->" + s);
        }
        return list;
    }

    private void bfs(TreeNode node, List<String> list){
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> strs = new LinkedList<>();
        queue.offer(node);
        strs.offer("");
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                TreeNode n = queue.poll();
                String cur = strs.poll();
                if(n.left != null){
                    queue.offer(n.left);
                    strs.offer(cur + n.val + "->");
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    strs.offer(cur + n.val + "->");
                }
                if(n.left == null && n.right == null){
                    list.add(cur + n.val);
                }
            }
        }
    }

    private void dfs(TreeNode node, List<String> list){
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> strs = new Stack<>();
        stack.push(node);
        strs.push("");
        while (!stack.isEmpty()){
            TreeNode n = stack.pop();
            String cur = strs.pop();
            if (n.left != null) {
                stack.push(n.left);
                strs.push(cur + n.val + "->");
            }
            if (n.right != null) {
                stack.push(n.right);
                strs.push(cur + n.val + "->");
            }
            if(n.left == null && n.right == null){
                list.add(cur + n.val);
            }
        }
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(5);
        TreeNode l1l2 = new TreeNode(6);
        root.left = l1;
        root.right = r1;
        l1.right = l1r2;
        l1.left = l1l2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(binaryTreePaths(root));
    }

}
