class Solution {
    public int missingMultiple(int[] arr, int k) {
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            st.add(arr[i]);
        }
        int mult=k;
        while(true){
            if(!st.contains(mult)){
                return mult;
            }
            mult+=k;
        }
    }
}