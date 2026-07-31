class Solution {
    class custom implements Comparable<custom> {
        char ch;
        int feq;

        custom(char ch, int feq) {
            this.ch = ch;
            this.feq = feq;
        }

        public int compareTo(custom a) {
            return Integer.compare(this.feq, a.feq);
        }
    }

    public int minimumPushes(String word) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }
        }
        PriorityQueue<custom> q = new PriorityQueue<>(Collections.reverseOrder());
        for (char i : mp.keySet()) {
            q.add(new custom(i, mp.get(i)));
        }
        int count = 1;
        int mul = 1;
        int sum = 0;
        while (!q.isEmpty()) {
            custom temp = q.remove();
            int feq = temp.feq;
            sum += (feq * mul);
            if (count == 8) {
                mul++;
                count = 1;
            } else
                count++;
        }
        return sum;
    }
}