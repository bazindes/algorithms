package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.Arrays;

public class H_Index implements Facebook {

    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0) return 0;
        int[]buckets = new int[len + 1];

        for (int i = 0; i < len; i++) {
            if(citations[i] > len){
                buckets[len] += 1;
            }else {
                buckets[citations[i]] += 1;
            }
        }

        int sum = 0;
        for (int i = len; i >=0; i--) {
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }

    public int hIndexSort(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        for(int i=0;i<len;i++){
            if(citations[i]>=len-i) return len-i;

        }
        return 0;
    }

    public void test(){
        int[] s = {3,0,6,1,5};
        System.out.println(hIndex(s));
        System.out.println(hIndexSort(s));
    }

}
