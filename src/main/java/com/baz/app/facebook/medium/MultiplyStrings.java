package com.baz.app.facebook.medium;

public class MultiplyStrings {

    public String multiply(String num1, String num2){
        int n = num1.length();
        int m = num2.length();
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                mul += pos[p2];
                pos[p1] += mul /10;
                pos[p2] = mul % 10;
            }
        }

        for(int i=0; i<pos.length; i++){
            if(! (pos[i] == 0 && sb.length() == 0)){
                sb.append(pos[i]);
            }
        }

        return sb.length() == 0 ? "0":sb.toString();
    }


    public void test(){
        System.out.println(multiply("123", "45"));
    }

}
