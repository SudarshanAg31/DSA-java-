class Solution {
static int a=1;
    public void fun(TreeNode root,int temp){
        if(root==null)return ;
        if(temp>a)a=temp;
        fun(root.left,temp*2);
        fun(root.right,temp*2+1);
    }
    public int size(TreeNode root){
        if(root==null)return 0;
        return 1+size(root.left)+size(root.right);
    }
    public boolean isCompleteTree(TreeNode root) {
        a=0;
        fun(root,1);
        int T_size=size(root);
        if(a>T_size)return false;
        return true;
    }
}