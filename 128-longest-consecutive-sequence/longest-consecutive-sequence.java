class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        ArrayList<Integer>arr=new ArrayList<>();
        for(Integer i: st){
            arr.add(i);
        }
        Collections.sort(arr);
        int max=1;
        int count=1;
        for(int i=1;i<arr.size();i++){
            if(arr.get(i-1)+1==arr.get(i)){
                count++;
            }
            else{
                if(count>max){
                    max=count;
                }
                count=1;
            }
        } 
        return Math.max(count,max);
    }
}