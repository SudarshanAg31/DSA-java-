class Solution {
    public int numOfSubarrays(int[] arr) {
        long even = 1;
        long odd = 0;
        int M = 1_000_000_007;
        int prfx = 0;
        for (int i = 0; i < arr.length; i++) {
            prfx += arr[i];
            if (prfx % 2 == 0)
                even++;
            else
                odd++;
        }
        return (int) ((long) (even * odd) % M);
    }
}