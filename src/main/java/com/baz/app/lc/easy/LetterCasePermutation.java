package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation implements Facebook {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            permutationHelper(S, list, i);
        }
        return list;
    }

    private void permutationHelper(String s, List<String> list, int n){
        List<String> temp = new ArrayList<>();
        if(n == 0){
            temp.add(s.charAt(n) + "");
            if(s.charAt(n) > 96 && s.charAt(n) < 123)
                temp.add((s.charAt(n) + "").toUpperCase());
            if(s.charAt(n) > 64 && s.charAt(n) < 92)
                temp.add((s.charAt(n) + "").toLowerCase());
        }
        for (int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            temp.add(cur + s.charAt(n));
            if(s.charAt(n) > 96 && s.charAt(n) < 123)
                temp.add(cur + (s.charAt(n) + "").toUpperCase());
            if(s.charAt(n) > 64 && s.charAt(n) < 91)
                temp.add(cur + (s.charAt(n) + "").toLowerCase());
        }
        list.clear();
        list.addAll(temp);
    }

    public void test(){
        String s = "YPka";
        letterCasePermutation(s).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(letterCasePermutation(s).size());
//        s = "3z4";
//        letterCasePermutation(s).forEach(x -> System.out.print(x + " "));
//        System.out.println();
//        s = "12345";
//        letterCasePermutation(s).forEach(x -> System.out.print(x + " "));
//        System.out.println();
    }

}
