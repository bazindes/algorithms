package com.baz.app.lc.hard;

import com.baz.app.Interface.facebook.Facebook;

public class MaximumSumOf3NonOverlappingSubsarray implements Facebook {

    /**
     * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
     *
     * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
     *
     * Return the result as a list of indices representing the starting position of each interval (0-indexed).
     * If there are multiple answers, return the lexicographically smallest one.
     *
     * Example:
     * Input: [1,2,1,2,6,7,5,1], 2
     * Output: [0, 3, 5]
     * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     * Note:
     * nums.length will be between 1 and 20000.
     * nums[i] will be between 1 and 65535.
     * k will be between 1 and floor(nums.length / 3).
     */

    /**

     Since it's 3 non-overlapping sub-array, we can divide it into left, mid, right.
     Suppose mid is [i, i+k-1] because it needs to hav at least k elements, then
     we can have left is from [0,i-1] and right is from [i+k, n-1].

     Since left must have at least k elements then i-1-0+1 >= k , thus we have i>=k
     Same thing for the right, since n-1-(i-k)+1 >= k, thus we have i<=n-2k
     Thus we have k<=i<=n-2k , this is very important math to figure out.

     Then we have 2 arrays which stores the maximum starting index from left and from right.

     Finally, we figure out when i is in the range mentioned above, what would be the max from left and right and take
     the global max.

     */


    /**

     Since it's 3 non-overlapping sub-array, we can divide it into left, mid, right.
     Suppose mid is [i, i+k-1] because it needs to hav at least k elements, then
     we can have left is from [0,i-1] and right is from [i+k, n-1].

     Since left must have at least k elements then i-1-0+1 >= k , thus we have i>=k
     Same thing for the right, since n-1-(i-k)+1 >= k, thus we have i<=n-2k
     Thus we have k<=i<=n-2k , this is very important math to figure out.

     Then we have 2 arrays which stores the maximum starting index from left and from right.

     Finally, we figure out when i is in the range mentioned above, what would be the max from left and right and take
     the global max.

     */
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            if(nums==null || nums.length==0) {
                return null;
            }
            int len = nums.length;

            // this is very important because otherwise i+k is going to out of bounds.
            int[] sum = new int[len+1];
            int[] left = new int[len];
            int[] right = new int[len];
            int[] res = new int[3];
            int max = 0;

            // Computing the running sum
            // sum[i] stores the value from index 0 to i-1
            for (int i=0; i<len; i++) {
                sum[i+1] = sum[i] + nums[i];
            }

            // traversing from left to right
            int leftMax = sum[k]-sum[0];
            left[k-1] = 0;
            for (int i=k; i<len; i++) {
                if (sum[i+1] - sum[i+1-k] > leftMax) {
                    left[i] = i-k+1;
                    leftMax = sum[i+1] - sum[i+1-k];
                } else {
                    left[i] = left[i-1];
                }
            }

            // traversing from right to left
            int rightMax = sum[len] - sum[len-k];
            right[len-k] = len-k;
            for (int i=len-k-1; i>=0; i--) {
                if (sum[i+k] - sum[i] > rightMax) {
                    right[i] = i;
                    rightMax = sum[i+k] - sum[i];
                } else {
                    right[i] = right[i+1];
                }
            }

            // now consider the middle part where k<=i<=n-2k
            for (int i=k; i<=len-2*k; i++) {
                int l = left[i-1];
                int r = right[i+k];
                int total = (sum[l+k] - sum[l]) + (sum[i+k] - sum[i]) + (sum[r+k] - sum[r]);
                if (total > max) {
                    max = total;
                    res[0] = l;
                    res[1] = i;
                    res[2] = r;
                }
            }
            return res;
        }
    }

    // O(n) O(n)
    public int[] maxSumOfThreeSubarraysDP(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];
        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
            if (sum[i+1]-sum[i+1-k] > tot) {
                posLeft[i] = i+1-k;
                tot = sum[i+1]-sum[i+1-k];
            }
            else
                posLeft[i] = posLeft[i-1];
        }
        // DP for starting index of the right max sum interval
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k]-sum[i];
            }
            else
                posRight[i] = posRight[i+1];
        }
        // test all possible middle interval
        for (int i = k; i <= n-2*k; i++) {
            int l = posLeft[i-1], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }

    // dp[i][j] stands for in ith sum, the max non-overlap sum we can have from 0 to j
    // id[i][j] stands for in ith sum, the first starting index for that sum

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][]dp = new int[4][nums.length + 1];
        int sum = 0;
        int[] acc = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            acc[i] = sum;
        }

        int[][] id = new int[4][nums.length + 1];
        for(int i = 1; i < 4; i ++){
            for (int j = k - 1; j < nums.length; j ++){
                int temp = j - k < 0 ? acc[j] : acc[j] - acc[j - k] + dp[i - 1][j - k];

                if(j - k >= 0){
                    dp[i][j] = dp[i][j - 1];
                    id[i][j] = id[i][j - 1];
                }
                if(j > 0 && temp> dp[i][j - 1]) {
                    dp[i][j] = temp;
                    id[i][j] = j - k + 1;
                }

            }
        }

        int[] res = new int[3];
        res[2] = id[3][nums.length - 1];
        res[1] = id[2][res[2] - 1];
        res[0] = id[1][res[1] - 1];

        return res;
    }


}
