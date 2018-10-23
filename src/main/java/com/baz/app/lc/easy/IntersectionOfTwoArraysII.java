package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII implements Facebook {

    /**
     * Given two arrays, write a function to compute their intersection.
     * Example 1:
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * Follow up:
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */

    //O(n) O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i : nums1){
            map.put(i , map.getOrDefault(i, 0) + 1);
        }
        for(int i : nums2){
            if(map.containsKey(i)){
                if(map.get(i) > 0){
                    ans.add(i);
                    map.put(i , map.get(i) - 1);
                }
            }
        }
        int[] re = new int[ans.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = ans.get(i);
        }
        return re;
    }

    public void test(){

    }

}
