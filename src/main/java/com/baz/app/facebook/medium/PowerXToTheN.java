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

    public double myPowRecursive(double x, int n){
        if(n == 0)
            return 1;
        if(n < 0){
            return 1/x * myPowRecursive( 1/x, -n - 1 );
        }
        return n %2 == 0? myPowRecursive(x * x, n / 2) : x * myPowRecursive(x * x, n /2);
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
