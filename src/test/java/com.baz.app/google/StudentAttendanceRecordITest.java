package com.baz.app.google;

import com.baz.app.google.easy.StudentAttendanceRecordI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentAttendanceRecordITest {


    @Test
    public void test(){

        StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();

        String record1 = "PPALLP";
        String record2 = "PPALLL";

        assertEquals( true , studentAttendanceRecordI.checkRecord(record1));
        assertEquals( false , studentAttendanceRecordI.checkRecord(record2));

    }
}
