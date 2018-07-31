package com.baz.app.google.easy;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[]nums, int k){
        double avg = - Double.MAX_VALUE;
        if(k == 1){
            for (int i = 0; i < nums.length; i++) {
                avg = Math.max(avg, (double)nums[i]);
            }
        }else {
            for (int i = 0; i < nums.length - k; i++) {
                double sum = 0;
                for (int j = i; j < i+k; j++) {
                    sum += nums[j];
                }
                avg = Math.max(avg, sum/k);
            }
        }
        return avg;
    }

    /**
     * R.T.: O(n)
     * Space Complexity: O(1)
     * */
    public double findMaxAverageSlidingWindow(int[] nums, int k){
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double ans = sum;
        for (int i = k; i < nums.length; i++) {
            ans = Math.max(ans, sum + nums[i] - nums[i-k]);
        }
        return ans / k;
    }

    /**
     * R.T.: O(n)
     * Space Complexity: O(n)
     * */
    public double findMaxAverage2(int[] nums, int k){
        double[] sums = new double[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        double ans = sums[k - 1] / k;
        for (int i = k; i < sums.length; i++) {
            ans = Math.max(ans, (sums[i] - sums[i-k])/k);
        }
        return ans;
    }

    public void test(){
        int [] a = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage2(a, 4));
        System.out.println(findMaxAverageSlidingWindow(a, 4));
        int [] b = {-1};
        System.out.println(findMaxAverage2(b, 1));
        System.out.println(findMaxAverageSlidingWindow(b, 1));
    }

}
