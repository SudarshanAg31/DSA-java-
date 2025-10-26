class Solution {
    public int[] twoSum(int[] arr, int target) {
        int []ans=new int[2];
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                ans[0]=mp.get(arr[i]);
                ans[1]=i;
                break;
            }
            else{
                mp.put(target-arr[i],i);
            }
        }
        return ans;
    }
}