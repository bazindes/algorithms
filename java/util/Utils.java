/**
* <h1>java code utils</h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-18
*/
public class Utils{
    public static void preOrderPrintTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val + " | ");
            inOrderPrintTree(root.left);
            inOrderPrintTree(root.right);
        }
    }

    public static void postOrderPrintTree(TreeNode root){
        if(root!=null){
            inOrderPrintTree(root.left);
            inOrderPrintTree(root.right);
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

    public static void printArray(int[] arr){
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