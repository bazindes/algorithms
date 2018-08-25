package com.baz.app.facebook.hard;

import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
//        return helper(lists);
    }

    //O(n * k) O(nk)
    public ListNode helper(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length , (l1, l2) -> l1.val - l2.val);
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        for (ListNode l : lists){
            priorityQueue.add(l);
        }

        while (!priorityQueue.isEmpty()){
            temp.next = priorityQueue.poll();
            temp = temp.next;

            if(temp.next != null)
                priorityQueue.add(temp.next);
        }

        return ans.next;
    }

    //Recursion Solution O(nklogn)
    public ListNode helper(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        if(start < end){
            int mid = start + (end - start) / 2;
            ListNode temp1 = helper(lists, start, mid);
            ListNode temp2 = helper(lists, mid + 1, end);
            return merge(temp1, temp2);
        }else {
            return null;
        }
    }

    private ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
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
        System.out.println();
        Utils.printLinkedList(helper(lists, 0, lists.length-1));

    }

}