class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        int[] pse=new int[n];
        int[] nse=new int[n];
        //pse
        st.push(0);
        pse[0]=-1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty())pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        st.push(n-1);
        nse[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty())nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,Math.abs(arr[i]*((nse[i]-pse[i])-1)));
        }
        return max;
    }
}