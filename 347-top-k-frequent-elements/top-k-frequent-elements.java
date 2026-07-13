class Solution {
    class custom implements Comparable<custom> {
        int i;
        int feq;

        custom(int i, int feq) {
            this.i = i;
            this.feq = feq;
        }

        public int compareTo(custom a) {
            return Integer.compare(this.feq, a.feq);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            if (!mp.containsKey(nums[i]))
                mp.put(nums[i], 1);
            else {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
            i++;
        }
        PriorityQueue<custom> q = new PriorityQueue<>();
        for (int ele : mp.keySet()) {
            q.add(new custom(ele, mp.get(ele)));
            if (q.size() > k) {
                q.remove();
            }
        }
        int[] ans = new int[k];
        i = 0;
        while (!q.isEmpty()) {
            custom temp = q.remove();
            ans[i] = temp.i;
            i++;
        }
        return ans;
    }
}