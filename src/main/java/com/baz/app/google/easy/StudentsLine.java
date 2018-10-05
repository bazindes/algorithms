package com.baz.app.google.easy;

import java.util.ArrayList;
import java.util.List;

public class StudentsLine {

    /**
     * . 给一个int array分组，比如[7,8,4,9,1,6,5,7], 就要分成三组[7] [8,4] [9,1,6,5,7], 因为每组头一个都是最大的数，输出是一共能分成多少组。
     * 我就定义了一个count，一个height = array[0], 然后loop整个array，如果有比height小的那就continue，如果比height大，那就把那个数给height然后count++,
     * 最后输出count
     */

    public int count(int[] nums){
        // corner case
        if(nums == null || nums.length == 0) return -1;
        // at least 1 line
        List<Integer> groups = new ArrayList<>();
        groups.add(nums[0]);

        for (int i = 1; i< nums.length; i ++){
            if(groups.get(groups.size() - 1) < nums[i])
                groups.add(nums[i]);
            else
                bsHelper(groups, nums[i]);
        }

        return groups.size();
    }

    private void bsHelper(List<Integer> nums, int tar){
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums.get(mid) == tar) {
                lo = mid;
                break;
            } else if(nums.get(mid) > tar){
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        nums.set(lo, tar);
    }

    public void test(){
        int[] nums = {7,8,4,9,1,6,5,7};
        System.out.println(count(nums));
        nums = new int[]{5, 4, 3, 6, 1};
        System.out.println(count(nums));
        nums = new int[]{3,1,2,5,3};
        System.out.println(count(nums));
        nums = new int[]{1,2,3,4,5};
        System.out.println(count(nums));
    }

}
