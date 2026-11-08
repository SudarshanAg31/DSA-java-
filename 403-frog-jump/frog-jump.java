class Solution {
    HashMap<Integer, Integer> mp = new HashMap<>();

    public boolean fun(int[] stone, int curr, int pre, Boolean[][] dp) {
        if (curr == mp.size()) {
            return true;
        }
        if (dp[curr][pre] != null)
            return dp[curr][pre];
        boolean result = false;
        for (int next = pre - 1; next <= pre + 1; next++) {
            if (next > 0) {
                int val = stone[curr] + next;
                if (mp.containsKey(val)) {
                    result = result || fun(stone, mp.get(val), next, dp);
                }
            }
        }
        return dp[curr][pre] = result;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1)
            return false;
        Boolean[][] dp = new Boolean[stones.length + 1][stones.length + 1];
        for (int i = 1; i < stones.length; i++) {
            mp.put(stones[i], i);
        }
        return fun(stones, 1, 1, dp);
    }
}