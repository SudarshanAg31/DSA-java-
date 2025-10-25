class Solution {
    public int findUnsortedSubarray(int[] arr) {
            if (arr == null || arr.length < 2) {
            return 0;
        }

        int n = arr.length;
        int max = arr[0];
        int min = arr[n - 1];
        int end = -1;
        int start = -1;

        // Step 1: Find the right boundary (end)
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (arr[i] < max) {
                end = i;
            }
        }

        if (end == -1) {
            return 0; // already sorted
        }

        // Step 2: Find the left boundary (start)
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            if (arr[i] > min) {
                start = i;
            }
        }

        return end - start + 1; 
    }
}