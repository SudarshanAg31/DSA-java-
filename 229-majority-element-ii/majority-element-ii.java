class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer>mp=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],1);
            }
            else{
                mp.put(nums[i],mp.get(nums[i])+1);
            }
        }
        int n=nums.length/3;
        for(int i:mp.keySet()){
            if(mp.get(i)>n){
                ans.add(i);
            }
        }
        return ans;
    }
}