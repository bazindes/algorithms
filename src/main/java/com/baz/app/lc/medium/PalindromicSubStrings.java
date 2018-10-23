package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class PalindromicSubStrings implements Facebook {

    //O(n^2)
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;

        for (int i = 0; i < 2 * len - 1; i++) {
            int l = i / 2;
            int r = l + i % 2;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                ans ++;
                l --;
                r ++;
            }
        }

        return ans;
    }

    //O(n^2)
    public int countSubstringsDP(String s){
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }

    public void test(){
        String s = "abc";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstringsDP(s));
        s = "aaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstringsDP(s));
    }

}
