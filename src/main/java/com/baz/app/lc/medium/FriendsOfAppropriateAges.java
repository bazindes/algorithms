package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class FriendsOfAppropriateAges implements Facebook {

    //Brute Force
    public int numFriendRequests(int[] ages) {
        int ans = 0;

        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if(i == j) continue;
                if(!(ages[i] < ages[j] || ages[j] <= ages[i]/2 + 7 || (ages[j] > 100 && ages[i] < 100) )){
                    ans ++;
                }
                if(!(ages[j] < ages[i] || ages[i] <= ages[j]/2 + 7 || (ages[i] > 100 && ages[j] < 100) )){
                    ans ++;
                }
            }
        }

        return ans;
    }

    //Counting ages
    public int numFriendRequestsCounting(int[] ages){
        int[] counts = new int[121];
        for(int i : ages){
            counts[i] ++;
        }
        int ans = 0;
        for (int i = 0; i < 121; i++) {
            int B = counts[i];
            for (int j = 0; j < 121; j++) {
                int A = counts[j];
                if( i > j ) continue;
                if( i <= j/2 + 7 ) continue;
                if( i > 100 && j < 100 ) continue;
                ans += A * B;
                if( i == j )
                    ans -= A;
            }
        }
        return ans;
    }


    public void test(){
        int[] nums = {16, 16};
        System.out.println(numFriendRequestsCounting(nums));
        nums = new int[]{16, 17, 18};
        System.out.println(numFriendRequestsCounting(nums));
        nums = new int[]{20, 30, 100, 110, 120};
        System.out.println(numFriendRequestsCounting(nums));
    }

}
