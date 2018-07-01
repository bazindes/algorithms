package com.baz.app.easy;
import com.baz.app.util.*;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-20
*/
class AddBinary{
    public String addbinary(String a, String b){
        if(a == null || a.isEmpty()) return b;
        if(b == null || b.isEmpty()) return a;
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = aArr.length - 1;
        int j = bArr.length - 1;
        int aByte, bByte;
        int carry = 0;
        int result;

        while(i>-1 || j >-1 || carry==1){
            aByte = i>-1 ? Character.getNumericValue(aArr[i--]) : 0;
            bByte = j>-1 ? Character.getNumericValue(bArr[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = (aByte + bByte + carry) >= 2 ? 1 : 0;
            sb.append(result);
        }
        
        return sb.reverse().toString();
    }

    public void test(){
        String a = "11";
        String b = "1";
        System.out.println(addbinary(a, b));
        a = "1010";
        b = "1011";
        System.out.println(addbinary(a, b));
    }
}