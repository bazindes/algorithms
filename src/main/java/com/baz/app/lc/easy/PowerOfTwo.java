package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class PowerOfTwo implements Google {

    public boolean isPowerOfTwo(int n){
        while (n > 1){
            if(n % 2 != 0) return false;
            n /= 2;
        }
        return n == 1;
    }

    public void test(){
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(56));
        System.out.println(isPowerOfTwo(23));
    }

}
