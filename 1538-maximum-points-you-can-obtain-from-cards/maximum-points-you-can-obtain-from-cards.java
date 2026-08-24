class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int s = 0;
        int e = cardPoints.length - 1;
        int sum_l = 0;
        int sum_r = 0;
        for (int i = 0; i < k; i++) {
            sum_l += cardPoints[i];
        }
        int max = sum_l;
        while (k != 0) {
            sum_l -= cardPoints[k - 1];
            sum_r += cardPoints[e];
            max = Math.max(max, sum_r + sum_l);
            k--;
            e--;
        }
        return max;
    }
}