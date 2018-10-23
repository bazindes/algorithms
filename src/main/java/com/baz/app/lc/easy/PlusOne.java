package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.Interface.google.Google;
import com.baz.app.util.Utils;

public class PlusOne implements Facebook, Google {

    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * Example 1:
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     */

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;

        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }

        int [] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public int[] plusOne2(int[]nums){
        if(nums == null || nums.length == 0) return new int[]{0};
        int[] result = new int[nums.length];
        int count = 0;
        for(int i=nums.length-1;i>-1;i--){
            if(nums[i]!=9) break;
            if(nums[i]==9) count ++;
        }
        if(count > 0){
            if(count == nums.length){
                result = new int[nums.length+1];
                result[0]=1;
            }else{
                for(int i=nums.length-1;i>nums.length-1-count;i--){
                    nums[i] = 0;
                }
                nums[nums.length-1-count] += 1;
                return nums;
            }
        }else{
            nums[nums.length-1] += 1;
            return nums;
        }
        return result;
    }

    public void test(){
        int[] num = {1, 2, 3};
        Utils.printArray(plusOne(num));
        num = new int[]{ 9, 9, 9, 9 };
        Utils.printArray(plusOne(num));
    }

}
