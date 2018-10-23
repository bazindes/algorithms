package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class SearchInRotatedSortedArrayII implements Facebook {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
     *
     * You are given a target value to search. If found in the array return true, otherwise return false.
     *
     * Example 1:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     * Follow up:
     *
     * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
     * Would this affect the run-time complexity? How and why?
     */

    // O(logn) O(1)
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            // found and return
            if (nums[mid] == target)
                return true;
            // check whether on mid position, the right side is sorted or the left side is rotated
            if(nums[mid] < nums[hi] || nums[mid] < nums[lo]){
                // if the target is on the same side with mid, and target is larger
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            // check whether on mid position, the left side is sorted or the right side is rotated
            }else if(nums[mid] > nums[hi] || nums[mid] > nums[lo]){
                // if the target is on the same side with mid, and target is smaller
                if(target < nums[mid] && target >= nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            // if meets duplicate, move hi or move lo
            }else {
                hi --;
            }
        }

        return false;
    }

    // O(logn) O(1)
    public boolean search2(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }

}
