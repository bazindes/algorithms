package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree implements Facebook {

    // DFS O(n) O(n)
    private final String spliter = ",";
    private final String NN = "X";

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        seHelper(root, sb);
        return sb.toString();
    }

    private void seHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append(NN).append(spliter);
        }else {
            sb.append(node.val).append(spliter);
            seHelper(node.left, sb);
            seHelper(node.right, sb);
        }
    }

    public TreeNode deserialize(String data){
        String[] cs = data.split(spliter);
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(cs));
        return deHelper(q);
    }

    private TreeNode deHelper(Queue<String> s){
        String cur = s.poll();
        if(NN.equals(cur)) return null;
        TreeNode temp = null;
        if( !NN.equals(cur) ){
            temp = new TreeNode(Integer.parseInt(cur));
            temp.left = deHelper(s);
            temp.right = deHelper(s);
        }
        return temp;
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
