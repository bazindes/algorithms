package com.baz.app.facebook.medium;

public class DecodeWays {

    //DP solution
    public int numDecodings(String s) {
        int num = s.length();
        if(num == 0) return 0;

        int[] m = new int[num + 1];
        m[num] = 1;
        m[num - 1] = s.charAt(num - 1) != '0' ? 1:0;

        for (int i = num - 2; i > -1; i--) {
            if(s.charAt(i) == '0') continue;
            else
                m[i] = Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1)) <= 26 ? m[i+1] + m[i+2] : m[i+1];
        }

        return m[0];
    }

    public int numDecodingDP(String s){
        if(s == null || "".equals(s)) return 0;

        int len = s.length();
        int[]cs = new int[len + 1];
        cs[0] = 1;
        cs[1] = s.charAt(0) == '0'? 0:1;

        for (int i = 2; i <= len; i++) {
            int fst = Integer.parseInt(s.substring(i-1, i));
            int sec = Integer.parseInt(s.substring(i-2, i));
            if(fst <= 9 && fst >= 1){
                cs[i] += cs[i - 1];
            }
            if(sec <= 26 && sec >= 10){
                cs[i] += cs[i - 2];
            }
        }

        return cs[len];
    }

    public void test(){
        String s = "12";
        System.out.println(numDecodings(s));
        System.out.println(numDecodingDP(s));
        s= "226";
        System.out.println(numDecodings(s));
        System.out.println(numDecodingDP(s));
    }
}
