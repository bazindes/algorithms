package com.baz.app.lc.easy;

import com.baz.app.Interface.google.Google;

public class MaximizeDistanceToClosestPerson implements Google {

    public int maxDistToClosest(int[] seats){
        int dist = Integer.MIN_VALUE;
        int j = -1;
        if(seats[0] == 1) j = 0;
        for (int i = 1; i < seats.length; i++) {
            if(seats[i] == 1){
                if(j == -1)
                    dist = Math.max(dist , i);
                else
                    dist = Math.max(dist , (i - j)/2);
                j = i;
            }
        }
        if(seats[seats.length - 1] == 0)
            dist = Math.max(dist , seats.length - 1 - j);
        return dist;
    }

    public void test(){
        int[] seats = {1,0,0,0,1,0,1};
        int[] seats2 = {1,0,0,0};
        int[] seats3 = {0, 1};
        System.out.println(maxDistToClosest(seats));
        System.out.println(maxDistToClosest(seats2));
        System.out.println(maxDistToClosest(seats3));
    }
}
