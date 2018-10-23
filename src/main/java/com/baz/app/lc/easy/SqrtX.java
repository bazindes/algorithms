package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

public class SqrtX implements Facebook {

    public int mySqrt(int x){
        int i = 0;
        while (i < x/2){
            if(i * i > x){
                return --i;
            }
            i ++;
        }
        return i;
    }

    public int sqrtBinarySearch(int x){
        if(x == 0) return 0;
        int start = 1;
        int end = x;
        while (start < end){
            int mid = start + (end - start)/2;
            if(mid<=(x/mid) && (mid+1) > x/(mid+1)) {
                return mid;
            }else if(mid > x/mid){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    public void test(){
        int x = 4;
        System.out.println(sqrtBinarySearch(x));
        x = 8;
        System.out.println(sqrtBinarySearch(x));
    }

}
