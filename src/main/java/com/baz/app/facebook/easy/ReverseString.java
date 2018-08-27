package com.baz.app.facebook.easy;

public class ReverseString {

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
