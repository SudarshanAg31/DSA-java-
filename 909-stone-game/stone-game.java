class Solution {
    public int fun(int[] arr, int i, int j, int[][] check) {
        if (i > j) {
            return 0;
        }
        if (check[i][j] != 0)
            return check[i][j];
        int take_i = arr[i] + Math.min(fun(arr, i + 2, j, check), fun(arr, i + 1, j - 1, check));
        int take_j = arr[j] + Math.min(fun(arr, i, j - 2, check), fun(arr, i + 1, j - 1, check));
        return check[i][j] = Math.max(take_i, take_j);
    }

    public boolean stoneGame(int[] arr) {
        int[][] check = new int[501][501];
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return fun(arr, 0, arr.length - 1, check) > sum / 2;
    }
}