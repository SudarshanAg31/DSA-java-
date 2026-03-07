class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                int x=mp.get(arr[i]);
                if(i-x<=k){
                    return true;
                }
            }
            mp.put(arr[i],i);
        }
        return false;
    }
}