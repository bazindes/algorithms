package com.baz.app.google;

import com.baz.app.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points){
        int num = 0;
        Map<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(i == j) continue;
                int d = getDistance(points[i] , points[j]);
                map.put(d, map.getOrDefault(d,0) + 1);
            }
            for(int val : map.values()){
                num += val * (val- 1);
            }
            map.clear();
        }
        return num;
    }

    private int getDistance(int []a, int []b){
        int x = b[0] - a[0];
        int y = b[1] - a[1];
        return y*y + x*x;
    }

    public int numberOfBoomerangsBF(int[][] points){
        int num = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(j == i) continue;
                for (int k = 0; k < points.length; k++) {
                    if(k==i || k==j) continue;
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if(((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1)) == ((x3 - x1)*(x3 - x1) + (y3 - y1)*(y3 - y1)))
                        num ++;
                }
            }
        }
        return num;
    }

    public void test(){
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }
}
