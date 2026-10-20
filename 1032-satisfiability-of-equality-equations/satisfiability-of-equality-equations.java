class dsu {
    int[] rank;
    char[] parent;

    dsu() {
        rank = new int[26];
        parent = new char[26];
        for (char i = 'a'; i <= 'z'; i++) {
            parent[i - 'a'] = i;
        }
    }

    public char find(char a) {
        if (parent[a - 'a'] == a) {
            return parent[a - 'a'];
        }
        parent[a - 'a'] = find(parent[a - 'a']);
        return parent[a - 'a'];
    }

    public boolean union(char a, char b) {
        char root_a = find(a);
        char root_b = find(b);
        if (root_a == root_b)
            return false;
        if (rank[root_a - 'a'] < rank[root_b - 'a']) {
            parent[root_a - 'a'] = root_b;
        } else if (rank[root_a - 'a'] > rank[root_b - 'a']) {
            parent[root_b - 'a'] = root_a;
        } else {
            parent[root_b - 'a'] = root_a;
            rank[root_a - 'a']++;
        }
        return true;
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        dsu d = new dsu();
        for (String i : equations) {
            if (i.charAt(1) == '=') {
                d.union(i.charAt(0), i.charAt(3));
            }
        }
        for (String i : equations) {
            if (i.charAt(1) == '!') {
                char a = d.find(i.charAt(0));
                char b = d.find(i.charAt(3));
                if (a == b)
                    return false;
            }
        }
        return true;
    }
}