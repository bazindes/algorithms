package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.UndirectedGraphNode;
import com.baz.app.util.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CloneGraph implements Facebook {

    /**
     * Given the head of a graph, return a deep copy (clone) of the graph.
     * Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors.
     * There is an edge between the given node and each of the nodes in its neighbors.
     *
     * OJ's undirected graph serialization (so you can understand error output):
     * Nodes are labeled uniquely.
     * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
     * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
     * The graph has a total of three nodes, and therefore contains three parts as separated by #.
     * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
     * Second node is labeled as 1. Connect node 1 to node 2.
     * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
     *
     * Visually, the graph looks like the following:
     *
     *        1
     *       / \
     *      /   \
     *     0 --- 2
     *          / \
     *          \_/
     * Note: The information about the tree serialization is only meant so that you can understand error output if you get a wrong answer. You don't need to understand the serialization to solve the problem.
     */

    // DFS O(V + E) O(V + E)
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

    //BFS O(V + E) O(V + E)
    public UndirectedGraphNode cloneGraphIter(UndirectedGraphNode node){
        if(node == null) return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(newNode.label, newNode);

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode n : cur.neighbors){
                if(!map.containsKey(n.label)){
                    map.put(n.label, new UndirectedGraphNode(n.label));
                    queue.add(n);
                }
                map.get(cur.label).neighbors.add(map.get(n.label));
            }
        }

        return newNode;
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
