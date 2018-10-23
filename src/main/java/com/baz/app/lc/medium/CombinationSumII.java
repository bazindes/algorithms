package com.baz.app.lc.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combineSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
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
                if(i > start && cans[i] == cans[i - 1]) continue;
                temp.add(cans[i]);
                helper(list, temp, cans, target - cans[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public void test(){
        int[] cans = {10,1,2,7,6,1,5};
        combineSum2(cans, 8).forEach(i -> {
            i.forEach( j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}
