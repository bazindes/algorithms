package com.baz.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /**
     *
     Given a collection of distinct integers, return all possible permutations.
     Example:
     Input: [1,2,3]
     Output:
     [
     [1,2,3],
     [1,3,2],
     [2,1,3],
     [2,3,1],
     [3,1,2],
     [3,2,1]
     ]
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        helper(ans, new ArrayList<>() , nums);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums){
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                helper(ans, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void test(){
        int[]nums = {1, 2, 3};
        permute(nums).forEach( i -> {
            i.forEach( j -> System.out.print( j + " "));
            System.out.println();
        });
    }

}
