package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedList implements Facebook {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     *
     * For example, the following two linked lists:
     *
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3
     *                    ↗
     * B:     b1 → b2 → b3
     * begin to intersect at node c1.
     *
     * Notes:
     *
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     */

    // two pointer O(m+n) O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    //O(m+n) O(n)
    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode pa = headA;
        while (pa != null) {
            nodes.add(pa);
            pa = pa.next;
        }
        if (nodes.isEmpty()) {
            return null;
        }
        ListNode pb = headB;
        while (pb != null) {
            if (nodes.contains(pb)) {
                return pb;
            }
            pb = pb.next;
        }
        return null;
    }

}
