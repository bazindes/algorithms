package com.baz.app.facebook.easy;

public class FirstBadVersion {
    int bad = 0;
    boolean isBadVersion(int version){
        return version == bad;
    }

    public int firstBadVersion(int n){

        return bs(n,1,n);
    }

    private int bs(int n, int start, int end){
        if(start == end) return start;
        int mid = start + (end - start) / 2;
        if(start < end){
            if(isBadVersion(mid))
                return bs(n, start, mid);
            else
                return bs(n, mid+1, end);
        }
        return mid;
    }

    public void test(){
        bad = 4;
        System.out.println(firstBadVersion(5));
    }

}
