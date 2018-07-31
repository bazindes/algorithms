package com.baz.app.google.easy;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s){
        int len = s.length();
        if(len < 2) return false;
        for (int i = 2; i <= len; i++) {
            if(len % i != 0) continue;
            if(check(s, i)) return true;
        }
        return false;
    }

    private boolean check(String s, int repeat){
        int len = s.length();
        String card = s.substring(0, len/repeat);
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) != card.charAt( i % (len/repeat)))
                return false;
        }
        return true;
    }

    public void test(){
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("aaaa"));
    }

}
