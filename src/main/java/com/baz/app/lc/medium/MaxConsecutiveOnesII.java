package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesII implements Facebook {

    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
     *
     * Example 1:
     * Input: [1,0,1,1,0]
     * Output: 4
     * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     *     After flipping, the maximum number of consecutive 1s is 4.
     * Note:
     *
     * The input array will only contain 0 and 1.
     * The length of input array is a positive integer and will not exceed 10,000
     * Follow up:
     * What if the input numbers come in one by one as an infinite stream?
     * In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
     */

    // O(n) O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        if(nums == null || nums.length == 0) return ans;

        int count = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if(nums[right] == 0){
                count ++;
            }
            right ++;
            if(count <= 1)
                ans = Math.max(ans, right - left);
            while (left < nums.length && count > 1){
                if(nums[left] == 0){
                    count --;
                }
                left ++;
            }
        }

        return ans;
    }

    // O(n) O(1), smarter
    public int findMaxConsecutiveOnesOnePass(int[] nums) {
        int maxConsecutive = 0, zeroLeft = 0, zeroRight = 0;
        for (int i=0;i<nums.length;i++) {
            zeroRight++;
            if (nums[i] == 0) {
                zeroLeft = zeroRight;
                zeroRight = 0;
            }
            maxConsecutive = Math.max(maxConsecutive, zeroLeft+zeroRight);
        }
        return maxConsecutive;
    }

    // follow up
    public int findMaxConsecutiveOnesKsize(int[] nums, int k) {
        int max = 0; // flip at most k zero, use long if very big
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)
                zeroIndex.offer(h);
            if (zeroIndex.size() > k)
                l = zeroIndex.poll() + 1;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }

    public void test(){
        int[] nums = {1,0,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
