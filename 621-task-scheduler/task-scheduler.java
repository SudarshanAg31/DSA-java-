class Solution {
    class custom implements Comparable<custom>{
        char ch;
        int feq;
        custom(char ch,int feq){
            this.ch=ch;
            this.feq=feq;
        }
        public int compareTo(custom a){
            return Integer.compare(this.feq,a.feq);
        }
    }
    public int leastInterval(char[] task, int n) {
        PriorityQueue<custom>q1=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<custom>q2=new PriorityQueue<>(Collections.reverseOrder());
        Map<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<task.length;i++){
            if(!mp.containsKey(task[i])){
                mp.put(task[i],1);
            }
            else{
                mp.put(task[i],mp.get(task[i])+1);
            }
        }
        for(char ele:mp.keySet()){
            q1.add(new custom(ele,mp.get(ele)));
        }
        int ans=0;
        n=n+1;
        while(!q1.isEmpty()||!q2.isEmpty()){
            int temp_n=n;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    if(temp_n>0){
                    custom temp=q1.remove();
                    char c=temp.ch;
                    int no=temp.feq-1;
                    if(no!=0){
                        q2.add(new custom(c,no));
                    }
                    ans++;
                    }
                    else{
                        q2.add(q1.remove());
                    }
                    temp_n-=1;
                }
            }
            else{
                while(!q2.isEmpty()){
                    if(temp_n>0){
                    custom temp=q2.remove();
                    char c=temp.ch;
                    int no=temp.feq-1;
                    if(no!=0){
                        q1.add(new custom(c,no));
                    }
                    ans++;
                    }
                    else{
                        q1.add(q2.remove());
                    }
                    temp_n-=1;
                }
            }
            if((q1.size()!=0||q2.size()!=0)&&temp_n>0){
                ans+=temp_n;
            }
        }
        return ans;
    }
}