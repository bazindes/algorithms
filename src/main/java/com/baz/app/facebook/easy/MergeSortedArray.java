package com.baz.app.facebook.easy;

import com.baz.app.util.Utils;

public class MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     */

    public void merge(int[]nums1 , int m, int[]nums2, int n){
        if(nums1 == null || nums2 == null) return;
        int len = nums1.length - 1;
        while (n > 0 && m > 0){
            if(nums1[m - 1] <= nums2[n - 1]){
                nums1[len--] = nums2[n - 1];
                n --;
            }else {
                nums1[len--] = nums1[m - 1];
                m --;
            }
        }
        while (n > 0){
            nums1[len --] = nums2[n-1];
            n --;
        }
        Utils.printArray(nums1);
    }

    public void test(){
        int[] nums1 = {4, 5, 6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1 , 3, nums2, 3);
    }

}
