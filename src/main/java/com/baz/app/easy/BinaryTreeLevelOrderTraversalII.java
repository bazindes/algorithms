package com.baz.app.easy;
import com.baz.app.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-26
*/
class BinaryTreeLevelOrderTraversalII{

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while(!temp.isEmpty()){
            int size = temp.size();
            List<Integer> cur = new ArrayList<>();
            while(size -- > 0){
                TreeNode node = temp.poll();
                cur.add(node.val);
                if(node.left != null) temp.offer(node.left);
                if(node.right != null) temp.offer(node.right);
            }
            list.add(cur);
        }
        Collections.reverse(list);
        return list;
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
        List<List<Integer>> list = levelOrderBottom(root);
        for(List<Integer> l : list){
            for(int i:l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}