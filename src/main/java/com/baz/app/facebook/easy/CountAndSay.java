package com.baz.app.facebook.easy;

public class CountAndSay {

    public String countAndSay(int n){
        if(n == 1) return "1";
        return count(countAndSay(n-1));
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

    public String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String res = "1";
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.delete( 0, sb.length() );
            int k = 0;
            for(int j = 0; j < res.length(); j++) {

                if(res.charAt(j) != res.charAt(k)){
                    sb.append(j - k);
                    sb.append(res.charAt(k));
                    k = j;
                }
                if (j == res.length() - 1) {
                    sb.append(j-k+1);
                    sb.append(res.charAt(j));
                }
            }
            res = sb.toString();

        }
        return sb.toString();
    }

    public void test(){
//        System.out.println(count("1211"));
        System.out.println(countAndSay2(100));
//        System.out.println(coungAndSay(4000));
    }

}
