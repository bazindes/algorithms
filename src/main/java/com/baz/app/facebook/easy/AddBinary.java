package com.baz.app.facebook.easy;

public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     * The input strings are both non-empty and contains only characters 1 or 0.
     * Example 1:
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */

    //O(n) O(n)
    public String addBinary(String a, String b){
        char[] lon = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
        char[] sho = a.length() <= b.length() ? a.toCharArray() : b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int l = lon.length - 1;
        int s = sho.length - 1;
        int mark = 0;
        for (int i = l; i >= 0; i--) {
            int cur = Integer.valueOf(lon[i] + "") + mark ;
            if(s >= 0){
                cur += Integer.valueOf(sho[s--] + "");
            }
            if(cur > 1){
                mark = 1;
                sb.append(cur % 2);
            }else {
                mark = 0;
                sb.append(cur);
            }
        }
        if(mark == 1) sb.append("1");
        return sb.reverse().toString();
    }

    //O(n) O(1)
    public String addBinary2(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i --) - '0';
            if(j >= 0) sum += b.charAt(j --) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public void test(){
        String a = "11", b = "1";
        System.out.println(addBinary2(a, b));
        a = "1010";
        b = "1011";
        System.out.println(addBinary2(a, b));
        a = "1111";
        b = "1111";
        System.out.println(addBinary2(a, b));
    }

}
