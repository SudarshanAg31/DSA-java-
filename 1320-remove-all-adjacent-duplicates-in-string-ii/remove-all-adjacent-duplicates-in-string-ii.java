class Solution {
    class node {
        char data;
        int feq;

        node(char data, int feq) {
            this.data = data;
            this.feq = feq;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<node> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek().data == ch) {
                node temp = st.pop();
                temp.feq += 1;
                st.push(temp);
            } else {
                st.push(new node(ch, 1));
            }
            if (!st.isEmpty() && st.peek().feq == k) {
                st.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            node temp = st.pop();
            int freq = temp.feq;
            while (freq != 0) {
                str.append(temp.data);
                freq--;
            }
        }
        return str.reverse().toString();
    }
}