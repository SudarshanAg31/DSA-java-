class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>arr=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pre=curr.left;
                while(pre.right!=null&&pre.right!=curr){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }
                if(pre.right==curr){
                    pre.right=null;
                    arr.add(curr.val);
                    curr=curr.right;
                }
            }
            else{
                arr.add(curr.val);
                curr=curr.right;
            }
        }
        return arr;
    }
}