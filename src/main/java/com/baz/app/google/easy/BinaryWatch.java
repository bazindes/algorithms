package com.baz.app.google.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if(Integer.bitCount(i) + Integer.bitCount(j) == num)
                    list.add(String.format("%d:%02d" , i,j));
            }
        }
        return list;
    }

    public void test(){
        readBinaryWatch(1).forEach(s -> System.out.print(s + " "));
        System.out.println();
        readBinaryWatch(2).forEach(s -> System.out.print(s + " "));

    }
}
