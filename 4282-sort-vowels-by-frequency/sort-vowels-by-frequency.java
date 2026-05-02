class Solution {
    public char vol(int a) {
        switch (a) {
            case 0:
                return 'a';
            case 1:
                return 'e';
            case 2:
                return 'i';
            case 3:
                return 'o';
            case 4:
                return 'u';
        }
        return 'z';
    }

    public String sortVowels(String s) {
        int[] ch = new int[5];
        int[] first = new int[5];
        for (int i = 0; i < 5; i++)
            first[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            int idx = -1;
            switch (chr) {
                case 'a':
                    ch[0]++;
                    idx = 0;
                    break;
                case 'e':
                    ch[1]++;
                    idx = 1;
                    break;
                case 'i':
                    ch[2]++;
                    idx = 2;
                    break;
                case 'o':
                    ch[3]++;
                    idx = 3;
                    break;
                case 'u':
                    ch[4]++;
                    idx = 4;
                    break;
            }
            if (idx != -1 && first[idx] == -1) {
                first[idx] = i;
            }
        }
        int[] order = { 0, 1, 2, 3, 4 };
        for (int i = 0; i < order.length; i++) {
            int max = i;
            for (int j = i + 1; j < order.length; j++) {
                if (ch[order[j]] > ch[order[max]] ||
                        (ch[order[j]] == ch[order[max]] &&
                                first[order[j]] < first[order[max]])) {
                    max = j;
                }
            }
            int temp = order[i];
            order[i] = order[max];
            order[max] = temp;
        }
        int a = 0;
        char[] word = s.toCharArray();
        for (int i = 0; i < word.length; i++) {
            char chr = word[i];
            if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u') {
                while (a < 5 && ch[order[a]] == 0) {
                    a++;
                }
                word[i] = vol(order[a]);
                ch[order[a]]--;
            }
        }
        return new String(word);
    }
}