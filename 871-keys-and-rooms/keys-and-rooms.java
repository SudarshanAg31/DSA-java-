class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n];
        check[0] = true;
        q.add(0);
        while (q.size() > 0) {
            int x = q.remove();
            for (int ele : rooms.get(x)) {
                if (!check[ele]) {
                    check[ele] = true;
                    q.add(ele);
                }
            }
        }
        for (boolean i : check)
            if (!i)
                return false;
        return true;
    }
}