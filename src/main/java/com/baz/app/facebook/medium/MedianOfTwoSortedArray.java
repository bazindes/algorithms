package com.baz.app.facebook.medium;

public class MedianOfTwoSortedArray {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * The median is 2.0
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * The median is (2 + 3)/2 = 2.5
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // corner case
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high){
            int px = (low + high) / 2;
            int py = (x + y + 1) / 2 - px;

            int maxLeftX = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            int minRightX = px == x ? Integer.MAX_VALUE : nums1[px];

            int maxLeftY = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            int minRightY = py == y ? Integer.MAX_VALUE : nums2[py];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if( (x + y) % 2 == 0){
                    return ( (double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) ) / 2;
                }else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                high = px - 1;
            }else {
                low = px + 1;
            }
        }

        throw new IllegalArgumentException();
    }


    public void test(){
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
