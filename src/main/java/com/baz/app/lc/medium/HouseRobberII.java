package com.baz.app.lc.medium;

import com.baz.app.Interface.google.Google;

public class HouseRobberII implements Google {

    /***
     * O(n) O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int rob_rf = nums[0];
        int notRob_rf = 0;
        int rob_nrf = 0;
        int notRob_nrf = 0;

        for (int i = 1; i < nums.length; i++) {
            int temp = rob_rf;
            rob_rf = notRob_rf + nums[i];
            notRob_rf = Math.max(temp , notRob_rf);
            int temp2 = rob_nrf;
            rob_nrf = notRob_nrf + nums[i];
            notRob_nrf = Math.max(temp2 , notRob_nrf);
        }

        return Math.max(rob_nrf, notRob_rf);
    }

    public void test(){
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
        nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
    }

}
