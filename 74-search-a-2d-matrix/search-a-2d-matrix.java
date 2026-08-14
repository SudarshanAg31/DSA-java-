class Solution {
    public boolean searchMatrix(int[][] mtx, int target) {
        int s = 0;
        int e = mtx.length * mtx[0].length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int row = mid / mtx[0].length;
            int col = mid % mtx[0].length;
            if (mtx[row][col] == target)
                return true;
            if (mtx[row][col] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}