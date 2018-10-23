package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

import java.util.HashSet;
import java.util.Set;

public class FindTheDifference implements Google {

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
