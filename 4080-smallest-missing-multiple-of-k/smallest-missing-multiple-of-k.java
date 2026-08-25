class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int i : nums) {
            st.add(i);
        }
        int i = 1;
        int ans = 0;
        while (i <= 101) {
            ans = k * i;
            if (!st.contains(ans)) {
                return ans;
            }
            i++;
        }
        return 0;
    }
}