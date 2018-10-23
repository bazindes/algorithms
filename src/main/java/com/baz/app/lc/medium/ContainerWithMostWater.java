package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class ContainerWithMostWater implements Facebook {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     *
     * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     *
     * Example:
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     */

    //BruteForce O(n^2) O(1)
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j <height.length ; j++) {
                ans = Math.max((j - i) * Math.min(height[i] ,height[j]), ans);
            }
        }
        return ans;
    }

    //Greedy O(N) O(1)
    public int maxAreaGreedy(int[] height){
        if(height == null || height.length == 0) return 0;
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            int lh = height[i];
            int rh = height[j];
            ans = Math.max((j - i) * Math.min(lh,rh), ans);
            if(lh < rh){
                i ++;
            }else {
                j --;
            }
        }
        return ans;
    }

    public void test(){
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
        System.out.println(maxAreaGreedy(h));
    }
}
