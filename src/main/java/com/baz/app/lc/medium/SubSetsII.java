package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII implements Facebook {

    /**
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     * Note: The solution set must not contain duplicate subsets.
     * Example:
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */

    //Recursive Solution
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, list, temp);
        return list;
    }

    private void helper(int[]nums, int n, List<List<Integer>> list, List<Integer> temp){
        list.add(new ArrayList<>(temp));
        for (int i = n; i < nums.length; i++) {
            if(i > n && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            helper(nums, i + 1, list, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public void test(){
        int[] nums = {1,2,2};
        subsetsWithDup(nums).forEach(i -> {
            i.forEach( j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}
