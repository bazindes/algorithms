package com.baz.app.facebook.medium;

public class PowerXToTheN {

    //TLE
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        int abs = n > 0 ? n  : 0 - n ;
        double ans = x;
        while (abs -- > 1){
            ans *= x;
        }
        return n > 0 ? ans : 1/ans;
    }

    // O(logn) O(logn)
    public double myPowRecursive(double x, int n){
        if(n == 0)
            return 1;
        if(n < 0){
            return 1/x * myPowRecursive( 1/x, -n - 1 );
        }
        return n %2 == 0? myPowRecursive(x * x, n / 2) : x * myPowRecursive(x * x, n /2);
    }

    // O(logn) O(1)
    public double myPowIter(double x, int n) {
        long N = n;
        // if n is negative, the base use 1/x instead
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            // only happens when i == N and i is odd number
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    public void test(){
        System.out.println(myPow(2.0, 10));
        System.out.println(myPowRecursive(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPowRecursive(2.1, 3));
        System.out.println(myPow(2.0, -2));
        System.out.println(myPowRecursive(2.0, -2));
    }

}
