class Solution {
    public int calPoints(String[] arr) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("C")||arr[i].equals("D")||arr[i].equals("+")){
                if(arr[i].equals("C")){
                    st.pop();
                }
                else if(arr[i].equals("D")){
                    st.push(st.peek()*2);
                }
                else{
                    int x=st.pop();
                    int y=st.peek()+x;
                    st.push(x);
                    st.push(y);
                }
            }
            else{
            int x=Integer.parseInt(arr[i]);
            st.push(x);
            }
        }
        int sum=0;
        for(Integer i:st){
            sum+=i;
        }
        return sum;
    }
}