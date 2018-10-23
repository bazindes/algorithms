package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Facebook {

    /**
     *Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * For example, given n = 3, a solution set is:
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */

    //O(4^N / SQRT(N) )
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helperBackTracking(ans, "", 0, 0, n);
        return ans;
    }

    private void helperBackTracking(List<String> ans, String cur, int open, int close, int max){
        if(cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if(open < max)
            helperBackTracking(ans, cur + "(" , open + 1, close, max);
        if(open > close)
            helperBackTracking(ans, cur + ")", open, close + 1, max);

    }

    //approach 2
    public List<String> generateP(int n){
        List<String> ans = new ArrayList<>();
        if( n == 0){
            ans.add("");
        }else {
            for (int i = 0; i < n; i++) {
                for (String s : generateP(i)){
                    for (String cur : generateP(n - 1 - i )){
                        ans.add("(" + s + ")" + cur);
                    }
                }
            }
        }

        return ans;
    }

    public void test(){
        generateParenthesis(3).forEach( i -> System.out.print( i + " "));
        System.out.println();
        generateP(3).forEach(i -> System.out.print(i + " "));
    }

}
