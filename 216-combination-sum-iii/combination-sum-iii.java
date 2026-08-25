class Solution {
    public void fun(int k, int target, Set<List<Integer>> temp_ans, List<Integer> res, int temp, int count, int i) {
        if (count == k && target == temp) {
            List<Integer> a = new ArrayList<>();
            for (int s : res)
                a.add(s);
            Collections.sort(a);
            temp_ans.add(a);
            return;
        }
        if (i == 10)
            return;
        if (count > k || temp > target)
            return;
        res.add(i);
        fun(k, target, temp_ans, res, temp + i, count + 1, i + 1);
        res.remove(res.size() - 1);
        fun(k, target, temp_ans, res, temp, count, i + 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> temp_ans = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        fun(k, n, temp_ans, res, 0, 0, 1);
        for (List<Integer> i : temp_ans) {
            ans.add(i);
        }
        return ans;
    }
}