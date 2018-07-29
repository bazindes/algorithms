package com.baz.app.google;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s){
        int a = 0;
        int l = 0;
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A') a ++;
            if(i > 1){
                if(c == 'L' && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') l ++;
            }
        }
        return !(a > 1 || l > 0);
    }

    public StudentAttendanceRecordI(){
        super();
    }
}
