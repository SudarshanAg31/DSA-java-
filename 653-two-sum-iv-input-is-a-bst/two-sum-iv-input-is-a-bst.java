class Solution {
    public void helper(TreeNode root , ArrayList<Integer>ans){
        if(root==null) return ;
        helper(root.left , ans);
        ans.add(root.val);
        helper(root.right , ans);
        return;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        if(root.left==null && root.right==null) return false;
        ArrayList<Integer>ans = new ArrayList<>();
        helper(root , ans);
        int left = 0;
        int right = ans.size()-1;
        while(left<right){
            if(ans.get(left)+ans.get(right)==k) return true;
            else if(ans.get(left)+ans.get(right)>k) right--;
            else left++;
        }
        return false;
    }
}
