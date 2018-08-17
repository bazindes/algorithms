package com.baz.app.facebook.medium;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    //O(n) O(n)
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }

        for (int i = 0; i < S.length(); i++) {
            Integer t =  map.get(S.charAt(i));
            if(t == null) continue;
            while (t-- > 0){
                sb.append(S.charAt(i));
            }
            map.remove(S.charAt(i));
        }

        for(char c : map.keySet()){
            int t =  map.get(c);
            while (t-- > 0){
                sb.append(c);
            }
        }

        return sb.toString();
    }


    //O(n) O(1)
    public String customSortStringCounting(String S, String T) {
        int[] cs = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            cs[T.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < S.length(); i++) {
            while (cs[S.charAt(i) - 'a'] -- > 0){
                sb.append(S.charAt(i));
            }
        }
        for (char c = 'a'; c <= 'z'; c++){
            while (cs[c - 'a'] -- > 0){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void test(){
        String s = "disqyr";
        String t = "iwyrysqrdj";

        System.out.println(customSortString(s, t));
        System.out.println(customSortStringCounting(s, t));
    }

}
