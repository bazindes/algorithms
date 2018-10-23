package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class SearchInRotatedSortedArray implements Facebook {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     */

    //Tricky BS
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi){
            int mid = (lo + hi) / 2;
            int cur = (target < nums[0] == nums[mid] < nums[0]) ? nums[mid] : target < nums[mid] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if(target > cur)
                lo = mid + 1;
            else if(target < cur)
                hi = mid;
            else
                return mid;
        }

        return -1;
    }

    public int searchReverse(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return mid;
            if(nums[lo] <= nums[mid]){
                if(target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }else {
                if(target > nums[mid] && target < nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }

        return nums[lo] == target ? lo : -1;
    }

    public void test(){
        int[]nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }

}
