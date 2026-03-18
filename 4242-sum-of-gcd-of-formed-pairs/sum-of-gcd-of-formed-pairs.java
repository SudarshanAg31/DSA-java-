class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public long gcdSum(int[] arr) {
        int ans[]=new int [arr.length];
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
                ans[i]=max;
            }
            else{
                ans[i]=max;
            }
        }
        int []prf=new int [ans.length];
        for(int i=0;i<arr.length;i++){
            prf[i]=gcd(arr[i],ans[i]);
        }
        Arrays.sort(prf);
        long sum=0;
        for(int i=0;i<arr.length/2;i++){
            sum+=gcd(prf[i],prf[prf.length-1-i]);
        }
        return sum;
    }
}