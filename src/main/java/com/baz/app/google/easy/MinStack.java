package com.baz.app.google.easy;

public class MinStack {

    private Node node;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if(node == null){
            node = new Node(x, x, null);
        }else {
            node = new Node(Math.min(node.min, x), x, node);
        }
    }

    public void pop() {
        if(node!=null){
            node = node.next;
        }
    }

    public int top() {
        if(node!=null){
            return node.val;
        }
        return -1;
    }

    public int getMin() {
        if(node!=null){
            return node.min;
        }
        return -1;
    }

    private class Node{
        int min;
        int val;
        Node next;

        public Node(int min, int val, Node next) {
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }

    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


}
