package com.baz.app.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthese {

    /**
     * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
     * Note: The input string may contain letters other than the parentheses ( and ).
     *
     * Example 1:
     * Input: "()())()"
     * Output: ["()()()", "(())()"]
     * Example 2:
     * Input: "(a)())()"
     * Output: ["(a)()()", "(a())()"]
     * Example 3:
     * Input: ")("
     * Output: [""]
     */

    //O( 2 ^ (l + r) )  O(n^2)
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                l ++;
            if(l == 0){
                if(s.charAt(i) == ')') r ++;
            }else {
                if(s.charAt(i) == ')') l --;
            }
        }

        helper(s, list, l, r, 0);
        return list;
    }

    private void helper(String s, List<String> list, int l, int r, int start){
        if( l == 0 && r == 0 ){
            if(check(s)) list.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if( i != start && s.charAt(i) == s.charAt(i-1))
                continue;
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length(); j++) {
                    if(j == i) continue;
                    sb.append(s.charAt(j));
                }
                if(l > 0)
                    helper(sb.toString(), list, l - 1, r, i);
                else if(r > 0)
                    helper(sb.toString(), list, l, r - 1, i);
            }
        }
    }

    private boolean check(String s){
        int count = 0;
        for (int k = 0; k < s.length(); k++) {
            if(s.charAt(k) == '(') count ++;
            if(s.charAt(k) == ')') count --;
            if(count < 0) return false;
        }
        return count == 0;
    }

    public void test(){
        String s = "()())()";
        removeInvalidParentheses(s).forEach( s1 -> System.out.print(s1 + " "));
        System.out.println();
        s = "(a)())()";
        removeInvalidParentheses(s).forEach( s1 -> System.out.print(s1 + " "));
        System.out.println();
        s = ")(";
        removeInvalidParentheses(s).forEach( s1 -> System.out.print(s1 + " "));
        System.out.println();
    }

}
