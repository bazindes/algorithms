package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum implements Facebook {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else {
                map.put(target - nums[i] , i);
            }
        }
        return new int[]{};
    }

    public void test(){
        int[] nums = {2, 7, 11, 15};
        Utils.printArray(twoSum(nums, 9));
    }

}
