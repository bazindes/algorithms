package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion implements Facebook {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string s, int numRows);
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */

    public String convert(String s, int numRows) {
        if(s == null || "".equals(s) || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        convertHelper(list, 0, s, true, 0, numRows);
        for(List<Character> l : list){
            for (Character c : l)
                sb.append(c);
        }
        return sb.toString();
    }

    private void convertHelper(List<List<Character>> list, int row, String s, boolean dir, int len, int numRows){
        if(len == s.length() || row < 0 || row == numRows) return;
        List<Character> temp = list.get(row);
        temp.add(s.charAt(len));
        // true : down, false : up-right
        if(dir){
            if(row < numRows - 1)
                convertHelper(list, row + 1, s, true, len + 1, numRows);
            else
                convertHelper(list, row - 1, s, false, len + 1, numRows);
        }else{
            if(row == 0)
                convertHelper(list, row + 1, s, true, len + 1, numRows);
            else
                convertHelper(list, row - 1, s, false, len + 1, numRows);
        }
    }

    public void test(){
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }

}
