class Solution {
    public void fun(int[] candidates,int target,List<List<Integer>>ans,List<Integer>find,int sum,int idx){
        if(sum==target){
            List<Integer>arr=new ArrayList<>(find);
            ans.add(arr);
            return ;
        }
        if(sum>target)return ;
        for(int i=idx;i<candidates.length;i++){
            find.add(candidates[i]);
            fun(candidates,target,ans,find,sum+candidates[i],i);
            find.remove(find.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>find=new ArrayList<>();
        fun(candidates,target,ans,find,0,0);
        return ans;
    }
}