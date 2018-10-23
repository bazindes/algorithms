package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Utils;

public class FindFirstAndLastPositionOfElementInSortedArray implements Facebook {

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     *
     * Example 1:
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */

    //O(logn + l) O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        //corner case
        if(nums == null || nums.length == 0) return ans;
        //general code
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                int l = mid;
                int r = mid;
                while (l-- > 0 && nums[l] == target);
                while (r++ < nums.length - 1 && nums[r] == target);
                ans[0] = l + 1;
                ans[1] = r - 1;
                break;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        if(nums.length == 1){
            if(nums[0] == target){
                ans[0] = 0;
                ans[1] = 0;
            }
        }
        return ans;
    }

    //bs O(logn) O(1)
    public int[] searchRangeImpro(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = bsHelper(nums, target, true);
        if(left == nums.length || nums[left] != target)
            return ans;
        ans[0] = left;
        ans[1] = bsHelper(nums, target, false) - 1;
        return ans;
    }

    private int bsHelper(int[] nums, int target, boolean flag){
        int lo = 0;
        int hi = nums.length;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target || (flag && nums[mid] == target)) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public void test(){
        int[] nums = {1, 4};
        Utils.printArray(searchRangeImpro(nums, 4));
    }

}
