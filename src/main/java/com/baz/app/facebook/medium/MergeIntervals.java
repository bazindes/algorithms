package com.baz.app.facebook.medium;


import com.baz.app.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort( (i,j) -> i.start - j.start);
        LinkedList<Interval> list = new LinkedList<>();
        for (Interval interval : intervals){
            if(list.size() == 0 || list.getLast().end < interval.start){
                list.add(interval);
            }else {
                list.getLast().end = Math.max(interval.end, list.getLast().end);
            }
        }
        return list;
    }

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
