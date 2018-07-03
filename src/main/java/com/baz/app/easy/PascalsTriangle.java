package com.baz.app.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int rowsNum){
        List<List<Integer>> list = new ArrayList<>();
        if (rowsNum == 0) return list;
        list.add(Arrays.asList(1));
        for (int i = 1; i < rowsNum; i++) {
            List<Integer> cur = list.get(i - 1);
            List<Integer> ne = new ArrayList<>(i + 1);
            ne.add(cur.get(0));
            ne.add(cur.get(cur.size() - 1));
            for (int j = 1; j < cur.size(); j++) {
                ne.add(j, cur.get(j-1) + cur.get(j));
            }
            list.add(ne);
        }
        return list;
    }

    public void test(){
        List<List<Integer>> list = generate(5);
        list.forEach((l) -> System.out.println(l.toString()));
    }
}
