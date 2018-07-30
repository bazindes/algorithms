package com.baz.app.google.easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if(s == null || "".equals(s)) return s;
        int i = 0;
        int j = s.length() - 1;
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        while (i < j){
            if(!set.contains(cs[i])) {
                i ++;
            }
            else if(!set.contains(cs[j])){
                j --;
            }
            else if(set.contains(cs[i]) && set.contains(cs[j])){
                char c = cs[j];
                cs[j] = cs[i];
                cs[i] = c;
                i ++;
                j --;
            }
        }
        return String.valueOf(cs);
    }

    public void test(){
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

}
