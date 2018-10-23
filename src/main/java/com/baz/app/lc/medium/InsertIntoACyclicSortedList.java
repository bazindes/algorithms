package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

public class InsertIntoACyclicSortedList implements Facebook {

    /**
     * Given a node from a cyclic linked list which is sorted in ascending order,
     * write a function to insert a value into the list such that it remains a cyclic sorted list.
     * The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
     *
     * If there are multiple suitable places for insertion, you may choose any place to insert the new value.
     * After the insertion, the cyclic list should remain sorted.
     *
     * If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node.
     * Otherwise, you should return the original given node.
     *
     * The following example may help you understand the problem better:
     *
     *  2       (head) 3 -> 4 -> 1 -> 3
     *          (head) 3 -> 4 -> 1 -> 2 -> 3
     *
     * In the figure above, there is a cyclic sorted list of three elements.
     * You are given a reference to the node with value 3, and we need to insert 2 into the list.
     *
     * The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.
     */

    public ListNode insert(ListNode head, int insertVal) {
        if(head == null) return new ListNode(insertVal);
        ListNode dummy = head;
        int prev = head.val;
        if(head.val < insertVal){
            while (dummy.next != head && dummy.next.val > prev && dummy.next.val < insertVal){
                prev = dummy.val;
                dummy = dummy.next;
                if(dummy.val > insertVal)
                    break;
            }
        }else {
            while (dummy.next != head && dummy.next.val >= prev){
                prev = dummy.val;
                dummy = dummy.next;
            }
            while (dummy.next != head && dummy.next.val < insertVal){
                dummy = dummy.next;
                if(dummy.next.val > insertVal)
                    break;
            }
        }
        ListNode temp = dummy.next;
        dummy.next = new ListNode(insertVal);
        dummy.next.next = temp;
        return head;
    }


    public void test(){
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(3);
        ListNode h2 = new ListNode(5);
        head.next = h1;
        h1.next = h2;
        h2.next = head;
        Utils.printCyclicLinkedList(head);
        System.out.println();
        Utils.printCyclicLinkedList(insert(head, 6));

    }

}
