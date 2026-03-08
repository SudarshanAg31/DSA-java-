class Solution {
    public int trap(int[] height) {
        int []left=new int [height.length];
        int []right=new int [height.length];
        int l_max=height[0];
        for(int i=0;i<left.length;i++){
            left[i]=l_max;
            if(height[i]>l_max){
                l_max=height[i];
            }
        }
        int r_max=height[height.length-1];
        for(int i=right.length-1;i>=0;i--){
            right[i]=r_max;
            if(height[i]>r_max){
                r_max=height[i];
            }
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            int x=Math.min(left[i],right[i]);
            if(x-height[i]>0){
                ans+=x-height[i];
            }
        }
        return ans;
    }
}