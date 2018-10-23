package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum implements Facebook {

    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
     * Find all unique quadruplets in the array which gives the sum of target.
     * Note:
     * The solution set must not contain duplicate quadruplets.
     * Example:
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * A solution set is:
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     */

    //O(n^3) O(1)
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 4) return ans;
        Arrays.sort(nums);

        int max = nums[nums.length - 1];
        if( 4 * nums[0] > target || 4 * max < target) return ans;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(i > 0 && cur == nums[i - 1]) continue;
            if(cur + 3 * max < target) continue;
            if(4 * cur > target) break;
            if( cur * 4 == target){
                if(i + 3 < nums.length && nums[i + 3] == cur)
                    ans.add(Arrays.asList(cur , cur, cur, cur));
                break;
            }
            threeSum(nums, target - cur, i + 1, nums.length - 1, ans, cur);
        }

        return ans;
    }

    private void threeSum(int[] nums, int target, int low, int high, List<List<Integer>> ans, int prev){
        if(low + 1 >= high) return;
        int max = nums[high];
        if(3 * nums[low] > target || 3 * max < target) return;

        for (int i = low; i < high - 1; i++) {
            int cur = nums[i];
            if(i > low && cur == nums[i - 1]) continue;
            if(cur + 2 * max < target) continue;
            if(cur * 3 > target) break;
            if(cur * 3 == target){
                if(i + 1 < high && nums[i + 2] == cur)
                    ans.add(Arrays.asList(prev, cur, cur, cur));
                break;
            }
            twoSum(nums, target - cur, i + 1, high, ans, prev, cur);
        }
    }

    private void twoSum(int[] nums, int target, int low, int high, List<List<Integer>> ans, int prev, int prev2){
        if(low >= high) return;
        if(2 * nums[low] > target || 2 * nums[high] < target) return;
        int i = low;
        int j = high;
        int sum;
        int x;
        while (i < j){
            sum = nums[i] + nums[j];
            if(sum == target){
                ans.add(Arrays.asList(prev, prev2, nums[i], nums[j]));
                x = nums[i];
                while (++ i < j && x == nums[i]);
                x = nums[j];
                while (-- j > i && x == nums[j]);
            }
            if(sum < target)
                i ++;
            if(sum > target)
                j --;
        }
    }

    public void test(){
        int[] nums = {1, 0, -1, 0, -2, 2};
        fourSum(nums, 0).forEach( i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}
