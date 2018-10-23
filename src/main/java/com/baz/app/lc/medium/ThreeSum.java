package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.*;

public class ThreeSum implements Facebook {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * Note:
     * The solution set must not contain duplicate triplets.
     * Example:
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(0 - nums[i], i);
        }
        Set<Set<Integer>> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> e: map.entrySet()){
            for (int i = 0; i < nums.length; i++) {
                if(e.getValue() == i) continue;
                for (int j = 0; j < nums.length; j++) {
                    if(i != j || e.getValue() != j ){
                        if(e.getKey() == (nums[i] + nums[j])){
                            Set<Integer> temp = new HashSet<>();
                            temp.add(e.getValue());
                            temp.add(i);
                            temp.add(j);
                            if(temp.size() > 2){
                                set.add(temp);
                            }
                        }
                    }
                }
            }
        }

        for (Set<Integer> s: set){
            List<Integer> l = new ArrayList<>();
            for (int i:s){
                l.add(nums[i]);
            }
            list.add(l);
        }
        return list;
    }

    //O(n^2) O(n/1)
    public List<List<Integer>> threeSumBySort(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if(i == 0 || i>0 && nums[i] != nums[i - 1]){
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = - nums[i];

                while (lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo ++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi --;
                        lo ++;
                        hi --;
                    }else if(nums[lo] + nums[hi] < sum){
                        lo ++;
                    }else {
                        hi --;
                    }
                }
            }
        }


        return list;
    }

    public void test(){

        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums).forEach(System.out::print);
        System.out.println();
        threeSumBySort(nums).forEach(System.out::print);
    }
}
