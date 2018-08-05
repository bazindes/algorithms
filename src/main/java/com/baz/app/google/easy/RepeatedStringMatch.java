package com.baz.app.google.easy;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        int num = 1;
        while (sb.indexOf(B) < 0){
            if(sb.length() - A.length() > B.length()) return -1;
            sb.append(A);
            num ++;
        }
        return num;
    }

    public void test(){
        String A = "abcd" , B = "cdabcdab";
        System.out.println(repeatedStringMatch(A, B));
    }

}
