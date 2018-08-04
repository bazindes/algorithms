package com.baz.app.facebook.easy;

public class ExcelSheetColumnTitle {

    // O(n)
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0){
            n --;
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    // O(n)
    public String convertToTitle2(int n){
        String res = "";
        while (n != 0){
            char c = (char)((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = c + res;
        }
        return res;
    }

    public void test(){
        System.out.println(convertToTitle2(3));
        System.out.println(convertToTitle2(28));
        System.out.println(convertToTitle2(701));
        System.out.println(convertToTitle2(702));
    }

}
