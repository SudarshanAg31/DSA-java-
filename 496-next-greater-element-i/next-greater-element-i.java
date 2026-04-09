class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            mp.put(nums1[i], i);
        }
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[st.peek()] <= nums2[i]) {
                st.pop();
            }
            if (mp.containsKey(nums2[i])) {
                if (st.size() == 0) {
                    ans[mp.get(nums2[i])] = -1;
                } else {
                    ans[mp.get(nums2[i])] = nums2[st.peek()];
                }
            }
            st.push(i);
        }
        return ans;
    }
}