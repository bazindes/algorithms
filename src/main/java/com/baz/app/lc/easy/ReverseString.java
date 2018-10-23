package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class ReverseString implements Facebook {

    /**
     * Write a function that takes a string as input and returns the string reversed.
     *
     * Example 1:
     *
     * Input: "hello"
     * Output: "olleh"
     * Example 2:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: "amanaP :lanac a ,nalp a ,nam A"
     */

    public String reverse(String s){
        if(s == null || "".equals(s)) return "";
        int len = s.length();
        if(len <= 1) return s;
        String left = s.substring(0 , len/2);
        String right = s.substring(len/2 , len);
        return reverse(right) + reverse(left);
    }

    public String reverseTP(String s){
        if(s == null || "".equals(s)) return "";
        int i = 0;
        int j = s.length() - 1;
        char[]cs = s.toCharArray();
        while (i < j){
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
            i ++;
            j --;
        }

        return new String(cs);
    }

    public void test(){
        String s = "hello";
        System.out.println(reverseTP(s));
    }

}
