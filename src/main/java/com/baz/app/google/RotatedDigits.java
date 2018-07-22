package com.baz.app.google;

import java.util.HashSet;
import java.util.Set;

public class RotatedDigits {

    public int rotatedDigits(int N){
        int num = 0;
        Set<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('5');
        set.add('6');
        set.add('9');
        out : while (N > 1){
            if(N % 10 == 0) continue;
            String n = N + "";
            in : for (char c : n.toCharArray()){
                if(!set.contains(c)){
                    N --;
                    continue out;
                }
            }
            num ++;
            N--;
        }
        return num;
    }

}
