class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
         int x=0;
            while(!st.isEmpty()&&st.peek()>0&&0>arr[i]){
                if(arr[i]<=0){
                    if(st.peek()<Math.abs(arr[i])){
                        st.pop();
                    }
                    else if(st.peek()==Math.abs(arr[i])){
                        st.pop();
                        x=1;
                        break;
                    }
                    else{
                        x=1;
                        break;
                    }
                }
                else{
                    break;
                }
            }
            if(x!=1)st.push(arr[i]);
        }
        int[] ans=new int [st.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}