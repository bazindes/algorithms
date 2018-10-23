package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class HammingDistance implements Facebook {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0){
            xor &= xor - 1;
            count ++;
        }
        return count;
    }

    public void test(){
        System.out.println(hammingDistance(1, 4));
    }
}
