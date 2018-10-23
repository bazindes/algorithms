package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class LargestNumberAtLeastTwiceOfOthers implements Google {

    public int dominanIndexLinear(int[] nums){
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i == maxIndex) continue;
            if(nums[i] * 2 > nums[maxIndex])
                return -1;
        }
        return maxIndex;
    }
    public int dominantIndex(int[] nums){
        if(nums.length < 2) return 0;
        int [] n = new int[nums.length];
        for (int i = 0; i < n.length; i++) {
            n[i] = i;
        }
        n = mergeSort(nums, n, 0, nums.length-1);
        if(nums[n[n.length - 2]] * 2 > nums[n[n.length - 1]]) return -1;
        return n[n.length - 1];
    }

    private int[] mergeSort(int[] nums, int[] index, int start, int end){
        if(start == end) return new int[]{index[start]};
        int mid = (start + end) / 2;
        int [] l = null;
        int [] r = null;
        if(start < end){
            l = mergeSort(nums, index, start, mid);
            r = mergeSort(nums, index, mid + 1, end);
        }
        return merge(l , r, nums);
    }

    private int[] merge(int[] n1, int[] n2, int[]nums){
        int i = 0;
        int j = 0;
        int k = 0;
        int []re = new int[n1.length + n2.length];
        while (i < n1.length && j < n2.length){
            if(nums[n1[i]] < nums[n2[j]]){
                re[k++] = n1[i++];
            }
            else if(nums[n2[j]] < nums[n1[i]]){
                re[k++] = n2[j++];
            }
        }
        while (i < n1.length){
            re[k ++] = n1[i++];
        }
        while (j < n2.length){
            re[k ++] = n2[j++];
        }
        return re;
    }


    public void test(){
        int [] n1 = {3, 6, 1, 0};
        System.out.println(dominantIndex(n1));
        System.out.println(dominanIndexLinear(n1));
        int [] n2 = {1, 2, 3, 4};
        System.out.println(dominantIndex(n2));
        System.out.println(dominanIndexLinear(n2));
    }

}
