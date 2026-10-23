class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
       Set<Integer>st=new HashSet<>();
       for(int i:friends){
        st.add(i);
       } 
       int a=0; 
       for(int i=0;i<order.length;i++ ){
        if(st.contains(order[i])){
            friends[a++]=order[i];
        }
       }
       return friends;
    }
}