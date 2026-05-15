class Solution {
    public int[] separateDigits(int[] arr) {
        int length=0;
        for(int i=0;i<arr.length;i++){
            int x=(int)Math.log10(arr[i])+1;
            length+=x;
        }
        int count=0;
        int[] ans=new int [length];
        for(int i=0;i<arr.length;i++){
            int x=(int)Math.log10(arr[i])+1;
            if(x<2){
                ans[count++]=arr[i];
            }
            else{
                Stack<Integer>st=new Stack<>();
                while(arr[i]!=0){
                    int y=arr[i]%10;
                    st.push(y);
                    arr[i]/=10;
                }
                while(!st.isEmpty()){
                    ans[count++]=st.pop();
                }
            }
        }
        return ans;
    }
}