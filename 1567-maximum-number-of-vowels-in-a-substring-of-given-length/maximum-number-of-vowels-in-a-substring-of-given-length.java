class Solution {
    public int maxVowels(String st, int k) {
        int s=0;
        char []ch=st.toCharArray();
        int count=0;
        int max=0;
        for(int i=0;i<k;i++){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='o'||ch[i]=='i'||ch[i]=='u'){
                count++;
            }
        }        
        max=Math.max(count,max);
        for(int i=k;i<st.length();i++){
            if(ch[s]=='a'||ch[s]=='e'||ch[s]=='i'||ch[s]=='o'||ch          [s]=='u'){
                count--;
            }
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='o'||ch[i]=='i'||ch           [i]=='u'){
                count++;
            }
            s++;
            max=Math.max(max,count);
            if(max==k)return k;
        }
        return max;
    }
}