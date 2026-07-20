class Solution {
    public int[][] insert(int[][] itv, int[] newItv) {
        List<int[]> arr = new ArrayList<>();
        int i = 0;
        // Add
        while (i < itv.length && itv[i][1] < newItv[0]) {
            arr.add(itv[i]);
            i++;
        }
        // Merge
        while (i < itv.length && newItv[1] >= itv[i][0]) {
            newItv[0] = Math.min(newItv[0], itv[i][0]);
            newItv[1] = Math.max(newItv[1], itv[i][1]);
            i++;
        }
        arr.add(newItv);
        // Add
        while (i < itv.length) {
            arr.add(itv[i]);
            i++;
        }
        return arr.toArray(new int[arr.size()][]);
    }
}