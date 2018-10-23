package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

public class ExcelSheetColumnTitle implements Facebook {

    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.
     *
     * For example:
     *
     *     A -> 1
     *     B -> 2
     *     C -> 3
     *     ...
     *     Z -> 26
     *     AA -> 27
     *     AB -> 28
     *     ...
     * Example 1:
     *
     * Input: "A"
     * Output: 1
     * Example 2:
     *
     * Input: "AB"
     * Output: 28
     * Example 3:
     *
     * Input: "ZY"
     * Output: 701
     */

    // O(n)
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0){
            n --;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    // O(n)
    public String convertToTitle2(int n){
        String res = "";
        while (n != 0){
            char c = (char)((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = c + res;
        }
        return res;
    }

    public void test(){
        System.out.println(convertToTitle2(3));
        System.out.println(convertToTitle2(28));
        System.out.println(convertToTitle2(701));
        System.out.println(convertToTitle2(702));
    }

}
