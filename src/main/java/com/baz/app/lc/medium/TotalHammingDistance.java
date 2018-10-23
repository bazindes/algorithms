package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class TotalHammingDistance implements Facebook {

    public int totalHammingDistance(int[] nums){
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < n; j++) {
                bitCount += nums[j] >> i & 1;
            }
            ans += bitCount * (n - bitCount);
        }

        return ans;
    }

    public void test(){
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance(nums));
    }

}
