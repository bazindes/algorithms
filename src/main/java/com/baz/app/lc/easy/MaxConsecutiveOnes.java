package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;

public class MaxConsecutiveOnes implements Google {

    public int findMaxConsecutiveOnes(int [] nums){
        if(nums == null || nums.length == 0) return 0;
        int re = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 1) {
                index = i;
            }else {
                re = Math.max(i - index + 1 , re);
            }
        }

        return re;
    }

}
