package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.*;

public class BrickWall implements Facebook {

    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (List<Integer> l : wall){
            int length = 0;
            for(int i =0; i<l.size() - 1; i ++){
                length += l.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                ans = Math.max(ans, map.get(length));
            }
        }

        return wall.size() - ans;
    }

    public void test(){
        List<List<Integer>> wall = new ArrayList<>();
        Integer[][] w = {
            {1,2,2,1},
             {3,1,2},
             {1,3,2},
             {2,4},
             {3,1,2},
             {1,3,1,1}
        };
        w = new Integer[][]{
                {1},
                {1},
                {1}
        };
        for( Integer[] i : w){
            wall.add(Arrays.asList(i));
        }
        wall.forEach(i -> {
            i.forEach(j -> System.out.print( j + " "));
            System.out.println();
        });
        System.out.println("--------------");

        System.out.println(leastBricks(wall));
    }

}
