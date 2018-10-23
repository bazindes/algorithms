package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class MinimumSizeSubarraySum implements Facebook {

    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
     * If there isn't one, return 0 instead.
     *
     * Example:
     *
     * Input: s = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     * Follow up:
     * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     */

    public int minSubArrayLen(int s, int[] nums){
//        return bruteForceHelper(s, nums);
        return iterativeHelper(s, nums);
    }

    /**
     * O(n)
     */

    public int iterativeHelper(int s, int[] nums){
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s){
                len = Math.min(len, i + 1 - l);
                sum -= nums[l ++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }



    /**
     * BruteForce O(n^2)
     * @param s
     * @param nums
     * @return
     */
    public int bruteForceHelper(int s, int[] nums){
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= s){
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }

    public void test(){
        int[] nums = {2,3,1,2,4,3};
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(15, nums));
    }

}
