package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.Random;

public class RandomPickIndex implements Facebook {

    /**
     * Given an array of integers with possible duplicates, randomly output the index of a given target number.
     * You can assume that the given target number must exist in the array.
     *
     * Note:
     * The array size can be very large. Solution that uses too much extra space will not pass the judge.
     *
     * Example:
     *
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     *
     * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
     * solution.pick(3);
     *
     * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
     * solution.pick(1);
     */

    // O(n) O(1)
    public int pick(int target, int[] nums) {
        int ans = -1;
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != target)
                continue;
            // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index.
            // The probability is always 1/nums for the latest appeared number.
            // For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
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
