class Solution {
    public int numberOfSteps(int num) {
        int count=0;
        return fun(num,count);
    }
    public int fun(int x,int count){
        if(x==0)return count;
        if(x%2==0)return fun(x/2,count+=1);
        else return fun(x-1,count+=1);
    }
}