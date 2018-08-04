package com.baz.app.facebook.hard;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

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
