/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-21
*/
class MergeSortedArray{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(i > -1 && j>-1){
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j > -1){
            nums1[index --] = nums2[j--];
        }
    }

    public void test(){
        int[]nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[]nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        Utils.printArray(nums1);
    }
}