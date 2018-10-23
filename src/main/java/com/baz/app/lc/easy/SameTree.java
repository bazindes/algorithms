package com.baz.app.lc.easy;
import com.baz.app.util.*;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-22
*/
class SameTree{
    public boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null) return true; 
        if(p == null) return false;
        if(q == null) return false;
        if(p.val == q.val){
            return check(p.left, q.left) && check(p.right, q.right);
        }else{
            return false;
        }
    }
    
    public void test(){
        TreeNode t10 = new TreeNode(1);
        TreeNode t11 = new TreeNode(2);
        TreeNode t12 = new TreeNode(3);
        t10.left = t11;
        t10.right = t12;

        TreeNode t20 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        t20.left = t21;
        t20.right = t22;
        
        TreeNode t30 = new TreeNode(1);
        TreeNode t31 = new TreeNode(2);
        t30.left = t31;
        TreeNode t40 = new TreeNode(1);
        TreeNode t41 = new TreeNode(2);
        t40.right = t41;

        System.out.println(check(t10, t20));
        System.out.println(check(t30, t40));
    }

}
