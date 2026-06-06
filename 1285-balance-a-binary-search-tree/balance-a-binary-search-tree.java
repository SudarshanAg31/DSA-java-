class Solution {
    public void inorder(TreeNode root,List<Integer>arr){
        if(root==null)return ;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    public TreeNode ans(List<Integer>arr,int l,int h){
        if(l>h)return null;
        int mid=(l+h)/2;
        TreeNode temp=new TreeNode (arr.get(mid));
        temp.left=ans(arr,l,mid-1);
        temp.right=ans(arr,mid+1,h);
        return temp;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>arr=new ArrayList<>();
        inorder(root,arr);   
        return ans(arr,0,arr.size()-1);
        
    }
}