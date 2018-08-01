package com.baz.app.facebook.easy;

import com.baz.app.util.Utils;

public class MergeSortedArray {

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
