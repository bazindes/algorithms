package com.baz.app.facebook.medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0)
                sum %= k;
            Integer prev = map.get(sum);
            if(prev != null){
                if(i - prev > 1) return true;
            }else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public void test(){
        int[]nums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums, 6));
    }

}
