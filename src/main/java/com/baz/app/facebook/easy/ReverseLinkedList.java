package com.baz.app.facebook.easy;

import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     */

    public ListNode reverseList(ListNode head){
        return helper(head);
//        return iterativeHelper(head);
    }

    private ListNode iterativeHelper(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    private ListNode helper(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode temp = helper(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }

    public void test(){
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        Utils.printLinkedList(head);
        System.out.println();
        Utils.printLinkedList(reverseList(head));
    }

}
