package com.baz.app.facebook.medium;

public class MinimumSizeSubarraySum {

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
