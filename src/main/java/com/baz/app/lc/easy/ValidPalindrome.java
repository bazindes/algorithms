package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

public class ValidPalindrome implements Facebook {
    //my approach O(n)
    public boolean isPalindrome(String s){
        if(s == null || "".equals(s)) return true;
        int i = 0;
        int j = s.length() - 1;
        char[]cs = s.toCharArray();
        while  (i <= j){
            if(!checkHelper(cs[i])){
                i++;
            }
            if(!checkHelper(cs[j])){
                j--;
            }
            if(checkHelper(cs[i]) && checkHelper(cs[j])){
                String tempI = ("" + cs[i]).toUpperCase();
                String tempJ = ("" + cs[j]).toUpperCase();
;               if(tempI.equals( tempJ)){
                    i++;
                    j--;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    //improvement
    public boolean isPalindrome2(String s){
        if (s == null || "".equals(s.trim())) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            char l = s.charAt(i);
            char r = s.charAt(j);
            if(!checkHelper(l)){
                i ++;
                continue;
            }
            if(!checkHelper(r)){
                j --;
                continue;
            }
            if(checkHelper(l) && checkHelper(l)){
                if(l != r ){
                    if(l > 64 && l < 91){
                        if(l - 'A' != r - 'a') return false;
                    }else if(l > 96 && l < 123){
                        if(l - 'a' != r - 'A') return false;
                    }else{
                        return false;
                    }
                }
                i ++;
                j --;
            }
        }

        return true;
    }

    private boolean checkHelper(char c){
        return (c>47 && c<58) || (c>64 && c<91) || (c>96 && c<123);
    }

    public void test(){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome2(s));
        s = "race a car";
        System.out.println(isPalindrome2(s));
    }

}
