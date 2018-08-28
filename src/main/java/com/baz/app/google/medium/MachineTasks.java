package com.baz.app.google.medium;

public class MachineTasks {

    /**
     * 第一题，给两台server, 一个int array代表每个工作负荷， 分配使得abs diff在两台server间最小。用DP做的。
     */

    public int minABS(int[] nums){
        int ans = Integer.MAX_VALUE;
        ans = helper(nums, 0);
        return ans;
    }

    private int helper(int[] nums, int n){
        if(n == nums.length) return 0;
        int first = nums[n] + helper(nums , n + 1);
        int second = helper(nums, n + 1);
//        int first2 = helper(nums , n + 1);
//        int second2 = nums[n] + helper(nums, n + 1);
//        System.out.println("first: " + first  + " second: " + second + " first2: " + first2  + " second2: " + second2);
        System.out.println("first: " + first  + " second: " + second );
//        return Math.min(Math.abs(first - second) , Math.abs(second2 - first2));
        return Math.abs(first - second);
    }

    public void test(){
        int[]nums = {1, 3, 4, 2, 5};
        System.out.println(minABS(nums));
    }

}
