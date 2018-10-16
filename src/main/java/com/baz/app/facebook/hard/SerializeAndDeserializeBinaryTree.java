package com.baz.app.facebook.hard;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // DFS O(n) O(n)
    public String serialize(TreeNode root){
        final String spliter = ",";
        final String NN = "X";
        StringBuilder sb = new StringBuilder();
        seHelper(root, sb, spliter, NN);
        return sb.toString();
    }

    private void seHelper(TreeNode node, StringBuilder sb, String sp, String nn){
        if(node == null){
            sb.append(nn).append(sp);
        }else {
            sb.append(node.val).append(sp);
            seHelper(node.left, sb, sp, nn);
            seHelper(node.right, sb, sp, nn);
        }
    }

    public TreeNode deserialize(String data){
        final String spliter = ",";
        final String NN = "X";
        String[] cs = data.split(spliter);
        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(cs));
        return deHelper(q, spliter, NN);
    }

    private TreeNode deHelper(Deque<String> s, String sp, String nn){
        String cur = s.remove();
        if(nn.equals(cur)) return null;
        TreeNode node = null;
        if( !nn.equals(cur) ){
            node = new TreeNode(Integer.parseInt(cur));
            node.left = deHelper(s, sp, nn);
            node.right = deHelper(s, sp, nn);
        }
        return node;
    }

    // BFS O(n) O(n)
    public String serializeBFS(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("null ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserializeBFS(String data) {
        if ("".equals(data)) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r1l2 = new TreeNode(4);
        TreeNode r1r2 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        r1.left = r1l2;
        r1.right = r1r2;

        Utils.preOrderPrintTree(root);
        System.out.println();
        String str = serialize(root);
        System.out.println(str);
        TreeNode node = deserialize(str);
        Utils.preOrderPrintTree(node);
    }

}
