class Solution {
    public boolean stoneGameIX(int[] arr) {
        int[] count = new int[3];
        for (int i : arr) {
            count[i % 3]++;
        }
        int a = count[1];
        int b = count[2];
        int c = count[0];
        if (c % 2 == 0)
            return a > 0 && b > 0;
        return Math.abs(a - b) > 2;
    }
}