class Solution {
        public void fun(int i,List<Integer>temp,Set<List<Integer>>st){
        if(i==temp.size()){
            List<Integer>a=new ArrayList<>(temp);
            st.add(a);
        }
        for(int j=i;j<temp.size();j++){
            Collections.swap(temp,i,j);
            fun(i+1,temp,st);
            Collections.swap(temp,i,j);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        Set<List<Integer>>st=new HashSet<>();
        for(int val:nums)temp.add(val);
        fun(0,temp,st);
        for(List<Integer> i: st){
            ans.add(i);
        }
        return ans;
    }
}