package com.baz.app.util;

public class DoubleLinkedListNode {

    public int key;
    public int val;

    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int val){
        this.val = val;
    }

    public DoubleLinkedListNode(int key, int val){
        this.key = key;
        this.val = val;
    }

}
