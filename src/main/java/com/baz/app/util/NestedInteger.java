package com.baz.app.util;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    private Integer i;
    private List<NestedInteger> list;
    // Constructor initializes an empty nested list.
    public NestedInteger(){
        list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value){
        i = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return i != null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return i;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){
        i = value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return list;
    }

}
