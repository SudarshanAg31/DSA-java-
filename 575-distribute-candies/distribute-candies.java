class Solution {
    public int distributeCandies(int[] arr) {
        Set<Integer>mp=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            mp.add(arr[i]);
        }
        if(mp.size()<arr.length/2)return mp.size();
        else return arr.length/2;
    }
}