class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (Integer x : set) {
                if (!mp.containsKey(x)) {
                    mp.put(x, 1);
                } else {
                    mp.put(x, mp.get(x) + 1);
                }
            }
        }

        int max = -1;

        for (Integer i : mp.keySet()) {
            if (mp.get(i) == 1) {
                max = Math.max(max, i);
            }
        }

        return max;
    }
}