package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII implements Facebook {

    /**
     *
     Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }
     Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Note:

     You may only use constant extra space.
     Recursive approach is fine, implicit stack space does not count as extra space for this problem.
     Example:

     Given the following binary tree,

     1
     /  \
     2    3
     / \    \
     4   5    7
     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \    \
     4-> 5 -> 7 -> NULL

     */


    // O(n) O(1)
    public void connect(TreeLinkNode root) {
        while (root != null){
            TreeLinkNode temp = new TreeLinkNode(0);
            TreeLinkNode cur = temp;

            while (root != null){
                if(root.left != null){
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }

            root = temp.next;
        }
    }

}
