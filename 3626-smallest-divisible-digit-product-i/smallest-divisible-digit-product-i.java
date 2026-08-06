class Solution {
    public int smallestNumber(int n, int t) {
        int y=100;
        while(y!=0){
        int temp=n;
        int ans=1;
            while(temp!=0){
                int x=temp%10;
                ans*=x;
                temp/=10;
            }
            if(ans%t==0)return n;
            n++;
            y--;
        }
        return n;
    }
}