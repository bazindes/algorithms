package com.baz.app.facebook.medium;

public class DecodeString {

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


    public void test(){
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

}
