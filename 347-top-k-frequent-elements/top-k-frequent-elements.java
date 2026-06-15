class ans implements Comparable<ans> {
    int feq;
    int val;

    ans(int val, int feq) {
        this.feq = feq;
        this.val = val;
    }

    public int compareTo(ans a) {
        return Integer.compare(this.feq, a.feq);
    }
}

class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!mp.containsKey(arr[i]))
                mp.put(arr[i], 1);
            else
                mp.put(arr[i], mp.get(arr[i]) + 1);
        }
        PriorityQueue<ans> pq = new PriorityQueue<>();
        for (Integer key : mp.keySet()) {
            pq.add(new ans(key, mp.get(key)));
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int[] final_ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans top = pq.remove();
            final_ans[i] = top.val;
        }
        return final_ans;
    }
}