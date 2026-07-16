class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stp = 0;
        int curr = startFuel;
        //on the base of fuel
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stations.length; i++) {
            int nxt_stop = stations[i][0];
            int fuel_stat = stations[i][1];
            while (curr < nxt_stop) {
                if (q.isEmpty()) {
                    return -1;
                }
                int max_fuel = q.remove();
                curr += max_fuel;
                stp++;
            }
            q.add(fuel_stat);
        }
        while (curr < target) {
            if (q.isEmpty()) {
                return -1;
            }
            int max_fuel = q.remove();
            curr += max_fuel;
            stp++;
        }
        return stp;
    }
}