package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class LongestUncommonSubsequence implements Google {

    public int findLUSlength(String a, String b){
        if (a.equals(b)) return -1;
        return Math.max(a.length() , b.length());
    }

}
