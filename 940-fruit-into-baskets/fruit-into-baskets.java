class Solution {
    public int totalFruit(int[] arr) {
        int s=0;
        int max=0;
        Map<Integer,Integer>mp=new HashMap<>();
        for(int e=0;e<arr.length;e++){
            //add element condition
            if(!mp.containsKey(arr[e])){
                mp.put(arr[e], 1);
            }
            else{
                mp.put(arr[e], mp.get(arr[e])+1);
            }
            // remove element if it exceed
            while(mp.size()>2){
                mp.put(arr[s],mp.get(arr[s])-1);
                if(mp.get(arr[s])==0){
                    mp.remove(arr[s]);
                }
                s++;
            }
            //update max if it greater then max variable
            max=Math.max(max,e-s+1);
        }
        return max;
    }
}