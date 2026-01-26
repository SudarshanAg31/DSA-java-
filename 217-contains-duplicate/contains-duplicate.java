class Solution {
    public boolean containsDuplicate(int[] arr) {
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(!st.contains(arr[i])){
                st.add(arr[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }
}