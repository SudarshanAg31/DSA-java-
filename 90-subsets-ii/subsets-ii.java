class Solution {
    public void fun(int[] arr,Set<List<Integer>>temp_ans,List<Integer>res,int temp,int i){
        if(i==arr.length){
        List<Integer>a=new ArrayList<>();
            for(int s:res)a.add(s);
            Collections.sort(a);
            temp_ans.add(a);
            return ;
        }
        res.add(arr[i]);
        fun(arr,temp_ans,res,temp,i+1);
        res.remove(res.size()-1);
        fun(arr,temp_ans,res,temp,i+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>>ans=new ArrayList<>();
        Set<List<Integer>>temp_ans=new HashSet<>();
        List<Integer>res=new ArrayList<>();
        fun(arr,temp_ans,res,0,0);
        for(List<Integer> i:temp_ans){
            ans.add(i);
        }
        return ans;
    }
}