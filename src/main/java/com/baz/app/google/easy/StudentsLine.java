package com.baz.app.google.easy;

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
        int c = 1;
        int prevMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < prevMax) continue;
            else {
                prevMax = nums[i];
                c ++;
            }
        }
        return c;
    }

    public void test(){
        int[] nums = {7,8,4,9,1,6,5,7};
        System.out.println(count(nums));
    }

}
