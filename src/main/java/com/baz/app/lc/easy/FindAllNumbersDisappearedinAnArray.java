package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinAnArray implements Google {
    /*
        trick is the elements in array is 1 to n,
        however, the index of this array is 0 to n-1
        thus, we just mark every index appear in array to negative
        then, the positive ones are the missing ones
     */
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            nums[val] = - nums[val];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }

    public void test(){

    }
}
