package com.baz.app.google.easy;

import com.baz.app.util.Utils;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (sorted[i] == nums[i]) i++;
            if (sorted[j] == nums[j]) j--;
            if (sorted[i] != nums[i] && sorted[j] != nums[j]) break;
        }
        return i == j ? 0 : j - i + 1;
    }

    public void test(){
        int[] n = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(n));
    }

}
