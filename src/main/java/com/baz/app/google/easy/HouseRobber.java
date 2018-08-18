package com.baz.app.google.easy;

public class HouseRobber {


    /***
     * O(n) O(n)
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int[] rob = new int[nums.length];
        int[] notRob = new int[nums.length];
        rob[0] = nums[0];
        notRob[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            rob[i] = notRob[i - 1] + nums[i];
            notRob[i] = Math.max(rob[i - 1], notRob[i - 1]);
        }

        return Math.max(rob[nums.length - 1], notRob[nums.length - 1]);
    }

    /***
     * O(n) O(1)
     * @param nums
     * @return
     */
    public int robOptimize(int[] nums){
        if(nums == null) return 0;
        int rob = nums[0];
        int notRob = 0;
        if(nums.length == 1) return rob;
        for (int i = 1; i < nums.length; i++) {
            int temp = rob;
            rob = nums[i] + notRob;
            notRob = Math.max(temp, notRob);
        }
        return Math.max(rob, notRob);
    }

    public void test(){
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

}
