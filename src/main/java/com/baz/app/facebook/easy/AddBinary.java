package com.baz.app.facebook.easy;

public class AddBinary {

    public String addBinary(String a, String b){
        char[] lon = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
        char[] sho = a.length() <= b.length() ? a.toCharArray() : b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int l = lon.length - 1;
        int s = sho.length - 1;
        int mark = 0;
        for (int i = l; i >= 0; i--) {
            int cur = Integer.valueOf(lon[i] + "") + mark ;
            if(s >= 0){
                cur += Integer.valueOf(sho[s--] + "");
            }
            if(cur > 1){
                mark = 1;
                sb.append(cur % 2);
            }else {
                mark = 0;
                sb.append(cur);
            }
        }
        if(mark == 1) sb.append("1");
        return sb.reverse().toString();
    }

    public void test(){
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
        a = "1010";
        b = "1011";
        System.out.println(addBinary(a, b));
        a = "1111";
        b = "1111";
        System.out.println(addBinary(a, b));
    }

}
