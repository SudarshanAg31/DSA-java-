class Solution {
    public int minimumPushes(String word) {
        int x = word.length() / 8;
        if (x == 0)
            return word.length();
        x += 1;
        int sum = 0;
        int i;
        for (i = 1; i < x; i++) {
            sum += 8 * i;
        }
        i--;
        int temp = word.length() - (8 * i);
        i++;
        sum += temp * i;
        return sum;
    }
}