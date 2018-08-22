package com.baz.app.facebook.hard;

import com.baz.app.TwoSigma.easy.IntersectionOfTwoArrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public String minWindow(String s, String t) {
        Map<Character , Integer> toFind = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            toFind.put(t.charAt(i), toFind.getOrDefault(t.charAt(i) , 0) + 1);
        }

        int i = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            if(toFind.containsKey(cur)){
                toFind.put(cur, toFind.get(cur) - 1);
                if(toFind.get(cur) >= 0){
                    count ++;
                }
                while (count == t.length()){
                    if(j - i + 1 < ans){
                        ans = j - i + 1;
                        left = i;
                    }
                    char temp = s.charAt(i);
                    if(toFind.containsKey(temp)){
                        toFind.put(temp , toFind.get(temp) + 1);
                        if(toFind.get(temp) > 0){
                            count --;
                        }
                    }
                    i ++;
                }
            }
        }

        if (ans > s.length()){
            return "";
        }
        return s.substring(left, left + ans);
    }

    public void test(){
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(minWindow(S , T));
    }

}
