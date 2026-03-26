/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void display(TreeNode root ,String str,List<String> arr){
        if(root==null)return ;
        str=str+root.val;
        if(root.left==null&&root.right==null){
            arr.add(str);
            return;
        }
        str=str+"->";
        if(root.left!=null)display(root.left,str,arr);
        if(root.right!=null)display(root.right,str,arr);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>str=new ArrayList<>();
        display(root,"",str);
        return str;
    }
}