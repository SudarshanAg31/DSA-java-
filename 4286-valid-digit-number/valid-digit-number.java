class Solution {
    public boolean validDigit(int n, int x) {
        int temp = n;
        while (temp >= 10) {
            temp /= 10;
        }
        if (temp == x) return false;

        // Step 2: Check if digit x exists
        while (n > 0) {
            int digit = n % 10;
            if (digit == x) {
                return true;
            }
            n /= 10;
        }

        return false;
    }
}