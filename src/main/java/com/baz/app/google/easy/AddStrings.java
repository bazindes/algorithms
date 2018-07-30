package com.baz.app.google.easy;

public class AddStrings {

    public String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        String len = num1.length() > num2.length() ? num1 : num2;
        String sho = num1.length() <= num2.length() ? num1 : num2;
        int diff = len.length() - sho.length();
        int isD = 0;
        for (int i = len.length() - 1; i > -1; i--) {
            int n = Integer.parseInt(len.charAt(i) +"")  + isD;
            if(i - diff >= 0) n += Integer.parseInt(sho.charAt(i-diff) + "");
            if(n < 10){
                isD = 0;
                sb.append(n);
            }else {
                isD = 1;
                sb.append(n % 10);
            }
        }
        if(isD == 1) sb.append(1);
        return sb.reverse().toString();
    }


    public void test(){
        String s1 = "1";
        String s2 = "9";

        System.out.println(addStrings(s1 , s2));
    }

}
