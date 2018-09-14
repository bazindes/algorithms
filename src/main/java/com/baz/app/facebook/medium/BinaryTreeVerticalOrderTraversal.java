package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;
import com.baz.app.util.Utils;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    /**
     * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
     * If two nodes are in the same row and column, the order should be from left to right.
     * Examples 1:
     * Input: [3,9,20,null,null,15,7]
     *    3
     *   /\
     *  /  \
     *  9  20
     *     /\
     *    /  \
     *   15   7
     * Output:
     * [
     *   [9],
     *   [3,15],
     *   [20],
     *   [7]
     * ]
     * Examples 2:
     * Input: [3,9,8,4,0,1,7]
     *
     *      3
     *     /\
     *    /  \
     *    9   8
     *   /\  /\
     *  /  \/  \
     *  4  01   7
     * Output:
     * [
     *   [4],
     *   [9],
     *   [3,0,1],
     *   [8],
     *   [7]
     * ]
     * Examples 3:
     * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
     *      3
     *     /\
     *    /  \
     *    9   8
     *   /\  /\
     *  /  \/  \
     *  4  01   7
     *     /\
     *    /  \
     *    5   2
     * Output:
     * [
     *   [4],
     *   [9,5],
     *   [3,0,1],
     *   [8,2],
     *   [7]
     * ]
     */

    public List<List<Integer>> verticalOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        nodes.offer(root);
        cols.offer(0);

        int min = 0;
        int max = 0;

        while (!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            Integer curCol = cols.poll();

            if(!map.containsKey(curCol))
                map.put(curCol, new ArrayList<>());

            map.get(curCol).add(cur.val);

            if(cur.left != null){
                nodes.offer(cur.left);
                cols.offer(curCol - 1);
                min = Math.min(min, curCol - 1);
            }
            if(cur.right != null){
                nodes.offer(cur.right);
                cols.offer(curCol + 1);
                max = Math.max(max, curCol + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    public void test(){
        TreeNode root = new TreeNode(0);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode l1l2 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r1l1 = new TreeNode(5);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l1;

        Utils.inOrderPrintTree(root);
        System.out.println();
        verticalOrder(root).forEach( i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });

    }

}
