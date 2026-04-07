class Solution {
    public int maxDepth(String s) {
        int size=0;
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')st.push('(');
            else if(ch==')')st.pop();
            if(size<st.size()){
                size=st.size();
            }
        }
        return size;
    }
}