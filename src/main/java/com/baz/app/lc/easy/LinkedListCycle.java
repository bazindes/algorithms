package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle implements Facebook {

    /**
     * Given a linked list, determine if it has a cycle in it.
     *
     * Follow up:
     * Can you solve it without using extra space?
     */

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head))
                return true;
            else
                set.add(head);
            head = head.next;
        }
        return false;
    }

    //O(n) O(1)
    public boolean hasCycleTP(ListNode head){
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


}
