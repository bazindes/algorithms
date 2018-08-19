package com.baz.app.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void helper(List<List<Integer>> list, List<Integer> temp, int[] cans, int target, int start){
        if(target <= 0){
            if(target == 0)
                list.add(new ArrayList<>(temp));
            return;
        }else {
            for (int i = start; i < cans.length; i++) {
                temp.add(cans[i]);
                helper(list, temp, cans, target - cans[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void test(){
        int[]cans = {2,3,6,7};
        combinationSum(cans, 7).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}
