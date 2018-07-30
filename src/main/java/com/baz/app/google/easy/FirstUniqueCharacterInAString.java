package com.baz.app.google.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s){
        int num = Integer.MAX_VALUE;
        if(s == null || "".equals(s)) return -1;
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                int val = map.get(s.charAt(i));
                map.put(s.charAt(i) ,  val = val + s.length());
            }else
                map.put(s.charAt(i) , i);
        }
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if(val < s.length()){
                num = Math.min(num , val);
            }
        }
        return num;
    }

    public void test(){
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));
    }

}
