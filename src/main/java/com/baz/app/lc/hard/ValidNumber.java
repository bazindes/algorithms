package com.baz.app.lc.hard;

import com.baz.app.Interface.facebook.Facebook;

public class ValidNumber implements Facebook {

    /**
     * Validate if a given string is numeric.
     *
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     *
     * Note: It is intended for the problem statement to be ambiguous.
     * You should gather all requirements up front before implementing one.
     *
     * Update (2015-02-10):
     * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument,
     * please click the reload button to reset your code definition.
     */

    public boolean isNumber(String s) {
        if(s == null || "".equals(s)) return false;
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterESeen = true;

        for (int i = 0; i < s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                numberSeen = true;
                numberAfterESeen = true;
            }else if(s.charAt(i) == '.'){
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            }else if('e' == s.charAt(i)){
                if(eSeen || !numberSeen)
                    return false;
                numberAfterESeen = false;
                eSeen = true;
            }else if('-' == s.charAt(i) || '+' == s.charAt(i)){
                if(i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            }else {
                return false;
            }
        }
        return numberSeen && numberAfterESeen;
    }

    public void test(){
        String s = "e9";
        System.out.println(isNumber(s));
        s = " 0.1 ";
        System.out.println(isNumber(s));
        s = "abc";
        System.out.println(isNumber(s));
        s = "1 a";
        System.out.println(isNumber(s));
        s = "2e10";
        System.out.println(isNumber(s));
    }

}
