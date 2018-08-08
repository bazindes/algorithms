package com.baz.app.facebook.medium;

import com.baz.app.util.UndirectedGraphNode;
import com.baz.app.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    // BFS
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node == null) return null;

        if(map.containsKey(node.label)){
            return map.get(node.label);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode cur : node.neighbors) {
            clone.neighbors.add(cloneGraph(cur));
        }

        return clone;
    }


    public void test(){
        UndirectedGraphNode n0 = new UndirectedGraphNode(1);
        UndirectedGraphNode n1 = new UndirectedGraphNode(0);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
        n1.neighbors.add(n0);
        n1.neighbors.add(n2);
        n2.neighbors.add(n0);
        n2.neighbors.add(n1);
        n2.neighbors.add(n2);
        Utils.bfsTraverseUndirectedGraph(n0);
        System.out.println();
        UndirectedGraphNode clone = cloneGraph(n0);
        Utils.bfsTraverseUndirectedGraph(clone);
    }


}
