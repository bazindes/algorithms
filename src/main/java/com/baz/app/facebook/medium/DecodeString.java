package com.baz.app.facebook.medium;

import java.util.Stack;

public class DecodeString {

    /**
     *
     Given an encoded string, return it's decoded string.

     The encoding rule is: k[encoded_string],
     where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

     You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

     Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
     For example, there won't be input like 3a or 2[4].

     Examples:

     s = "3[a]2[bc]", return "aaabcbc".
     s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */

    // DFS O(n) O(n)
    int pos = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";

        for (int i = pos; i < s.length(); i++) {

            if(s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i))){
                num += s.charAt(i);
            }else if(s.charAt(i) == '['){
                pos = i + 1;
                String next = decodeString(s);
                for (int parseInt = Integer.valueOf(num); parseInt > 0; parseInt--) {
                    sb.append(next);
                }
                num = "";
                i = pos;
            }else if(s.charAt(i) == ']'){
                pos = i;
                return sb.toString();
            }
        }

        return sb.toString();
    }

    // O(n) O(n)
    public String decodeStringStack(String s) {
        String ans = "";
        if(s == null || s.length() == 0) return ans;
        Stack<Integer> countStack = new Stack<>();
        Stack<String> ansStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int cur = 0;
                while (Character.isDigit(s.charAt(idx))){
                    cur = cur * 10 + (s.charAt(idx) - '0');
                    idx ++;
                }
                countStack.push(cur);
            }else if(s.charAt(idx) == '['){
                ansStack.push(ans);
                ans = "";
                idx ++;
            }else if(s.charAt(idx) == ']'){
                StringBuilder sb = new StringBuilder(ansStack.pop());
                int repeat = countStack.pop();
                while (repeat-- > 0) {
                    sb.append(ans);
                }
                ans = sb.toString();
                idx ++;
            }else {
                ans += s.charAt(idx);
                idx ++;
            }
        }

        return ans;
    }

    public void test(){
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

}
