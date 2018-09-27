package com.baz.app.facebook.medium;

import java.util.*;

public class Subsets {

    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    //Recursive Solution O(2^n) O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, list, temp);
        return list;
    }

    private void helper(int[]nums , int n, List<List<Integer>> list, List<Integer> temp){
        list.add(new ArrayList<>(temp));
        for (int i = n; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsIterative(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                List<Integer> a = new ArrayList<>(list.get(j));
                a.add(nums[i]);
                temp.add(a);
            }
            list.addAll(temp);
        }

        return list;
    }

    public void test(){
        int [] ns = {1,2,3};
        subsetsIterative(ns).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }
}
