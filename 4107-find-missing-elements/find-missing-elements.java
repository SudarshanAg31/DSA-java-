class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
            st.add(nums[i]);
        }
        int i = min;
        while (i < max) {
            if (!st.contains(i)) {
                ans.add(i);
            }
            i++;
        }
        return ans;
    }
}