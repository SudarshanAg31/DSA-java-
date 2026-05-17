class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty()&&ch=='#') st.pop();
            else if (ch!='#') st.push(ch);
        }        
        Stack<Character>st2=new Stack<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!st2.isEmpty()&&ch=='#') st2.pop();
            else if(ch!='#') st2.push(ch);
        }       
        return st.equals(st2); 
    }
}