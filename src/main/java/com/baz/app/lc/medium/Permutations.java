package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations implements Facebook {

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
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(nums == null || nums.length == 0) return ans;
//        helper2(ans, 0, new ArrayList<>() , nums);
//        helper(ans, new ArrayList<>() , nums);
        iterative(ans, nums);
        return ans;
    }

    private void iterative(LinkedList<List<Integer>> ans, int[] nums){
        ans.add(new ArrayList<>());
        for (int i : nums){
            int size = ans.size();
            for (; size > 0; size --){
                List<Integer> cur = ans.pollFirst();
                for (int j = 0; j <= cur.size(); j++) {
                    List<Integer> temp = new ArrayList<>(cur);
//                    temp.add(i);
                    temp.add(j , i);
                    ans.add(temp);
                }
            }
        }
    }

    private void helper2(List<List<Integer>> ans, int s, List<Integer> temp, int[] nums){
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i <= temp.size(); i++) {
            List<Integer> l = new ArrayList<>(temp);
            l.add(i , nums[s]);
            helper2(ans, s + 1, l, nums);
        }
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums){
        if(nums.length == temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(ans, temp, nums);
            temp.remove(temp.size() - 1);

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
