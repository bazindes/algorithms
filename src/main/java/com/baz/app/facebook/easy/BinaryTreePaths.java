package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    //Recursion
    public List<String> binaryTreePathsRecursive(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root != null){
            StringBuilder sb = new StringBuilder();
            binaryTreePathsRecursiveHelper(root, list, sb);
        }
        return list;
    }

    private void binaryTreePathsRecursiveHelper(TreeNode node, List<String> list, StringBuilder sb){
        if(node == null) return;
        int len = sb.length();
        sb.append(node.val);
        if(node.left == null && node.right == null){
            list.add(sb.toString());
        }else {
            sb.append("->");
            binaryTreePathsRecursiveHelper(node.left, list, sb );
            binaryTreePathsRecursiveHelper(node.right, list, sb );
        }
        sb.setLength(len);
    }

    //dfs O(n) O(n)
    public List<String> binaryTreePaths(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        dfsHelper(root, list);
        return list;
    }

    private void dfsHelper(TreeNode node, List<String> list){
        Stack<TreeNode> nodesStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodesStack.push(node);
        pathStack.push("");

        while (!nodesStack.isEmpty()){
            TreeNode n = nodesStack.pop();
            String curPath = pathStack.pop();
            if(n.left == null && n.right == null){
                list.add(curPath + n.val);
            }else {
                if(n.left != null){
                    nodesStack.push(n.left);
                    pathStack.push(curPath + n.val + "->");
                }
                if (n.right != null) {
                    nodesStack.push(n.right);
                    pathStack.push(curPath + n.val + "->");
                }
            }
        }

    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.right = l1r2;
        Utils.inOrderPrintTree(root);
        System.out.println();
        binaryTreePathsRecursive(root).forEach(System.out::println);
    }

}
