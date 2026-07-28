class Solution {
    public int reverseBits(int n) {
        int ans=n&1;
        for(int i=1;i<32;i++){
            n>>>=1;
            ans<<=1;
            if((n&1)==1){
                ans|=1;
            }
        }
        return ans;
    }
}