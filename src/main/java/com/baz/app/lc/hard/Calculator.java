package com.baz.app.lc.hard;

import com.baz.app.Interface.google.Google;

import java.util.Stack;

public class Calculator implements Google {

    /**
     * 2.基本计算器，输入一个字符串有加减乘除和正整数，
     * 没有括号那些优先符，返回一个整数代表计算结果。
     * 例如： input 3 + 4 * 5 - 6 / 2  output : 20   原题 用stack就行了
     */
    //O(n) O(n)
    public int calculate(String s){
        int ans = 0;
        if(s == null || "".equals(s.trim())) return ans;

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = '+';
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num = num * 10 + (cur - '0');
            }
            if(!Character.isDigit(cur) && ' ' != cur || i == len - 1){
                if(sign == '-')
                    stack.push(-num);
                if(sign == '+')
                    stack.push(num);
                if(sign == '*')
                    stack.push(stack.pop() * num);
                if(sign == '/')
                    stack.push(stack.pop() / num);
                sign = cur;
                num = 0;
            }
        }

        while (!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }

    //O(N) O(1)
    public int cal(String s) {
        int ans = 0;
        if(s == null || "".equals(s.trim())) return ans;
        s = s.trim().replaceAll(" +", "");
        int len = s.length();

        long prev = 0;
        char sign = '+';
        int i = 0;
        while (i < len){
            long curVal = 0;
            while (i < len && Character.isDigit(s.charAt(i))){
                curVal = curVal * 10 + (s.charAt(i) - '0');
                i ++;
            }

            if(sign == '+'){
                ans += prev;
                prev = curVal;
            }else if(sign == '-'){
                ans += prev;
                prev = -curVal;
            }else if(sign == '*'){
                prev = prev * curVal;
            }else if(sign == '/'){
                prev = prev / curVal;
            }

            if(i < len){
                sign = s.charAt(i);
                i ++;
            }
        }

        ans += prev;

        return ans;
    }


    public void test(){
        String s = "3+ 4 * 5 - 6 / 2 -3 / 1";
        System.out.println(calculate(s));
        System.out.println(cal(s));
    }

}
