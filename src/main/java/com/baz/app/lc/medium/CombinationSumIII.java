package com.baz.app.lc.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[]nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }
        helper(ans, new ArrayList<>(), nums, k, n, 0);
        return ans;
    }

    private void helper(List<List<Integer>> list, List<Integer> temp, int[]nums, int k, int target, int start){
        if(k == 0 ){
            if(target == 0)
                list.add(new ArrayList<>(temp));
            return;
        }else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                helper(list, temp, nums, k - 1, target - nums[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void test(){
        combinationSum3(3, 7).forEach( i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}
