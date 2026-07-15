class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=q.remove();
        }
    }
}