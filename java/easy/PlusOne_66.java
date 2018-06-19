/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-19
*/
class PlusOne{
    public int[] plusOne(int[]nums){
        if(nums == null || nums.length == 0) return new int[]{0};
        int[] result = new int[nums.length];
        int count = 0;
        for(int i=nums.length-1;i>-1;i--){
            if(nums[i]!=9) break;
            if(nums[i]==9) count ++;
        }
        if(count > 0){
            if(count == nums.length){
                result = new int[nums.length+1];
                result[0]=1;
            }else{
                for(int i=nums.length-1;i>nums.length-1-count;i--){
                    nums[i] = 0;
                }
                nums[nums.length-1-count] += 1;
                return nums;
            }
        }else{
            nums[nums.length-1] += 1; 
            return nums;
        }
        return result;
    }

    public void test(){
        int []arr = {1, 2, 3, 4};
        int []arr2 = {4, 3, 3, 4};
        int []arr3 = {1, 5, 3, 4};
        int []arr4 = {1, 5, 3, 9};
        int []arr5 = {1, 5, 9, 9};
        int []arr6 = {9, 9, 9, 9};
        Utils.printArray(arr);
        Utils.printArray(plusOne(arr));
        Utils.printArray(arr2);
        Utils.printArray(plusOne(arr2));
        Utils.printArray(arr3);
        Utils.printArray(plusOne(arr3));
        Utils.printArray(arr4);
        Utils.printArray(plusOne(arr4));
        Utils.printArray(arr5);
        Utils.printArray(plusOne(arr5));
        Utils.printArray(arr6);
        Utils.printArray(plusOne(arr6));
    }
}