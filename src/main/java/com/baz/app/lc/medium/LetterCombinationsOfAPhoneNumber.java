package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber implements Facebook {

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     * Example:
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     *
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     */

    //BFS
    public List<String> letterCombinationsBFS(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits == null || "".equals(digits)) return ans;
        String[]cs = {"0","1","abc","def","ghi","jkl","mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()){
            String remove = ans.remove();
            String map = cs[digits.charAt(remove.length()) - '0'];
            for(char c : map.toCharArray()){
                ans.add(remove + c);
            }
        }

        return ans;
    }

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
        letterCombinationsBFS(s).forEach(i -> System.out.print(i + " "));
    }

}
