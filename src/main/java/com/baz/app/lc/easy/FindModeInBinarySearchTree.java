package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree implements Google {

    public int[] findMode(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            max = Math.max(e.getValue(), max);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() == max) list.add(e.getKey());
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    private void inOrder(TreeNode node, Map<Integer, Integer> map){
        if(node == null) return;
        inOrder(node.left, map);
        map.put(node.val, map.getOrDefault(node.val,0) + 1);
        inOrder(node.right, map);
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r1l2 = new TreeNode(2);
        root.right = r1;
        r1.left = r1l2;

        Utils.inOrderPrintTree(root);
        System.out.println();
        Utils.printArray(findMode(root));
    }
}
