class Solution {
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int y=height(root.left);
        int z=height(root.right);
        int curr=y+z;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(curr, Math.max(leftDiameter, rightDiameter));
    }
}