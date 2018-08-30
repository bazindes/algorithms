package com.baz.app.facebook.medium;

import com.baz.app.util.Interval;

import java.util.*;

public class MeetingRoomsII {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * find the minimum number of conference rooms required.
     * Example 1:
     * Input: [[0, 30],[5, 10],[15, 20]]
     * Output: 2
     * Example 2:
     * Input: [[7,10],[2,4]]
     * Output: 1
     */

    //O(nlogn) O(n)
    public int numOfRooms(Interval[] intervals){
        if(intervals == null || intervals.length == 0) return 0;
        int[]starts = new int[intervals.length];
        int[]ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        Map<Integer, Integer> sts = new HashMap<>();
        Map<Integer, Integer> es = new HashMap<>();
        for(int i=0; i<starts.length; i++){
            sts.put(starts[i], sts.getOrDefault(starts[i] , 0) + 1);
            es.put(ends[i], es.getOrDefault(ends[i] , 0) + 1);
        }
        int[] dp = new int[ends[ends.length - 1] + 1];
        if(starts[0] == 0) dp[0] = 1;
        int max = 0;
        for(int i=1; i<dp.length; i++){
            dp[i] = dp[i - 1];
            if(sts.containsKey(i)){
                int times = sts.get(i);
                while (times -- > 0){
                    dp[i] ++;
                }
            }
            if(es.containsKey(i)){
                int times = es.get(i);
                while (times -- > 0){
                    dp[i] --;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public void test(){
        Interval i1 = new Interval(9 ,10);
        Interval i2 = new Interval(4 ,9);
        Interval i3 = new Interval(4 ,17);
        Interval[] intervals = {i1, i2, i3};

        System.out.println(numOfRooms(intervals));
    }

}
