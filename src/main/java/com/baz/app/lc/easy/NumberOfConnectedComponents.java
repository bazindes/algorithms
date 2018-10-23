package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;
import com.baz.app.util.DoubleLinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents implements Google {

    /**
     * 1，给一个array，里面全是reference to some doubly linked list node，找出number of connected component
     * for example:
     * doubly linked list: A<->B<->C<->D<->E<->F<->G
     * input: [A, B, D, F, G]
     * 答案就是3 (A&B, D, F&G)
     */
    public int getNum(DoubleLinkedListNode[] nodes){
        if(nodes == null || nodes.length == 0) return 0;
        Set<DoubleLinkedListNode> set = new HashSet<>();
        for (int i = 0; i < nodes.length; i++) {
            set.add(nodes[i]);
        }
        int ans = 0;
        for (int i = 0; i<nodes.length ; i++){
            DoubleLinkedListNode cur = nodes[i];
            if(set.contains(cur)){
                DoubleLinkedListNode tempL = cur.prev;
                DoubleLinkedListNode tempR = cur.next;
                while (tempL != null){
                    set.remove(tempL);
                    tempL = tempL.prev;
                }
                while (tempR != null){
                    set.remove(tempR);
                    tempR = tempR.next;
                }
                set.remove(cur);
                ans ++;
            }
        }

        return ans;
    }

    public void test(){
        DoubleLinkedListNode a = new DoubleLinkedListNode(0);
        DoubleLinkedListNode b = new DoubleLinkedListNode(1);
        a.next = b;
        b.prev = a;
        DoubleLinkedListNode d = new DoubleLinkedListNode(3);
        DoubleLinkedListNode f = new DoubleLinkedListNode(5);
        DoubleLinkedListNode g = new DoubleLinkedListNode(6);
        f.next = g;
        g.prev = f;

        DoubleLinkedListNode[] ds = {a, b, d, g, f};

        System.out.println(getNum(ds));
    }
}
