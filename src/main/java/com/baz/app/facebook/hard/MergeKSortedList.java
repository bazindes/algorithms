package com.baz.app.facebook.hard;

import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        temp.next = helper(lists);
        while (temp.next != null){
            temp = temp.next;
            temp.next = helper(lists);
        }
        return ans;
    }

    public ListNode helper(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        int min = Integer.MAX_VALUE;
        for (ListNode node : lists){
            min = Math.min(min, node.val);
        }
        for (ListNode node : lists){
            if(node.val == min){
                node = node.next;
                break;
            }
        }
        return new ListNode(min);
    }

    public void test(){
        ListNode r00 = new ListNode(1);
        ListNode r01 = new ListNode(4);
        ListNode r02 = new ListNode(5);
        r00.next = r01;
        r01.next = r02;
        ListNode r10 = new ListNode(1);
        ListNode r11 = new ListNode(3);
        ListNode r12 = new ListNode(4);
        r10.next = r11;
        r11.next = r12;
        ListNode r20 = new ListNode(2);
        ListNode r21 = new ListNode(6);
        r20.next = r21;
        ListNode[] lists = {r00, r10, r20};

        Utils.printLinkedList(mergeKLists(lists));

    }

}
