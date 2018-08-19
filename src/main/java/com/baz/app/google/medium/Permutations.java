package com.baz.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
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
        int[] nums = {1,2,3};
        permute(nums).forEach( i -> {
            i.forEach( j -> System.out.print( j + " "));
            System.out.println();
        });
    }

}
