/**
* <h1>java code utils</h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-18
*/

public class Utils{
    public static void printArray(int[] arr){
        System.out.print("| ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }
}