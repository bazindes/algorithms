package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal implements Facebook {

    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    // O(n) O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp --;

        while (pp >= 0){
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]){
                prev = stack.pop();
                ip --;
            }
            TreeNode temp = new TreeNode(postorder[pp]);
            if(prev != null){
                prev.left = temp;
            }else if(!stack.isEmpty()){
                TreeNode curTop = stack.peek();
                curTop.right = temp;
            }

            stack.push(temp);
            prev = null;
            pp --;
        }

        return root;
    }

    /**
     * The the basic idea is to take the last element in postorder array as the root, find the position of the root in the inorder array;
     * then locate the range for left sub-tree and right sub-tree and do recursion.
     * Use a HashMap to record the index of root in the inorder array.
     */
    // O(n) O(n)
    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }

    // O(n) O(n)
    public TreeNode buildTreeRecur(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (postStart < 0 || inStart < inEnd)
            return null;

        //The last element in postorder is the root.
        TreeNode root = new TreeNode(postorder[postStart]);

        //find the index of the root from inorder. Iterating from the end.
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                rIndex = i;
                break;
            }
        }
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
        root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
        return root;
    }

}
