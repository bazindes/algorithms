package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

public class RemoveNthNodeFromEndofList implements Facebook {

    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     * Example:
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Follow up:
     * Could you do this in one pass?
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for ( int i = 1; i<= n + 1; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Utils.printLinkedList(l1);
        System.out.println();
        Utils.printLinkedList(removeNthFromEnd(l1 , 3));
    }
}
