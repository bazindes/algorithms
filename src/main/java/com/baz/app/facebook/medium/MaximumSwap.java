package com.baz.app.facebook.medium;

public class MaximumSwap {

    public int maximumSwap(int num) {
        return Integer.parseInt(helper(num +""));
    }

    private String helper(String num){
        if(num == null || "".equals(num)) return "";
        char[] ans = (num + "").toCharArray();
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < ans.length; j++) {
            if(ans[j] > ans[0]){
                max = Math.max(max, ans[j]);
                i = max > ans[j] ? i : j;
            }
        }
        if(i == 0){
            return ans[0] + helper(new String(ans, 1, ans.length-1));
        }
        char cur = ans[0];
        ans[0] = ans[i];
        ans[i] = cur;
        return new String(ans);
    }

    public void test(){
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
    }

}
