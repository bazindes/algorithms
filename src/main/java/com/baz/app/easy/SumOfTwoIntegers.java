package com.baz.app.easy;

public class SumOfTwoIntegers {

    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     *
     * Example:
     * Given a = 1 and b = 2, return 3.
     * @param a
     * @param b
     * @return
     */
    public int plus(int a, int b){
        if(b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return plus(sum, carry);
    }

    public void test(){
        System.out.println(plus( 1, 2));
        System.out.println(plus( 1, 3));
        System.out.println(plus( 1, 4));
        System.out.println(plus( 1, 5));
    }
}
