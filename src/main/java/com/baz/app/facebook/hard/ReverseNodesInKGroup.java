package com.baz.app.facebook.hard;

import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

public class ReverseNodesInKGroup {

    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     * Example:
     * Given this linked list: 1->2->3->4->5
     * For k = 2, you should return: 2->1->4->3->5
     * For k = 3, you should return: 3->2->1->4->5
     * Note:
     * Only constant extra memory is allowed.
     * You may not alter the values in the list's nodes, only nodes itself may be changed.
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k){
            cur = cur.next;
            count ++;
        }

        if(count == k){
            cur = reverseKGroup(cur, k);

            while (count -- > 0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }

            head = cur;
        }

        return head;
    }

    public ListNode reverseKGroupIter(ListNode head, int k){
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy;
        ListNode temp;
        int count;

        while (true){
            count = k;
            while (cur != null && count > 0){
                cur = cur.next;
                count --;
            }

            if(cur == null) break;

            head = prev.next;
            while (prev.next != cur){
                temp = prev.next;
                prev.next = temp.next;
                temp.next = cur.next;
                cur.next = temp;
            }

            cur = head;
            prev = head;
        }

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
        Utils.printLinkedList(reverseKGroupIter(l1, 2));
    }

}
