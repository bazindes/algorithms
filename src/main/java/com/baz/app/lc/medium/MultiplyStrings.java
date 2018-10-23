package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class MultiplyStrings implements Facebook {

    /**
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
     * Example 1:
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     * Example 2:
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     * Note:
     * The length of both num1 and num2 is < 110.
     * Both num1 and num2 contain only digits 0-9.
     * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */

    //O(nm) n,m are the length of two inputs
    public String multiply(String num1, String num2){
        int n = num1.length();
        int m = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                mul += pos[p2];
                pos[p1] += mul /10;
                pos[p2] = mul % 10;
            }
        }

        for(int i=0; i<pos.length; i++){
            if(! (pos[i] == 0 && sb.length() == 0)){
                sb.append(pos[i]);
            }
        }

        return sb.length() == 0 ? "0":sb.toString();
    }

    public String multiply2(String num1, String num2){
        int n = num1.length();
        int m = num2.length();
        int[] ans = new int[m + n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int pos = i + j + 1;
                ans[pos] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        int carry = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            int cur = ans[i] + carry;
            ans[i] = cur % 10;
            carry = cur / 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if(!( ans[i] == 0 && sb.length() == 0))
                sb.append(ans[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public void test(){
        System.out.println(multiply("123", "45"));
        System.out.println(multiply2("123", "45"));
    }

}
