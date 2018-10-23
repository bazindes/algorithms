package com.baz.app.lc.medium;

import com.baz.app.Interface.Google.Google;
import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

public class HouseRobberIII implements Google {

    public int rob(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0] , ans[1]);
}

    private int[] helper(TreeNode node){
        if(node == null) return new int[2];
        int[] ans = new int[2];
        int [] l = helper(node.left);
        int [] r = helper(node.right);
        ans[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        ans[1] = node.val + l[0] + r[0];
        return ans;
    }

    public void test(){
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(3);
        TreeNode r1r2 = new TreeNode(1);
        root.left = l1;
        root.right = r1;
        l1.right = l1r2;
        r1.right = r1r2;
        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(rob(root));
    }

}
