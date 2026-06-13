
class Solution {
    public int fun(TreeNode root,int sum){
        if(root==null)return 0;
        sum=(sum*10)+root.val;
        if(root.left==null&&root.right==null)return sum;
        return fun(root.left,sum)+fun(root.right,sum);
    }
    public int sumNumbers(TreeNode root) {
        return fun(root,0);
    }
}