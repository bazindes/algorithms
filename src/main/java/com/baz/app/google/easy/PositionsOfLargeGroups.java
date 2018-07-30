package com.baz.app.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S){
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int count = 1;

        for (int i = 1; i < S.length(); i++) {
            if( S.charAt(start) == S.charAt(i) ){
                count ++;
            }else {
                start = i;
                count = 1;
            }
            if(count > 2){
                map.put(start , i);
            }
        }

        for( int i : map.keySet()){
            List<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(map.get(i));
            list.add(l);
        }
        return list;
    }


    public void test(){
        String s = "abbxxxxzzy";
        String s2 = "abc";
        String s3 = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(s));
        System.out.println(largeGroupPositions(s2));
        System.out.println(largeGroupPositions(s3));
    }
}
