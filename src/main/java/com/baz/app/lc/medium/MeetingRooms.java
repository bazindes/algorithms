package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Interval;

import java.util.Arrays;

public class MeetingRooms implements Facebook {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings.
     *
     * Example 1:
     * Input: [[0,30],[5,10],[15,20]]
     * Output: false
     *
     * Example 2:
     * Input: [[7,10],[2,4]]
     * Output: true
     */


    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (i,j) -> i.start - j.start);
        for (int i = 1; i<intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end)
                return false;
        }
        return true;
    }

}
