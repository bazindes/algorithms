/**
* <h1>Leetcode 53</h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-19
*/

class MaximumSubarray{
    public int maximumSubarray(int[] nums){
        int maxSum = nums[0];
        int maxGlobal = nums[0];
        for(int i=1;i<nums.length;i++){
            maxSum = Math.max(nums[i] , maxSum + nums[i]);
            maxGlobal = Math.max(maxSum, maxGlobal);
        }
        return maxGlobal;
    }

    public void test(){
        int[]arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Utils.printArray(arr);
        System.out.println(maximumSubarray(arr));
    }
}