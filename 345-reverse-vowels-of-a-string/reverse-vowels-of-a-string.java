class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||ch[i]=='A'||ch[i]=='E'||ch[i]=='O'||ch[i]=='U'||ch[i]=='I'){
                st.push(ch[i]);
            }
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'||ch[i]=='A'||ch[i]=='E'||ch[i]=='O'||ch[i]=='U'||ch[i]=='I'){
                ch[i]=st.pop();
            }
        }
        String ans=new String(ch);
        return ans;
    }
}