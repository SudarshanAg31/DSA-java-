class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode curr=root;
        TreeNode prv=null;
        TreeNode prvprv=null;
        List<TreeNode>arr=new ArrayList<>();
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
                    if(prv!=null&&prvprv!=null){
                        if(prv.val>curr.val&&prv.val>prvprv.val)arr.add(prv);
                        if(prv.val<curr.val&&prv.val<prvprv.val)arr.add(prv);
                    }
                    else if(prv!=null&&prv.val>curr.val){
                        arr.add(prv);
                    }
                    prvprv=prv;
                    prv=curr;
                    curr=curr.right;
                }
            }
            else{
                if(prv!=null&&prvprv!=null){
                    if(prv.val>curr.val&&prv.val>prvprv.val)arr.add(prv);
                    if(prv.val<curr.val&&prv.val<prvprv.val)arr.add(prv);
                }
                else if(prv!=null&&prv.val>curr.val){
                    arr.add(prv);
                }
                prvprv=prv;
                prv=curr;
                curr=curr.right;
            }
        }
        if(prvprv.val>prv.val)arr.add(prv);
        TreeNode a=arr.get(0);
        TreeNode b=arr.get(arr.size()-1);
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
}