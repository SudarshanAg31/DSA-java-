class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)return false;
        return fun(n);
    }
    public boolean fun(int x){
        if(x<=1)return true;
        if(x%4==0)return fun(x/4);
        else return false;
    }
}