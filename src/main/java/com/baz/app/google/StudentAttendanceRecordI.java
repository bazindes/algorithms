package com.baz.app.google;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s){
        int a = 0;
        int l = 0;
        for (char c : s.toCharArray()){
            if(c == 'A') a ++;
            if(c == 'L') l ++;
        }
        return !(a > 1 || l > 2);
    }

    public StudentAttendanceRecordI(){
        super();
    }
}
