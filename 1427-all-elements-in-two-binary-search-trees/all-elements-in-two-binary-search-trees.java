class Solution {
    public void fun(TreeNode curr,List<Integer>arr){
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
    }
    public void final_ans(List<Integer>arr1,List<Integer>arr2,List<Integer>ans){
        int n=arr1.size();//0
        int m=arr2.size();//4
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(arr1.get(i)>arr2.get(j)){
                ans.add(arr2.get(j));
                j++;
            }
            else{
                ans.add(arr1.get(i));
                i++;
            }
        }
        while(i<n){
            ans.add(arr1.get(i));
            i++;
        }
        while(j<m){
            ans.add(arr2.get(j));
            j++;
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>arr1=new ArrayList<>();
        fun(root1,arr1);
        List<Integer>arr2=new ArrayList<>();
        fun(root2,arr2);
        List<Integer>ans=new ArrayList<>();
        final_ans(arr1,arr2,ans);
        return ans;
    }
}