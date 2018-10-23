package com.baz.app.lc.easy;
/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-20
*/
class ClimbingStairs{
    public int climbStairs(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int []dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public void test(){
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(44));
    }


}