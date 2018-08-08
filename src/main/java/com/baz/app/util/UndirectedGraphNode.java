package com.baz.app.util;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(){}
    public UndirectedGraphNode(int label){
        this.label = label;
        neighbors = new ArrayList<>();
    }

}
