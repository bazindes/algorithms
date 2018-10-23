package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.DoubleLinkedListNode;
import com.baz.app.util.TreeNode;

public class ConvertDoublyLinkedListToBalancedBST implements Facebook {

    /**
     * Given a Doubly Linked List which has data members sorted in ascending order.
     * Construct a Balanced Binary Search Tree which has same data members as the given Doubly Linked List.
     * The tree must be constructed in-place (No new node should be allocated for tree conversion)
     * Examples:
     *
     * Input:  Doubly Linked List 1  2  3
     * Output: A Balanced BST
     *      2
     *    /  \
     *   1    3
     *
     *
     * Input: Doubly Linked List 1  2 3  4 5  6  7
     * Output: A Balanced BST
     *         4
     *       /   \
     *      2     6
     *    /  \   / \
     *   1   3  4   7
     *
     * Input: Doubly Linked List 1  2  3  4
     * Output: A Balanced BST
     *       3
     *     /  \
     *    2    4
     *  /
     * 1
     *
     * Input:  Doubly Linked List 1  2  3  4  5  6
     * Output: A Balanced BST
     *       4
     *     /   \
     *    2     6
     *  /  \   /
     * 1   3  5
     */


    /**
     * Method 1 (Simple)
     * Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.
     *
     * 1) Get the Middle of the linked list and make it root.
     * 2) Recursively do same for left half and right half.
     *        a) Get the middle of left half and make it left child of the root
     *           created in step 1.
     *        b) Get the middle of right half and make it right child of the
     *           root created in step 1.
     *
     * Time complexity: O(nLogn) where n is the number of nodes in Linked List.
     */

    /**
     * Method 2 (Tricky)
     * In this method, we construct from leaves to root.
     * The idea is to insert nodes in BST in the same order as the appear in Doubly Linked List,
     * so that the tree can be constructed in O(n) time complexity.
     *
     * We first count the number of nodes in the given Linked List.
     * Let the count be n.
     * After counting nodes, we take left n/2 nodes and recursively construct the left subtree.
     * After left subtree is constructed, we assign middle node to root and link the left subtree with root.
     * Finally, we recursively construct the right subtree and link it with root.
     * While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
     */

    DoubleLinkedListNode head;
    /* The main function that constructs balanced BST and returns root of it.
       n  --> No. of nodes in the Doubly Linked List */
    DoubleLinkedListNode sortedListToBSTRecur(int n) {
        /* Base Case */
        if (n <= 0) return null;

        /* Recursively construct the left subtree */
        DoubleLinkedListNode prev = sortedListToBSTRecur(n / 2);

        /* head_ref now refers to middle node, make middle node as root of BST*/
        DoubleLinkedListNode root = head;

        // Set pointer to left subtree
        root.prev = prev;

        /* Change head pointer of Linked List for parent recursive calls */
        head = head.next;

        /* Recursively construct the right subtree and link it with root.
        The number of nodes in right subtree is total nodes - nodes in left subtree - 1 (for root) */
        root.next = sortedListToBSTRecur(n - n / 2 - 1);

        return root;
    }


    public void test(){

    }
}
