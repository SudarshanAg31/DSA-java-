class Solution {
    public boolean searchMatrix(int[][] mtx, int target) {
        int i = 0;
        int j = mtx[0].length - 1;
        while (i < mtx.length && j >= 0) {
            if (mtx[i][j] == target)
                return true;
            if (mtx[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}