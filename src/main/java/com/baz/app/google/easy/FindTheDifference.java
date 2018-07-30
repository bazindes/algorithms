package com.baz.app.google.easy;

import java.util.HashSet;
import java.util.Set;

public class FindTheDifference {

    public char findTheDifference(String s, String t){
        char re = '0';
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if(!set.contains(t.charAt(i)))
                re = t.charAt(i);
        }
        return re;
    }

}
