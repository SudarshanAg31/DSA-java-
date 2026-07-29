class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        int temp = 0;
        int temp1 = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0)
                temp = start + (2 * i);
            else {
                temp1 = temp;
                temp = start + (2 * i);
                temp ^= temp1;
            }
        }
        return temp;
    }
}