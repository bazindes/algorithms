package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;

public class TrappingRainWater implements Facebook {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     *
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
     * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * Example:
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */

    //DP O(n) O(n)
    public int trap(int[] height) {
        // corner case
        if(height == null || height.length == 0) return 0;

        int ans = 0;
        int len = height.length;
        // left, right indicate
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len; i++) {
            if(i == 0)
                left[i] = Math.max(left[i], height[i]);
            else
                left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = len - 1; i >= 0; i--) {
            if(i == len - 1)
                right[i] = Math.max(right[i], height[i]);
            else
                right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    // Two Pointer O(n) O(1)
    public int trapTP(int[] height){
        // corner case
        if(height == null || height.length == 0) return 0;

        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        // when we move one of pointers, calculate how much water current height can have
        int maxL = 0;
        int maxR = 0;

        while (left < right){
            if(height[left] < height[right]){
                //move left pointer and track maxL
                if(height[left] >= maxL)
                    maxL = height[left];
                else
                    ans += (maxL - height[left]);

                left ++;
            }else {
                //move right pointer and track maxR
                if(height[right] >= maxR)
                    maxR = height[right];
                else
                    ans += (maxR - height[right]);

                right --;
            }
        }

        return ans;
    }

    /**
     * 变体(-1 表示漏⽔， V存的⽔都能漏下)
     * [3, 1, -1, 2,1,2]  结果为1，  [2,1,2] subarray 可以存⽔
     * [3, 1, 1, 2,1,2]  结果为3，subarray  [3, 1, 1, 2]  [2,1,2] 都可以存⽔
     *
     * 1. check all heights are -1
     * 2. calculate divided sub-arrays, then pick the max or sum them,
     * 3. only need to calculate length >= 3 ones
     */

    public void test(){
        int[] n = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(n));
    }

}
