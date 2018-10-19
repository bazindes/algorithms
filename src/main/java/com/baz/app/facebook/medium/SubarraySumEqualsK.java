package com.baz.app.facebook.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
     *
     * Example 1:
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     * Note:
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //when nums[x] == k that is current sum itself is equal to target without any subtractions.
        // For this solution, we can either increment count by 1 whenever sum == k below or make an entry as a special case in our map
        map.put(0 , 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

}
