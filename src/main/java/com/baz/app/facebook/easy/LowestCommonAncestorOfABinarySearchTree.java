package com.baz.app.facebook.easy;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.*;

public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
     * (where we allow a node to be a descendant of itself).”
     *
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *         _______3______
     *        /              \
     *     ___5__          ___1__
     *    /      \        /      \
     *    6      _2       0       8
     *          /  \
     *          7   4
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of of nodes 5 and 1 is 3.
     * Example 2:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
     *              according to the LCA definition.
     * Note:
     *
     * All of the nodes' values will be unique.
     * p and q are different and both values will exist in the binary tree.
     */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    // only apply for BST O(n): at most visit all nodes O(n)
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node.val > p.val && node.val > q.val){
            return helper(node.left, p, q);
        }else if(node.val < p.val && node.val < q.val){
            return helper(node.right, p, q);
        }else {
            return node;
        }
    }

    // apply to all BT O(n): at most visit all nodes O(n)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }

    // iterative O(n) O(n)
    public TreeNode lowestCommonAncesstorIter(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        map.put(root, null);
        stack.push(root);

        while (!map.containsKey(p) || !map.containsKey(q)){
            TreeNode temp = stack.pop();
            if(root.left != null){
                map.put(root.left, root);
                stack.push(root.left);
            }
            if(root.right != null){
                map.put(root.right, root);
                stack.push(root.right);
            }
        }

        Set<TreeNode> set = new HashSet<>();
        while (p != null){
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)){
            q = map.get(q);
        }

        return q;
    }

    /**
     * followup1：如果每个node包含parent指针
     * 更简单, 遍历 p 的 parents 放入 set，遍历 q 的 parents 并 check set 是否 contains
     * followup2：node的structure是只有当前node的值和parent node。
     */

    public void test(){
        TreeNode root = new TreeNode(6);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(8);
        TreeNode l1l2 = new TreeNode(0);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1l2 = new TreeNode(7);
        TreeNode r1r2 = new TreeNode(9);
        TreeNode l1r2l3 = new TreeNode(3);
        TreeNode l1r2r3 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;
        l1r2.left = l1r2l3;
        l1r2.right = l1r2r3;

        Utils.inOrderPrintTree(root);
        System.out.println();
        System.out.println(lowestCommonAncestor(root, l1, r1).val);
        System.out.println(lowestCommonAncestor2(root, l1, r1).val);
        System.out.println(lowestCommonAncestor(root, l1r2, l1).val);
        System.out.println(lowestCommonAncestor2(root, l1r2, l1).val);
        System.out.println(lowestCommonAncestor(root, l1r2l3, r1l2).val);
        System.out.println(lowestCommonAncestor2(root, l1r2l3, r1l2).val);
    }

}
