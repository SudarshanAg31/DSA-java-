class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        return fun(n);
    }
    public boolean fun(int x){
        if(x<=1)return true;
        if(x%2==0)return fun(x/2);
        else return false;
    }
}