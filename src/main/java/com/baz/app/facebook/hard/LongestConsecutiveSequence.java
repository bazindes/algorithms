package com.baz.app.facebook.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * Your algorithm should run in O(n) complexity.
     * Example:
     * Input: [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     */

    //O(n + r) O(r) TLE
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums)
            max = Math.max(i, max);
        int[] buckets = new int[max + 1];
        for(int i : nums)
            buckets[i] ++;
        int left = 0;
        int right = 0;
        int ans = 0;
        while(right < buckets.length){
            if(buckets[right] != 0){
                ans = Math.max(ans, ans += (right - left));
                right ++;
            }else{
                left = right;
            }
        }
        return ans;
    }

    //O(n^3) O(1)
    public int longestConsecutiveBF(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        for (int i : nums){
            int cur = i;
            int len = 1;
            while (arrayContains(nums, cur + 1)){
                cur ++;
                len ++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    private boolean arrayContains(int[] nums, int tar){
        for (int i : nums){
            if (i == tar)
                return true;
        }
        return false;
    }

    //O(n) O(n)
    public int longestConsecutiveLinear(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);

        int max = 0;
        for (int i : nums){
            if(!set.contains(i - 1)){
                int nxt = i + 1;
                int len = 1;
                while (set.contains(nxt)){
                    nxt ++;
                    len ++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public void test(){
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveBF(nums));
        System.out.println(longestConsecutiveLinear(nums));
    }

}
