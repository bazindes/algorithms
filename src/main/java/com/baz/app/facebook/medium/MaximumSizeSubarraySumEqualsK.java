package com.baz.app.facebook.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

    /**
     * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
     * Note:
     * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
     * Example 1:
     * Input: nums = [1, -1, 5, -2, 3], k = 3
     * Output: 4
     * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
     *
     * Example 2:
     * Input: nums = [-2, -1, 2, 1], k = 1
     * Output: 2
     * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
     *
     * Follow Up:
     * Can you do it in O(n) time?
     */

    /** maintain a hashMap with sum from 0-i element as key, and i as values;
     *  for every i, if sum == k, update maxlen with i+1;
     *  else if map contains sum - k, means the subarray from  map.get(sum - k) + 1 to i will sum up to k;
     *  update maxLen with i - map.get(sum - k);
     *  if sum not in the map, add (sum, i) to the map;
     *  O(n) O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0;
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                len = i + 1;
            }else if(map.containsKey(sum - k)){
                len = Math.max(len, i - map.get(sum - k));
            }
            if(!map.containsKey(sum))
                map.put(sum, i);
        }

        return len;
    }

}
