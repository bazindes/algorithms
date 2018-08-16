package com.baz.app.facebook.medium;

import com.baz.app.util.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

    //Recursive Solution O(n) O(1)
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    //Iterative Solution O(n) O(1)
    public void connectIter(TreeLinkNode root){
        while (root != null){
            TreeLinkNode cur = root;
            while (cur!=null){
                if(cur.left != null) cur.left.next = cur.right;
                if(cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
    }

    //BFS O(N) O(N)

    public void test(){

    }

}
