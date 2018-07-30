package com.baz.app.google.easy;

import java.util.HashSet;
import java.util.Set;

public class PalindromPermutation {
    public boolean canPermutePalindrome(String s){
        if(s == null || "".equals(s)) return false;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if(set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size()<1;
    }
}
