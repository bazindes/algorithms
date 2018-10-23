package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class ReverseStringII implements Google {

    public String reverseStr(String s, int k){
        StringBuilder sb = new StringBuilder();

        if( s.length() <= k){
            for (int i = s.length() - 1; i > -1; i--) {
                sb.append(s.charAt(i));
            }
        }else {
            int c = 1;
            for (int i = 0; i < s.length(); i+=k) {
                int end = i+k;
                if(end > s.length()) end = s.length();
                if(c % 2 == 0){
                    for (int j = i; j < end; j++) {
                        sb.append(s.charAt(j));
                    }
                }else {
                    for (int j = end-1; j > i-1; j--) {
                        sb.append(s.charAt(j));
                    }
                }
                c ++;
            }
        }

        return sb.toString();
    }

    public void test(){
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s , k));
        System.out.println(reverseStr("ABCD" , 4));
    }

}
