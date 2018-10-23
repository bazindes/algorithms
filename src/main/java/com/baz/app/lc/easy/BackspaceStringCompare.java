package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

import java.util.Stack;

public class BackspaceStringCompare implements Google {
    public boolean backSpaceCompare(String S, String T){

        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '#') {
                if (!s.isEmpty())
                    s.pop();
            }else
                s.push(S.charAt(i));
        }
        for (int i = 0; i < T.length(); i++) {
            if(T.charAt(i) == '#') {
                if (!t.isEmpty())
                    t.pop();
            }else
                t.push(T.charAt(i));
        }

        if(s.size() != t.size()) return false;
        while(!s.isEmpty()) {
            if(s.pop() != t.pop()) return false;
        }

        return true;
    }

    public void test(){
        String S = "ab#c", T = "ad#c" ;
        System.out.println(backSpaceCompare(S, T));
        S = "ab##";
        T = "c#d#";
        System.out.println(backSpaceCompare(S, T));
        S = "a##c";
        T = "#a#c";
        System.out.println(backSpaceCompare(S, T));
        S = "a#c";
        T = "b";
        System.out.println(backSpaceCompare(S, T));
        S = "xywrrmp";
        T = "xywrrmu#p";
        System.out.println(backSpaceCompare(S, T));
    }
}
