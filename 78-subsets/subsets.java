class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        int n = nums.length;
        int pow = (int) Math.pow(2, n);
        for (int i = 0; i < pow; i++) {
            List<Integer> part = new ArrayList<>();
            int temp = i;
            for (int j = 0; j < n; j++) {
                if ((temp & 1) == 1) {
                    part.add(nums[j]);
                }
                temp >>= 1;
            }
            arr.add(part);
        }
        return arr;
    }
}