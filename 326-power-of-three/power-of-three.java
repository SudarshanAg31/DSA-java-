class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)return false;
        return fun(n);
    }
    public boolean fun(int x){
        if(x<=1)return true;
        if(x%3==0)return fun(x/3);
        else return false;
    }
}