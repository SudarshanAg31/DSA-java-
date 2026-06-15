class ans implements Comparable<ans>{
    int diff;
    int val;
    ans(int diff,int val){
        this.diff=diff;
        this.val=val;
    }
    public int compareTo(ans a){
        if(this.diff==a.diff) return this.val-a.val;
        return Integer.compare(this.diff,a.diff);
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     PriorityQueue<ans>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(new ans(Math.abs(arr[i]-x),arr[i]));
            if(pq.size()>k){
                pq.remove();
            }
        }
        List<Integer>final_ans=new ArrayList<>();
        while(pq.size()!=0){
            ans top=pq.remove();
            final_ans.add(top.val);
        }
        Collections.sort(final_ans);
        return final_ans;
    }
}