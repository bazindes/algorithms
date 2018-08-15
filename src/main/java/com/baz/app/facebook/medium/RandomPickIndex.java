package com.baz.app.facebook.medium;

import java.util.Random;

public class RandomPickIndex {

    public int pick(int target, int[] nums) {
        int ans = -1;
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != target)
                continue;
            if(random.nextInt(++count) == 0)
                ans = i;
        }

        return ans;
    }

    public void test(){
        int[] nums = {1,2,3,3,3};
        System.out.println(pick(3, nums));
        System.out.println(pick(1, nums));
        System.out.println(pick(4, nums));
    }

}
