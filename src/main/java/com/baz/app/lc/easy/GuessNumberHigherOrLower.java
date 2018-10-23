package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class GuessNumberHigherOrLower implements Google {
    int pick = 0;

    public int guessNumberBS(int n){
        int lo = 1;
        int high = n;
        while (lo <= high){
            int mid = lo + (high - lo)/2;
            int res = guess(mid);
            if(res == 0){
                return mid;
            }else if(res == 1){
                lo = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    public int guessNumber(int n){
        int mid = n/2;
        while (guess(mid)!=0){
            if(1 == guess(mid))
                mid += (mid/2)==0?1:mid/2;
            else
                mid -= (mid/2)==0?1:mid/2;
        }
        return mid;
    }

    private int guess(int n){
        if(n == pick) return 0;
        if(n < pick) return 1;
        return -1;
    }

    public void test(){
        pick = 6;
        System.out.println(guessNumber(10));
        System.out.println(guessNumberBS(10));
    }
}
