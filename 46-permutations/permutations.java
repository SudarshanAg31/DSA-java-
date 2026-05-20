class Solution {
    public void fun(int[] nums, List<Integer> ds, boolean[] check, List<List<Integer>> ans) {
        if (nums.length == ds.size()) {
            List<Integer> list = new ArrayList<>();
            for (Integer i : ds) list.add(i);
            ans.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                ds.add(nums[i]);
                check[i] = true;
                fun(nums, ds, check, ans);
                check[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] check = new boolean[nums.length];
        fun(nums, ds, check, ans);
        return ans;
    }
}