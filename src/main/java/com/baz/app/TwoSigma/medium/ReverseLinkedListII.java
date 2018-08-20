package com.baz.app.TwoSigma.medium;

import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

import java.util.List;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n){
        return helperIter(head, m, n);
    }

    /**
     * Iterative
     */
    private ListNode helperIter(ListNode node, int m, int n){
        if(node == null) return null;
        ListNode fake = new ListNode(0);
        fake.next = node;
        ListNode prev = fake;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return fake.next;
    }


    public void test(){
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Utils.printLinkedList(head);
        System.out.println();
        Utils.printLinkedList(reverseBetween(head, 2, 4));
    }

}
