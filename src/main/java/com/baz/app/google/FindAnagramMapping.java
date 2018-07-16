package com.baz.app.google;

public class FindAnagramMapping {

    public int[] anagramMappings(int [] A, int [] B){
        if(A == null || B == null) return null;
        int [] re = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(A[i] == B[j]){
                    re[i] = j;
                    break;
                }
            }
        }

        return re;
    }
}
