package com.baz.app.easy;
import com.baz.app.util.*;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-07-01
*/
public class PathSum{
    public boolean hasPathSum(TreeNode root , int sum){
        boolean re = false;

        return re;
    }

    // private void dfs(TreeNode node, int sum){
        
    // }

    public void test(){
        TreeNode t0 = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(1);
        t0.left = t1; 
        t0.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.right = t8;
        Utils.preOrderPrintTree(t0);
    }
}