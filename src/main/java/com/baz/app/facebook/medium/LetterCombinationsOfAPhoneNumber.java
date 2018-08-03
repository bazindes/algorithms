package com.baz.app.facebook.medium;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {


    //iterative
    public List<String> letterCombinations(String digits) {
        String[]cs = {"","","abc","def","ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            String chars = cs[digits.charAt(i) - '0'];
            for (int j = 0; j < chars.length(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    temp.add(list.get(k) + chars.charAt(j));
                }
            }
            list = temp;
        }
        return list;
    }

    //recursive
    public List<String> letterCombinationsRecursive(String digits) {
        String[]cs = {"","","abc","def","ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        recursiveHelper("", digits, 0, list,cs);
        return list;
    }

    private void recursiveHelper(String prefix, String digits, int offset, List<String> ans, String[] cs){
        if(offset >= digits.length()){
            ans.add(prefix);
            return;
        }
        String str = cs[digits.charAt(offset) - '0'];
        for (int i = 0; i < str.length(); i++) {
            recursiveHelper(prefix+str.charAt(i), digits, offset + 1, ans, cs);
        }
    }

    public void test(){
        String s = "23";
        letterCombinations(s).forEach(i -> System.out.print(i + " "));
        System.out.println();
        letterCombinationsRecursive(s).forEach(i -> System.out.print(i + " "));
    }

}
