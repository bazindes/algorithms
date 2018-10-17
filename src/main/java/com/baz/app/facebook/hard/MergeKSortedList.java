package com.baz.app.facebook.hard;

import com.baz.app.util.ListNode;
import com.baz.app.util.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */

    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
//        return helper(lists);
    }

    // using PQ, O(nlogk) O(k)
    public ListNode helper(ListNode[] lists){
        // corner case
        if(lists == null || lists.length == 0) return null;

        // use minHeap to help keeping order
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length , (l1, l2) -> l1.val - l2.val);

        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        // put all heads into pq
        for (ListNode l : lists){
            if(l != null)
                priorityQueue.add(l);
        }

        // pick one from pq and add it's next to pq till all nodes are in pq
        while (!priorityQueue.isEmpty()){
            temp.next = priorityQueue.poll();
            temp = temp.next;

            if(temp.next != null)
                priorityQueue.add(temp.next);
        }

        return ans.next;
    }

    //Recursion Solution O(nlogk) O(1)
    // two lists merge and recursively merge the previous result
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

    // merge linkedlist in-place
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

    /**
     * merge之后实现⼀个iterator class， 实现hasNext()和next()
     */

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
