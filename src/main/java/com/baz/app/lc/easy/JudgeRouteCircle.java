package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;

public class JudgeRouteCircle implements Google {
    public boolean judgeCircle(String moves){
        if(moves == null || "".equals(moves)) return true;
        char[] chars = moves.toCharArray();
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        for (char c : chars){
            switch (c){
                case 'U' : u++;break;
                case 'D' : d++;break;
                case 'L' : l++;break;
                case 'R' : r++;break;
            }
        }
        return u == d && l == r;
    }
}
