package com.baz.app.facebook.easy;

import com.baz.app.util.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {


    /**
     * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     * Example 1:
     * Input: [[1,1],2,[1,1]]
     * Output: 10
     * Explanation: Four 1's at depth 2, one 2 at depth 1.
     * Example 2:
     * Input: [1,[4,[6]]]
     * Output: 27
     * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
     */

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

    // O(n) O(n)
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        int sum = 0;
        for(NestedInteger ni : nestedList){
            sum += helper(ni, 1);
        }
        return sum;
    }

    private int helper(NestedInteger nestedInteger, int level){
        if(nestedInteger.isInteger()){
            return nestedInteger.getInteger() * level;
        }
        int sum = 0;
        for (NestedInteger ni : nestedInteger.getList()){
            sum += helper(ni, level + 1);
        }
        return sum;
    }

    //O(m) O(n)
    public int depthSum2(List<NestedInteger> nestedList){
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int level){
        if(list == null || list.size() == 0) return 0;
        int sum = 0;
        for (NestedInteger ni : list){
            if(ni.isInteger()){
                sum += ni.getInteger() * level;
            }else {
                sum += helper(ni.getList(), level + 1);
            }
        }
        return sum;
    }


    public void test(){
        NestedInteger n0 = new NestedInteger();
        NestedInteger n1 = new NestedInteger(1);
        n0.add(n1);
        NestedInteger n4 = new NestedInteger();
        NestedInteger n5 = new NestedInteger(4);
        NestedInteger n6 = new NestedInteger();
        NestedInteger n7 = new NestedInteger(6);
        n4.add(n5);
        n6.add(n7);
        n4.add(n6);
        List<NestedInteger> list = new ArrayList<>();
        list.add(n1);
        list.add(n4);
        System.out.println(depthSum(list));
        System.out.println(depthSum2(list));
    }

}
