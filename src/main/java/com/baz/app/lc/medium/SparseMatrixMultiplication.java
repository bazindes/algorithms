package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashMap;

public class SparseMatrixMultiplication implements Facebook {

    /**
     * Given two sparse matrices A and B, return the result of AB.
     *
     * You may assume that A's column number is equal to B's row number.
     *
     * Example:
     *
     * Input:
     *
     * A = [
     *   [ 1, 0, 0],
     *   [-1, 0, 3]
     * ]
     *
     * B = [
     *   [ 7, 0, 0 ],
     *   [ 0, 0, 0 ],
     *   [ 0, 0, 1 ]
     * ]
     *list of pairs or two dimensional array
     * hint
     *
     * Output:
     *
     *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
     *                   | 0 0 1 |
     */

    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }

    /**
     * 具体而言，我有两个vector a:[0, 0, 0, 0, a1, 0, 0, 0….a2, 0, 0….], b:[0, 0, 0, 0, b1, 0, 0…..],你可以看到有很多0，
     * 所以如果我们直接一个个乘是很浪费时间的，所以你可以设计一个数据结构来存储这些系数矩阵并高效地想乘，
     *
     * hash map挺浪费的，直接用list(tuple)存就行，tuple->（value,index）
     * 如果都是sparse vectors,那思路就是把每个vector都表示成(index, non-zero value) pairs:
     * A =[0,2,0,2,0,0,3,0,0,4] ==> A={(1,2), (3,2), (6,3), (9,4)}
     * B=[0,0,0,0,5,0,2,0,0,8] ==> B={(4,5), (6,2), (9,8)}
     *
     * for each index i, a = val of pair (i, v_in_A), b= val of pair (i, v_in_B). visit 1point3acres.com for more.
     * dot_product(A,B) = sum_of ( a * b )
     * A dot product B = 3*2 + 4*8 = 38
     *
     * follow-up：
     * what if the number of nonzero elements of one vector is 10^10 and the other is 10^2, how can you make it faster?
     *
     * follow-up:
     * follow up问有没有更简单的数据结构，我答的是array存index和value。
     *
     * Dot Product.
     * A={a1, a2, a3,…}.
     * B={b1, b2, b3,…}
     * dot_product = a1 * b1 + a2 * b2 + a3 * b3 ＋。。。
     * 如果数组很稀疏，例如
     * A={a1, …., a300, …., a5000}
     * B={…., b100, …, b300, …, b1000, …}
     * 里面有很多0，用什么数据结构表示能节省空间。我开始说用hashmap，但是hashmap不能做有顺序的iteration。然后改用list和array，两个都可以。后面做题的时用的array。
     * 题目是：
     * input A=[[1, a1], [300, a300], [5000, a5000]]
     * B=[[100, b100], [300, b300], [1000, b1000]]
     * 求 dot product. 问了时间复杂度。
     * Follow up:
     * 如果length(B) >>> length(A)，即B非常长，怎么做能减少时间复杂度。对A里面的每个数，用binary search找B中相对应的值，
     * 这样时间复杂度是O(nlogm) (n = len(A), m =len(B)).时间不够没写代码， 就说了一下思路和复杂度
     *
     *
     */

    // 思路1: hashmap
    public int dotproduct(int[] a, int[] b){

        HashMap<Integer, Integer> mapa = new HashMap<>();
        HashMap<Integer, Integer> mapb = new HashMap<>();

        for(int i=0;i<a.length;i++){
            if(a[i]!=0) mapa.put(i,a[i]);
            if(b[i]!=0) mapb.put(i,b[i]);
        }

        int sum=0;

        for (Integer key : mapa.keySet()) {
            if(mapb.containsKey(key))
                sum += mapb.get(key) * mapa.get(key);
        }
        return sum;
    }

    // 思路2: array
    // 暴力解法：
    public int dotproduct2(int[][] a,int[][]b){
        int n=a.length;
        int m=b.length;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][0]==b[j][0])
                    sum+=a[i][1]*b[j][1];
            }
        }
        return sum;
    }

//    public int dotproduct(int[][]a, int[][] b){
//        int n = a.length;
//        int m = b.length;
//        for(int i = 0; i < n; i ++){
//            sum += (binarysearch(a[i][0],) != -1) ? binarysearch(a[i][0]) : 0;
//        }
//    }
//    private int binarysearch(int a, int[] b){
//        return index || -1;
//    }

    /**
     * b) The smart solution, the key part of smart solution is that: it does not calculate the final result at once, and it takes each value from A,
     * and calculate and partial sum and accumulate it into the final spot:
     *
     * For example, for each value A[i][k], if it is not zero, it will be used at most nB times ( n is B[0].length ), which can be illustrated as follow:
     * Generally for the following equation:
     * C[ i ][ j ] = A[ i ][0]*B[0][j] + A[i][1]*B[1][j] + A[i][2]*B[2][j] + ... A[i][k]*B[k][j] .... A[i][K]*B[K][j]
     * j can be from 0 to nB, if we write all of them down, it will like following:
     * [For i from 0 to nB
     * C[ i ][ 0 ]=A[ i ][0]*B[0][0] + A[i][1]*B[1][0] + A[i][2]*B[2][0] + ... A[i][k]B[k][0] .... A[i][K]*B[K][0]
     * C[ i ][ 1 ]=A[ i ][0]*B[0][1] + A[i][1]*B[1][1] + A[i][2]*B[2][1] + ... A[i][k]B[k][0] .... A[i][K]*B[K][1]
     * ...
     * C[ i ][ nB ]=A[ i ][0]*B[0][nB] + A[i][1]*B[1][nB] + A[i][2]*B[2][nB] + ... A[i][k]B[k][nB] .... A[i][K]*B[K][nB]
     *
     * As you can see from above: for the same value A[i][k] from the first matrix, it will be used at most nB times if A[i][k] is not zero.
     * And the smart solution is taking advantage of that!!!, the smart solution can be described as:
     *
     * For each value A[i][k] in matrix A, if it is not zero, we calculate A[i][k] * B[k][j] and accumulate it into C[ i ][ j ]
     * (Key part: the C[ i ][ j ] by now is not the final value in the result matrix
     * !! Remember, in the brute force solution,
     * the final value of C[i][j], takes sum of all multiplication values of K corresponding values from A and B?
     * here C[ i ][ j ] is only sum of some multiplication values, NOT ALL until the program is done )
     *
     * BY NOW, it is very clear that, if the value A[ i ][ k ] from matrix is zero,
     * we skip a For-loop- calculation, which is a loop iterating nB times, and this is the key part of why the smart solution is smart!!!
     */

}
