package com.baz.app.google;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinAnArray {

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
