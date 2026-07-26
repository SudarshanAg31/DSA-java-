class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int max_dif = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                int min = prices[i];
                max_dif = Math.max(max_dif, max - min);
            }
        }
        return max_dif;
    }
}