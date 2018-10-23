package com.baz.app.lc.medium;


import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.Interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals implements Facebook {

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     *
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     *
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
     */

    //O(nlogn) O(n)(O(1))
    public List<Interval> merge(List<Interval> intervals) {
        // sort list base on start in ascending order
        intervals.sort( (i,j) -> i.start - j.start);
        LinkedList<Interval> list = new LinkedList<>();

        // go through all intervals
        for (Interval interval : intervals){

            // if the first one, or, previous one's end is smaller than current one
            // add current interval into list directly
            if(list.size() == 0 || list.getLast().end < interval.start){
                list.add(interval);
            }else {
                // otherwise, merge
                // trick: we don't need create new one, we can update previous one
                list.getLast().end = Math.max(interval.end, list.getLast().end);
            }
        }
        return list;
    }


    /**
     * followup是如果有⼀个⾮常⻓怎么办
     * 变种：given two sorted arrays of intervals, return the intersection.
     * ex.
     * a = [(1 5), (8, 10), (15 20)] sorted
     * b = [(2 6), (45 100)] sorted
     * return [(2, 5)]
     * 我⽤了两个pointer指着a和b然后⽤了⼏个case对⽐
     */

    public void test(){
        Interval i0 = new Interval(1,3);
        Interval i1 = new Interval(2,6);
        Interval i2 = new Interval(8,10);
        Interval i3 = new Interval(15,18);
        List<Interval> l1 = Arrays.asList(new Interval[]{i0, i1, i2, i3});
        l1.forEach(interval -> System.out.print(interval.toString() + " "));
        System.out.println();
        merge(l1).forEach(interval -> System.out.print(interval + " "));
        System.out.println();
        Interval i4 = new Interval(1,4);
        Interval i5 = new Interval(4,5);
        List<Interval> l2 = Arrays.asList(new Interval[]{i4, i5});
        l2.forEach(interval -> System.out.print(interval.toString() + " "));
        System.out.println();
        merge(l2).forEach(interval -> System.out.print(interval + " "));
        System.out.println();
    }

}
