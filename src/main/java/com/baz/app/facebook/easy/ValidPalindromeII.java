package com.baz.app.facebook.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidPalindromeII {
    //brute force
    public boolean validPalindrome(String s){
        for (int i = 0; i < s.length(); i++) {
            if(check(s, i)) return true;
        }
        return false;
    }

    //beats 100%
    public boolean validPalindromeRecursive(String s){
        return helper(s, 0, s.length() -1 , false);
    }

    private boolean helper(String s, int left, int right, boolean flag){
        if(left >= right) return true;
        if(s.charAt(left) == s.charAt(right)){
            return helper(s, left+1, right-1, flag);
        }
        if(flag) return false;
        return helper(s, left + 1, right, true) || helper(s, left, right-1, true);
    }

    //improvement
    public boolean validPalindrome2(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)) break;
            i ++;
            j --;
        }

        return check(s, i) || check(s, j);
    }

    private boolean check(String s, int i){
        int end = s.length() - 1;
        int start = 0;
        while (start < end){
            if(start == i){
                start ++;
            }
            if(i == end){
                end --;
            }
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public void test(){
        String s = "aba";
        System.out.println(validPalindromeRecursive(s));
        s = "abca";
        System.out.println(validPalindromeRecursive(s));
        s = "tebbem";
        System.out.println(validPalindromeRecursive(s));
    }
}
