package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger implements Facebook {

    /**
     *Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     *
     * Input: "III"
     * Output: 3
     * Example 2:
     *
     * Input: "IV"
     * Output: 4
     * Example 3:
     *
     * Input: "IX"
     * Output: 9
     * Example 4:
     *
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     *
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

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
