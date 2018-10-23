package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.ListNode;

import java.util.Stack;

public class PalindromeLinkedList implements Facebook {
    //recursive O(n) O(n)
    ListNode root = null;
    public boolean isPalindrome(ListNode head) {
        root = head;
        return root == null || helper(root);
    }

    private boolean helper(ListNode node){
        boolean flag = true;
        if(node.next != null){
            flag = helper(node.next);
        }
        if(flag && root.val == node.val){
            root = root.next;
            return true;
        }
        return false;
    }

    //O(n) O(1) reverse the original linkedlist right halve


    public void test(){
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        head.next = h1;
        System.out.println(isPalindrome(head));
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(1);
        h1.next = h2;
        h2.next = h3;
        System.out.println(isPalindrome(head));
    }

}
