package com.baz.app.facebook.easy;

import com.baz.app.util.NestedLinkedListNode;

public class NestedLinkedList {

    /**
     *  linkedlist 1->2->S1->5->8
     *     S1有sub 可以call sub去查看S1的sub，S1的sub也可能有sub。。用recursive写
     *     没有说input是sorted。
     * 比如linked list 1->3->S1->8->10, S1.sub = 4->S2->6, S2.sub = 5
     * return 1->3->4->5->6->8->10
     */

    public void print(NestedLinkedListNode head){
        if(head == null) return;
        while (head != null){
            if(head.hasSub())
                print(head.sub);
            else
                System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public void test(){
        NestedLinkedListNode head = new NestedLinkedListNode(1);
        NestedLinkedListNode h1 = new NestedLinkedListNode(3);
        NestedLinkedListNode h2 = new NestedLinkedListNode();
        NestedLinkedListNode h2s1 = new NestedLinkedListNode(4);
        NestedLinkedListNode h2s2 = new NestedLinkedListNode();
        NestedLinkedListNode h2s2s1 = new NestedLinkedListNode(5);
        NestedLinkedListNode h2s3 = new NestedLinkedListNode(6);
        NestedLinkedListNode h3 = new NestedLinkedListNode(8);
        NestedLinkedListNode h4 = new NestedLinkedListNode(10);
        head.next = h1;
        h1.next = h2;
        h2.sub = h2s1;
        h2s1.next = h2s2;
        h2s2.sub = h2s2s1;
        h2s2.next = h2s3;
        h2.next = h3;
        h3.next = h4;
        print(head);
    }

}
