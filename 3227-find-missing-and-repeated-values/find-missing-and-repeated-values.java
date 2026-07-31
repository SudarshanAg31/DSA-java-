class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> st = new HashSet<>();
        int sum = 0;
        int x = grid.length * grid.length;
        int[] arr = new int[2];
        int total = (x * (x + 1)) / 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!st.contains(grid[i][j])) {
                    st.add(grid[i][j]);
                    sum += grid[i][j];
                } else {
                    arr[0] = grid[i][j];
                }
            }
        }
        arr[1] = Math.abs(total - sum);
        return arr;
    }
}