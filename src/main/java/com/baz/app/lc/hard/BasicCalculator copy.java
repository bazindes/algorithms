package com.baz.app.lc.hard;

import java.util.Stack;

public class BasicCalculator {

    public int cal(String s){
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
            }else if('+' == c){
                ans += num * sign;
                num = 0;
                sign = 1;
            }else if('-' == c){
                ans += num * sign;
                num = 0;
                sign = -1;
            }else if('(' == c){
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            }else if(')' == c){
                ans += sign * num;
                num = 0;
                ans *= stack.pop();
                ans += stack.pop();
            }
        }
        if(num != 0)
            ans += sign * num;
        return ans;
    }

    public void test(){
        String s = "  30";
        System.out.println(cal(s));
        s = " 2-1 + 2 ";
        System.out.println(cal(s));
        s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(cal(s));
        s = "2147483647";
        System.out.println(cal(s));
    }

}
