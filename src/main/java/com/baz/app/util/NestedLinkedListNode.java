package com.baz.app.util;

public class NestedLinkedListNode {

    public int val;
    public NestedLinkedListNode next;
    public NestedLinkedListNode sub;

    public NestedLinkedListNode(){}

    public NestedLinkedListNode(int val){
        this.val = val;
    }

    public boolean hasSub(){
        return sub != null;
    }

}
