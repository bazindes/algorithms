package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

import java.util.Stack;

public class ValidParentheses implements Facebook {

    public boolean isValid(String s){
        boolean flag = false;
        if(s == null || "".equals(s.trim())) return !flag;
        if(s.length() % 2 != 0) return flag;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty())
                stack.push(helper(s.charAt(i)));
            else if(stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(helper(s.charAt(i)));
        }
        return stack.size() == 0;
    }

    private char helper(Character s){
        switch (s){
            case '[': s = ']'; break;
            case '{': s = '}'; break;
            case '(': s = ')'; break;
        }
        return s;
    }


    public void test(){
        String s = "()";
        System.out.println(isValid(s));
        s = "()[]{}";
        System.out.println(isValid(s));
        s = "(]";
        System.out.println(isValid(s));
        s = "([)]";
        System.out.println(isValid(s));
        s = "{[]}";
        System.out.println(isValid(s));
    }

}
