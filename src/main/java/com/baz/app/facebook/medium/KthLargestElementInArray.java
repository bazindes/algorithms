package com.baz.app.facebook.medium;

import com.baz.app.util.Utils;

import java.util.Arrays;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public void test(){
        int[] ns = {3,2,1,5,6,4};
        System.out.println(findKthLargest(ns, 2));
        Utils.printArray(ns);
        ns = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(ns, 4));
        Utils.printArray(ns);

    }

}
