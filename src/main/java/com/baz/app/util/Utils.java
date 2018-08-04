package com.baz.app.util;
/**
* <h1>java code utils</h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-18
*/
public class Utils{
    public static void printMatrix(int [][] a , int rows, int cols){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j] + " ");
            }
                System.out.println();
        }
    }

    public static void preOrderPrintTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val + " | ");
            preOrderPrintTree(root.left);
            preOrderPrintTree(root.right);
        }
    }
    
    public static void postOrderPrintTree(TreeNode root){
        if(root!=null){
            postOrderPrintTree(root.left);
            postOrderPrintTree(root.right);
            System.out.print(root.val + " | ");
        }
    }
    
    public static void inOrderPrintTree(TreeNode root){
        if(root!=null){
            inOrderPrintTree(root.left);
            System.out.print(root.val + " | ");
            inOrderPrintTree(root.right);
        }
    }

    public static void printArray(Object[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static void printLinkedList(ListNode node){
        System.out.print("| ");
        while(node != null){
            System.out.print(node.val + " | ");
            node = node.next;
        }
    }
}