class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int x=0;
        for(int i=0;i<piles.length;i++){
            x=Math.max(piles[i],x);
        }
        int e=x;
        int min=Integer.MAX_VALUE;
        while(s<=e){
            int mid=s+(e-s)/2;
            long count=0;
            for(int i=0;i<piles.length;i++){
                if(piles[i]%mid==0)count+=piles[i]/mid;
                else count+=(piles[i]/mid)+1;
            }
            if(count<=h){
                min=Math.min(mid,min);
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return min;
    }
}