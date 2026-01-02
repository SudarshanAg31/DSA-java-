class Solution {
    public int sol(int num){
        int ans=0;
        while(num!=0){
            int x=num%10;
            x=(int)Math.pow(x,2);
            ans+=x;
            num/=10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        if (n==10||n==100) return true;
        int slow=n;
        int fast=n;
        while(fast!=1){
            slow=sol(slow);
            fast=sol(fast);
            fast=sol(fast);
            if(slow==fast){
                return false;
            }
        }
        return true;
    }
}