class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>qu=new PriorityQueue<>(Collections.reverseOrder());
        for(Integer i:stones){
            qu.add(i);
        }
        while(qu.size()>1){
            int x=qu.remove();
            int y=qu.remove();
            if(x!=y) qu.add(x-y);
        }
        if(qu.isEmpty())return 0;
        else return qu.peek();
    }
}