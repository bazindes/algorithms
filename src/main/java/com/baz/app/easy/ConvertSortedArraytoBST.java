/**
* <h1></h1>
*
* @author  baz
* @version 1.0
* @since   2018-06-28
*/
class ConvertSortedArraytoBST{
    
    public TreeNode sortedArrayToBST2(int [] nums){
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[]nums, int lo, int hi){
        int p = (lo+hi) / 2;
        TreeNode node = new TreeNode(nums[p]);
        if(hi > p)
            node.right = sortedArrayToBST(nums, p+1, hi);
        if(lo < p)
            node.left = sortedArrayToBST(nums, lo, p-1);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int p = nums.length / 2;
        TreeNode node = new TreeNode(nums[p]);
        TreeNode nodeCur = node;
        int left = p - 1;
        int right = p + 1;
        while(left > -1){
            TreeNode l = new TreeNode(nums[left--]);
            nodeCur.left = l;
            nodeCur = nodeCur.left;
        }
        nodeCur = node;
        while(right < nums.length){
            TreeNode r = new TreeNode(nums[right++]);
            nodeCur.right = r;
            nodeCur = nodeCur.right;
        }
        return node;
    }

    public void test(){
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode t = sortedArrayToBST2(nums);
        Utils.preOrderPrintTree(t);
    }
}