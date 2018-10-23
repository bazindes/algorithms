package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer implements Facebook {

    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     *
     * Return a deep copy of the list.
     */

    //Using a hashmap O(n) O(n)
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        while (temp != null){
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        RandomListNode temp2 = head;
        for (RandomListNode cur : map.keySet()){
            if(cur.next != null){
                map.get(cur).next = map.get(cur.next);
            }
            if(cur.random != null){
                map.get(cur).random = map.get(cur.random);
            }
        }

        return map.get(head);
    }


    //O(n) O(1)
    public RandomListNode copyRandomListIter(RandomListNode head) {
        //first round copy every node and inert new node behind the current node and current node.next
        RandomListNode node = head;
        RandomListNode next;
        while (node != null){
            next = node.next;

            RandomListNode copy = new RandomListNode(node.label);
            node.next = copy;
            copy.next = next;

            node = next;
        }


        //second round assign the random
        node = head;
        while (node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }


        //Third round exact copy list and restore the original list
        node = head;
        RandomListNode forReturn = new RandomListNode(0);
        RandomListNode iter = forReturn;
        RandomListNode copy;
        while (node != null){
            next = node.next.next;

            copy = node.next;
            iter.next = copy;
            iter = copy;

            node.next = next;
            node = next;
        }

        return forReturn.next;
    }

}
