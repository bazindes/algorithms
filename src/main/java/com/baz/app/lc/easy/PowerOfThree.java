package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class PowerOfThree implements Google {
    public boolean isPowerOfThree(int n) {
        while (n > 1){
            if(n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}
