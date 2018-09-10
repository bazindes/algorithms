package com.baz.app.facebook.medium;

public class DevideTwoIntegers {

    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     * Return the quotient after dividing dividend by divisor.
     * The integer division should truncate toward zero.
     * Example 1:
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Example 2:
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Note:
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
     */

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) )
            sign = -1;
        long dd = Math.abs(dividend);
        long ds = Math.abs(divisor);

        if(ds == 0) return Integer.MAX_VALUE;
        if(dd == 0 || dd < ds) return 0;

        long lans = helper(dd, ds);
        int ans = 0;
        if(lans > Integer.MAX_VALUE){
            ans = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else {
            ans = (int) (sign * lans);
        }

        return ans;
    }


    private long helper(long dd, long ds){
        if(dd < ds) return 0;

        long sum = ds;
        long mul = 1;

        while (sum + sum <= dd){
            sum += sum;
            mul += mul;
        }

        return mul + helper(dd - sum, ds);
    }


    public void test(){
        System.out.println(divide(10 , 3));
        System.out.println(divide(7 , -3));
    }

}
