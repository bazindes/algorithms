package com.baz.app.google.easy;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if(A == null || B ==null) return false;
        if(A.length() != B.length()) return false;
        Set<Character> set = new HashSet<>();
        if(A.equals(B)){
            for (int i = 0; i < A.length(); i++) {
                set.add(A.charAt(i));
            }
            if (set.size() < A.length()) return true;
        }
        set.clear();
        int num = 0;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)){
                num ++;
                set.add(A.charAt(i));
                set.add(B.charAt(i));
            }
        }
        if(num > 2) return false;
        return set.size() == 2;
    }

    public void test(){
        String A = "ab", B = "ba";
        System.out.println(buddyStrings(A, B));
        A = "ab"; B = "ab";
        System.out.println(buddyStrings(A, B));
        A = "aa"; B = "aa";
        System.out.println(buddyStrings(A, B));
        A = "aaaaaaabc"; B = "aaaaaaacb";
        System.out.println(buddyStrings(A, B));
        A = ""; B = "aa";
        System.out.println(buddyStrings(A, B));
    }

}
