package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
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
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of of nodes 5 and 1 is 3.
     * Example 2:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
     *              according to the LCA definition.
     * Note:
     * All of the nodes' values will be unique.
     * p and q are different and both values will exist in the binary tree.
     */

    // O(n) O(n)
    public TreeNode lcaRecursive(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;

        TreeNode left = lcaRecursive(root.left, p , q);
        TreeNode right = lcaRecursive(root.right, p, q);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    // O(n) O(n)
    public TreeNode lacIter(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        map.put(root, null);
        dq.push(root);

        while (!map.containsKey(p) && !map.containsKey(q)){
            TreeNode cur = dq.pop();
            if(cur.left != null){
                map.put(cur.left, cur);
                dq.push(cur.left);
            }
            if(cur.right != null){
                map.put(cur.right, cur);
                dq.push(cur.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null){
            ancestors.add(p);
            p = map.get(p);
        }

        while (!ancestors.contains(q)){
            q = map.get(q);
        }

        return q;
    }

}
