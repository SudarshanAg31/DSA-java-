class RecentCounter {
    Queue<Integer>qu=new LinkedList<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        int low=t-3000;
        while(!qu.isEmpty()&&low>qu.peek())qu.remove();
        qu.add(t);
        return qu.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */