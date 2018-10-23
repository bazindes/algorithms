package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class ImplementStrStr implements Facebook {

    public int strStr(String haystack, String needle) {
        if(needle == null || "".equals(needle)) return 0;
        if(needle.length() > haystack.length()) return -1;
        if(haystack.equals(needle)) return 0;
        out : for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            in : for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) continue out;
            }
            return i;
        }
        return -1;
    }


    public void test(){
        String haystack = "hello", needle = "ll";
//        System.out.println(strStr(haystack, needle));
//        haystack = "aaaaa";
//        needle = "bba";
//        System.out.println(strStr(haystack, needle));
        haystack = "mississippi";
        needle = "issip";
        System.out.println(strStr(haystack, needle));
    }
}
