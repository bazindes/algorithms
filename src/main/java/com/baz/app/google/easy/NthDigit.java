package com.baz.app.google.easy;

public class NthDigit {

    public int findNthDigit(int n) {
        int digit = 1;
        int count = 9;
        /**
         * for 1-9 , 9 in total, digit=1, count=9
         * for 10 - 99, 90 in total, digit=2, count=9
         * for 100 - 999, 990 in total, digit=3, count=9
         * for 10000 - 9999, 9990 in total, digit=4, count=9
         * thus, we can see the range where nth number locate is 10^digit to count^digit
         * */
        while (n >= digit * count){
            n -= digit * count;
            digit ++;
            count *= 10;
        }

        int base = (int)Math.pow(10, digit - 1);
        int num = (n-1)/digit + base;
        int mod = (n-1)%digit;

        return String.valueOf(num).charAt(mod) - '0';

    }

    public void test(){
        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(30));
        System.out.println(findNthDigit(31));
    }

}
