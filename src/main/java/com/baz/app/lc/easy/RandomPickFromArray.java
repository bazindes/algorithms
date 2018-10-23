package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Utils;

import java.util.Random;

public class RandomPickFromArray implements Facebook {

    /**
     * .给一个整数数组n[]，一个整数k，要求返回k个来自这个数组的随机数，要保证每个数字被随机到的概率相同。
     */
    public int[] randomPick(int[] nums, int k){
        int [] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = helper(nums, nums.length - i);
        }
        return ans;
    }

    private int helper(int[]nums, int len){
        Random random = new Random();
        int index = random.nextInt(len);
        swap(nums, len - 1, index);
        return nums[len - 1];
    }

    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void test(){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Utils.printArray(randomPick(nums, 3));
        Utils.printArray(randomPick(nums, 3));
        Utils.printArray(randomPick(nums, 3));
        Utils.printArray(randomPick(nums, 3));
    }

}
