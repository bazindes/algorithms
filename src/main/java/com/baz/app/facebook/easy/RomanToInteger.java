package com.baz.app.facebook.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt2(String s){
        int[] vs = new int[s.length()];
        for (int i = 0; i < vs.length; i++) {
            switch (s.charAt(i)){
                case 'I' : vs[i] = 1; break;
                case 'V' : vs[i] = 5; break;
                case 'X' : vs[i] = 10; break;
                case 'L' : vs[i] = 50; break;
                case 'C' : vs[i] = 100; break;
                case 'D' : vs[i] = 500; break;
                case 'M' : vs[i] = 1000; break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(vs[i] < vs[i+1])
                ans -= vs[i];
            else
                ans += vs[i];
        }
        return ans + vs[vs.length-1];
    }

    public int romanToInt(String s){
        if(s == null || "".equals(s)) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += map.get(s.charAt(i));
            if(i < s.length() - 1){
                if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                    ans -= 2*map.get(s.charAt(i));
            }
        }
        return ans;
    }

    public void test(){
        String s = "III";
        System.out.println(romanToInt2(s));
        s = "IV";
        System.out.println(romanToInt2(s));
        s = "IX";
        System.out.println(romanToInt2(s));
        s = "LVIII";
        System.out.println(romanToInt2(s));
        s = "MCMXCIV";
        System.out.println(romanToInt2(s));
    }

}
