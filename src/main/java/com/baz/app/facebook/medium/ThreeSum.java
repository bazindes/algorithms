package com.baz.app.facebook.medium;

import java.util.*;

public class ThreeSum {

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
