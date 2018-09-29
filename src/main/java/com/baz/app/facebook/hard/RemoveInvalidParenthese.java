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
        // l indicates how many left parenthesis we need to remove
        // r indicates how many right parenthesis we need to remove
        int l = 0;
        int r = 0;
        /**
         * go through target string, figure out l and r
         *      as long as current char is '('
         *          increase l by 1
         *      if first char is ')"
         *          increase r by 1
         *      otherwise we need to decrease l by 1
         */
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
        // exit condition, l,r equal to 0 means there are no more invalid parentheses
        // then we can check the current string and determine whether put it into result or not, and then return
        if( l == 0 && r == 0 ){
            if(check(s)) list.add(s);
            return;
        }

        // for every call, we go through current string
        for (int i = start; i < s.length(); i++) {
            // since continuous same parentheses will get same results, we can calculate first one and skip others
            if( i != start && s.charAt(i) == s.charAt(i-1))
                continue;
            // check current char is parenthesis, if it's not parenthesis, skip it
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                // use a StringBuilder to generate new string
                StringBuilder sb = new StringBuilder();
                // except current char, we copy the string to sb
                for (int j = 0; j < s.length(); j++) {
                    if(j == i) continue;
                    sb.append(s.charAt(j));
                }
                // recursively call
                if(l > 0)
                    helper(sb.toString(), list, l - 1, r, i);
                else if(r > 0)
                    helper(sb.toString(), list, l, r - 1, i);
            }
        }
    }

    private boolean check(String s){
        // count indicates invalid parentheses
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
