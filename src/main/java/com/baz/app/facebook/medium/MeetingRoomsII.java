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
        // corner case
        if (intervals == null || intervals.length == 0) return 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int endIdx = 0;
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endIdx])  // need a new room
                res++;
            else
                endIdx++;
        }

        return res;
    }

    //O(nlogn) O(n)
    public int numOfRoomsUsingPQ(Interval[] intervals){
        if(intervals == null || intervals.length == 0) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length);
        // sort start in ascending order
        Arrays.sort(intervals, (x, y) -> x.start - y.start);

        minHeap.add(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            // if before next interval start, the previous one is already ended, poll it out
            if(intervals[i].start >= minHeap.peek()){
                minHeap.poll();
            }
            // create new room, and the first ending interval will be the top element
            minHeap.add(intervals[i].end);
        }

        return minHeap.size();

    }

    /**
     * 变种：interval变种题, 找出最⼤利润情况下，最合适的价格。⽐如接受价格范围
     * A[8, 10] B[6, 8] C[12, 14] 此时定价应该为8因为profit为16(A,B接受此价格)最
     * ⼤。
     */

    public void test(){
        Interval i1 = new Interval(9 ,10);
        Interval i2 = new Interval(4 ,9);
        Interval i3 = new Interval(4 ,17);
        Interval[] intervals = {i1, i2, i3};

        System.out.println(numOfRooms(intervals));
        System.out.println(numOfRoomsUsingPQ(intervals));
    }

}
