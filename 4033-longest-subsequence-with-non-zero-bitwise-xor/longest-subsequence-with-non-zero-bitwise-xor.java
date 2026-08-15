class Solution {
    public int longestSubsequence(int[] arr) {
        int xor = arr[0];
        int non_zero = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
            if (arr[i] != 0)
                non_zero = arr[i];
        }
        if (xor == 0) {
            xor ^= non_zero;
            if (xor == 0)
                return 0;
            return arr.length - 1;
        }
        return arr.length;
    }
}