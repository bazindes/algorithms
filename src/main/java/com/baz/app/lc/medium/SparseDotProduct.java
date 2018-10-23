package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.HashMap;
import java.util.Map;

public class SparseDotProduct implements Facebook {

    //这样子时间复杂度应该是 n+m
    public int dotproduct(int[] a, int[] b){
        Map<Integer, Integer> mapa = new HashMap<>();
        Map<Integer, Integer> mapb = new HashMap<>();
        for(int i = 0; i < a.length; i ++){
            if(a[i] != 0) mapa.put(i, a[i]);
            if(b[i] != 0) mapb.put(i, b[i]);
        }

        int sum=0;
        for (Integer key : mapa.keySet()) {
            if(mapb.containsKey(key))
                sum += mapb.get(key) * mapa.get(key);
        }

        return sum;
    }

    /**
     * 如果都是sparse vectors,那思路就是把每个vector都表示成(index, non-zero value) pairs:
     * A =[0,2,0,2,0,0,3,0,0,4] ==> A={(1,2), (3,2), (6,3), (9,4)}
     * B=[0,0,0,0,5,0,2,0,0,8]  ==> B={(4,5), (6,2), (9,8)}
     *
     * for each index i,  a = val of pair (i, v_in_A), b= val of pair (i, v_in_B).
     * dot_product(A,B) = sum_of ( a * b )
     *
     * A dot product B = 3*2 + 4*8 = 38
     */

}
