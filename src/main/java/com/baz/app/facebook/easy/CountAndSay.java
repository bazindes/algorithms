package com.baz.app.facebook.easy;

public class CountAndSay {

    public String coungAndSay(int n){
        if(n == 1) return "1";
        return count(coungAndSay(n-1));
    }

    private String count(String s){
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j) != s.charAt(k) ){
                sb.append(j-k);
                sb.append(s.charAt(k));
                k = j;
            }
            if(j == s.length() - 1){
                sb.append(j-k + 1);
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }



    public void test(){
//        System.out.println(count("1211"));
        System.out.println(coungAndSay(1));
        System.out.println(coungAndSay(4));
    }

}
