package com.baz.app.facebook.hard;

import java.util.Stack;

public class BasicCalculator {

    /**
     * Implement a basic calculator to evaluate a simple expression string.
     * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
     * Example 1:
     * Input: "1 + 1"
     * Output: 2
     * Example 2:
     * Input: " 2-1 + 2 "
     * Output: 3
     * Example 3:
     * Input: "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     * Note:
     * You may assume that the given expression is always valid.
     * Do not use the eval built-in library function.
     */

    public int calculate(String s) {
        //corner case
        if(s == null || "".equals(s)) return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int cur = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                cur = cur * 10 + (int)(c - '0');
            }else if(c == '+'){
                ans += sign * cur;
                cur = 0;
                sign = 1;
            }else if(c == '-'){
                ans += sign * cur;
                cur = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }else if(c == ')'){
                ans += sign * cur;
                cur = 0;
                ans *= stack.pop();
                ans += stack.pop();
            }
        }

        if(cur != 0)
            ans += sign * cur;

        return ans;
    }

    public void test(){
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
