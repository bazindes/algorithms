package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

import java.util.Arrays;

public class Heaters implements Google {

    public int findRadius(int[] houses, int[] heaters) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(heaters);

        for (int i = 0; i < houses.length; i++) {
            int ioh = Arrays.binarySearch(heaters, houses[i]);
            if(ioh < 0){
                ioh = -(ioh + 1);
            }
            int distL = ioh - 1 >=0 ? houses[i] - heaters[ioh - 1]:Integer.MAX_VALUE;
            int distR = ioh < heaters.length ? heaters[ioh] - houses[i] : Integer.MAX_VALUE;
            max = Math.max(max, Math.min(distL, distR));
        }
        return max;
    }

    public void test(){
        int[] hs = {1, 2, 3};
        int[] hes = {2};
        System.out.println(findRadius(hs, hes));
        hs = new int[]{1, 2, 3, 4};
        hes = new int[]{1, 4};
        System.out.println(findRadius(hs, hes));
    }
}
