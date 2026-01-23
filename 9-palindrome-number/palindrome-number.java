class Solution {
    public boolean isPalindrome(int x) {
        if(x<=-1)return false;
        int temp=x;
        int sum=0;
        while(temp!=0){
            int y=temp%10;
            sum=(sum*10)+y;
            temp/=10;
        }
        if(x==sum)return true;
        else return false;
    }
}