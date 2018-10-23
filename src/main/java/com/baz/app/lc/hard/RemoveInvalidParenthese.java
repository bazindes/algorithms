package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.*;

public class RemoveInvalidParenthese implements Facebook {

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

    //DFS O( 2 ^ (l + r) )  O(n^2)
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


    //BFS O(n * 2^(n-1))
    public List<String> removeInvalidParentesesBFS(String s){
        List<String> ans = new ArrayList<>();

        if(s == null || "".equals(s)) return ans;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        //initialize
        visited.add(s);
        queue.offer(s);

        boolean found = false;

        while (!queue.isEmpty()){
            String cur = queue.poll();
            if (check(cur)){
                //find an answer, put it into ans
                ans.add(cur);
                found = true;
            }

            if(found) continue;

            //generate all possible states
            for (int i = 0; i < cur.length(); i++) {
                //we only can remove parenthesis
                char c = cur.charAt(i);
                if(c != '(' && c != ')') continue;
                String temp = cur.substring(0, i) + cur.substring(i + 1);

                if(!visited.contains(temp)){
                    queue.offer(temp);
                    visited.add(temp);
                }

            }
        }

        return ans;
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
        System.out.println(removeInvalidParentesesBFS2(s));
        s = "(a)())()";
        removeInvalidParentheses(s).forEach( s1 -> System.out.print(s1 + " "));
        System.out.println();
        s = ")(";
        removeInvalidParentheses(s).forEach( s1 -> System.out.print(s1 + " "));
        System.out.println();
    }

    public String removeInvalidParentesesBFS2(String s){
        if(s == null || "".equals(s)) return s;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        //initialize
        visited.add(s);
        queue.offer(s);

        while (!queue.isEmpty()){
            String cur = queue.poll();
            if (check(cur)){
                //find an answer, put it into ans
                return cur;
            }

            //generate all possible states
            for (int i = 0; i < cur.length(); i++) {
                //we only can remove parenthesis
                char c = cur.charAt(i);
                if(c != '(' && c != ')') continue;
                String temp = cur.substring(0, i) + cur.substring(i + 1);
                if(!visited.contains(temp)){
                    queue.offer(temp);
                    visited.add(temp);
                }

            }
        }

        return s;
    }

}
