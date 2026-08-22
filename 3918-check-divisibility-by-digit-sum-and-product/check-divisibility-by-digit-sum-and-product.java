class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int x = 0;
        int y = 1;
        while (temp != 0) {
            int a = temp % 10;
            x += a;
            y *= a;
            temp /= 10;
        }
        return n % (x + y) == 0 ? true : false;
    }
}