class Solution {
    public void fun(TreeNode root,int[] nums,int l,int h){
        if(l>h)return ;
        int mid=(l+h)/2;
        TreeNode temp=new TreeNode(nums[mid]);
        if(root.val>temp.val)root.left=temp;
        else root.right=temp;
        fun(temp,nums,l,mid-1);
        fun(temp,nums,mid+1,h); 
    }
    public TreeNode sortedArrayToBST(int[] arr) {
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        fun(root, arr, 0, arr.length-1);
        return root.left;
    }
}