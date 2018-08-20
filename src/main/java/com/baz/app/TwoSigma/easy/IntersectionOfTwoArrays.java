package com.baz.app.TwoSigma.easy;

import com.baz.app.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                ans.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int[] re = new int[ans.size()];
        if(re.length != 0){
            int j = 0;
            for (int i : ans) {
                re[j ++] = i;
            }
        }
        return re;
    }


    public void test(){
        int[] n1 = {1, 2, 2, 1};
        int[] n2 = {2, 2};
        Utils.printArray(intersection(n1, n2));
        n1 = new int[]{4,9,5};
        n2 = new int[]{9,4,9,8,4};
        Utils.printArray(intersection(n1, n2));
    }

}
