class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>qu=new LinkedList<>();
        qu.add(root);
        int level=1;
        int max_level=1;
        int max=Integer.MIN_VALUE;
        while(!qu.isEmpty()){
            int size=qu.size();
            int sum=0;
            for(int i=0;i<size;i++){
            TreeNode temp=qu.poll();
                sum+=temp.val;
                if(temp.left!=null){
                    qu.add(temp.left);
                    }
                if(temp.right!=null){
                    qu.add(temp.right);
                }
            }
            if(sum>max){
                max=sum;
                max_level=level;
            }
            level++;
        }
        return max_level;
    }
}