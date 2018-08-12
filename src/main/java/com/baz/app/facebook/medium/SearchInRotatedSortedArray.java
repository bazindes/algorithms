package com.baz.app.facebook.medium;

public class SearchInRotatedSortedArray {

    //Tricky BS
    public int search(int[] nums, int target) {
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

    public void test(){
        int[]nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }

}
