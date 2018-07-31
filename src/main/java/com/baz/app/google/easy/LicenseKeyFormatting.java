package com.baz.app.google.easy;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K){

        S = S.replaceAll("-" , "");
        int len = S.length();
        int first = len % K;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < first; i++) {
            sb.append(String.valueOf(S.charAt(i)).toUpperCase());
            if(sb.length() == first){
                index = i + 1;
                sb.append("-");
                break;
            }
        }
        int count = 0;
        for (int i = index; i < len; i++) {
            if(count == K){
                count = 0;
                sb.append("-");
            }
            sb.append(String.valueOf(S.charAt(i)).toUpperCase());
            count ++;
        }
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '-')
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void test(){
//        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w" , 4));
//        System.out.println(licenseKeyFormatting("2-5g-3-J" , 2));
        System.out.println(licenseKeyFormatting("---" , 3));
    }

}
