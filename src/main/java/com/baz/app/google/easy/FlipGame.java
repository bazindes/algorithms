package com.baz.app.google.easy;

import java.util.LinkedList;
import java.util.List;

public class FlipGame {

    public List<String> generatePossibleNextMoves(String s){
        List<String> list = new LinkedList<>();
        if(s == null || "".equals(s)) return list;
        for (int i = 0; i<s.length() - 1; i++){
            if(s.substring(i).startsWith("++")){
                char[] cs = s.toCharArray();
                cs[i] = '-';
                cs[i+1] = '-';
                list.add(cs.toString());
            }
        }
        return list;
    }

}
