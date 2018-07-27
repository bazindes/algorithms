package com.baz.app.medium;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix == null) return false;
        int  n = (matrix.length * matrix[0].length) - 1;
        return binarySearch(matrix, 0, n, target);
    }

    public boolean binarySearch(int[][]matrix, int start, int end, int target){
        if(start == end) return matrix[start/matrix[0].length][start%matrix[0].length] == target;
        int mid = (start + end) / 2;
        if(start < end){
            if (matrix[mid/matrix[0].length][mid%matrix[0].length] == target){
                return true;
            }else if(matrix[mid/matrix[0].length ][mid%matrix[0].length] > target){
                return binarySearch(matrix, start, mid, target);
            }else{
                return binarySearch(matrix, mid+1, end, target);
            }
        }
        return false;
    }

    public void test(){
        int [][]a =new int[][] {
                {1,1},
                {2, 2}
        };
        System.out.println(searchMatrix(a, 2));
        int [][]a2 =new int[][] {
                {1,3,5,7},
                {10,11, 16,20},
                {23, 30, 34, 50}
        };
//        System.out.println(searchMatrix(a2, 24));
//        System.out.println(searchMatrix(a2, 23));
    }
}
