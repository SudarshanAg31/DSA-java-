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
    public String reorganizeString(String s) {
        Map<Character,Integer>mp=new HashMap<>();
        PriorityQueue<custom>q1=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<custom>q2=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<s.length();i++){
            if(!mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),1);
            }
            else{
                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            }
        }
        for(char ele:mp.keySet()){
            q1.add(new custom(ele,mp.get(ele)));
        }
        boolean check=false;
        StringBuilder ans=new StringBuilder();
        while(q1.size()!=0||q2.size()!=0){
            int temp_n=2;
            if(!q1.isEmpty()){
                if(q1.size()==1){
                    custom temp=q1.peek();
                    if(temp.feq>=2){
                        check=true;
                        break;
                    }
                }
                while(!q1.isEmpty()){
                    if(temp_n>0){
                    custom temp=q1.remove();
                    char ch=temp.ch;
                    ans.append(ch);
                    temp_n-=1;
                    int feq=temp.feq-1;
                    if(feq>0){
                        q2.add(new custom(ch,feq));
                    }
                    }
                    else{
                        q2.add(q1.remove());
                    }
                }
            }
            else{
                if(q2.size()==1){
                    custom temp=q2.peek();
                    if(temp.feq>=2){
                        check=true;
                        break;
                    }
                }
                while(!q2.isEmpty()){
                    if(temp_n>0){
                    custom temp=q2.remove();
                    char ch=temp.ch;
                    ans.append(ch);
                    temp_n-=1;
                    int feq=temp.feq-1;
                    if(feq>0){
                        q1.add(new custom(ch,feq));
                    }
                    }
                    else{
                        q1.add(q2.remove());
                    }
                }
            }
        }
        return check?"":ans.toString();
    }
}