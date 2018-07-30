package com.baz.app.google.easy;

import com.baz.app.util.Utils;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums){
        if(nums == null || nums.length == 0) return new String[]{};
        String [] result = new String[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, 0, nums.length-1, indexes);
        for (int i = 0; i < nums.length; i++) {
            if(i < 3){
                switch (i){
                    case 0:result[indexes[i]] = "Gold Medal"; break;
                    case 1:result[indexes[i]] = "Silver Medal"; break;
                    case 2:result[indexes[i]] = "Bronze Medal"; break;
                }
            }else {
                result[indexes[i]] = (i+1) + "";
            }
        }
        return result;
    }

    private void mergeSort(int[]nums , int l, int r, int[]indexes){
        if(l < r){
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid, indexes);
            mergeSort(nums, mid+1, r, indexes);
            merge(nums, l, r, mid, indexes);
        }
    }

    private void merge(int[]a, int l, int r, int mid, int[]indexes){
        int i = mid - l + 1;
        int j = r - mid;
        int [] left = new int[i];
        int [] leftIndex = new int[i];
        int [] right = new int[j];
        int [] rightIndex = new int[j];
        for (int k = 0; k < i; k++) {
            left[k] = a[l + k];
            leftIndex[k] = indexes[l+k];
        }
        for (int k = 0; k < j; k++) {
            right[k] = a[mid+1+k];
            rightIndex[k] = indexes[mid+1+k];
        }

        int c = 0, d =0, k=l;
        while (c<i && d<j){
            if(left[c] > right[d]){
                a[k] = left[c];
                indexes[k] = leftIndex[c];
                c++;
            }else {
                a[k] = right[d];
                indexes[k] = rightIndex[d];
                d++;
            }
            k ++;
        }

        while (c < i){
            a[k] = left[c];
            indexes[k] = leftIndex[c];
            k++;
            c++;
        }

        while (d<j){
            a[k] = right[d];
            indexes[k] = rightIndex[d];
            k++;
            d++;
        }

    }

    public void test(){
        int[] a = {1, 32, 523, 745, 2, 0, 134, 46, 35, 66, 35};
        int[] indexes = new int[a.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
//        mergeSort(a, 0, a.length-1, indexes);
        Utils.printArray(a);
        String[] b = findRelativeRanks(a);
        Utils.printArray(b);
    }
}
