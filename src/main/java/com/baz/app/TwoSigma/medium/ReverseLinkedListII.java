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
        // create a dummy node to mark the head of this list
        ListNode fake = new ListNode(0);
        fake.next = node;
        // make a pointer pre as a marker for the node before reversing
        ListNode prev = fake;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        // a pointer to the beginning of a sub-list that will be reversed
        ListNode start = prev.next;
        // a pointer to a node that will be reversed
        ListNode then = start.next;

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
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
