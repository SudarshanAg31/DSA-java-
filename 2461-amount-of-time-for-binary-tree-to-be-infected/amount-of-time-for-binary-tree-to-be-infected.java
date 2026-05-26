class Solution {
    public TreeNode find(TreeNode root, int start) {
        if (root == null)
            return null;
        if (root.val == start) {
            return root;
        }
        TreeNode left = find(root.left, start);
        TreeNode right = find(root.right, start);
        if (left == null)
            return right;
        else
            return left;
    }

    public void fun(TreeNode root, Map<TreeNode, TreeNode> p) {
        if (root == null)
            return;
        if (root.left != null)
            p.put(root.left, root);
        if (root.right != null)
            p.put(root.right, root);
        fun(root.left, p);
        fun(root.right, p);
    }

    public int amountOfTime(TreeNode root, int start) {
        TreeNode node = find(root, start);
        Map<TreeNode, TreeNode> p = new HashMap<>();
        fun(root, p);
        Map<TreeNode, Integer> v = new HashMap<>();
        v.put(node, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (q.size() > 0) {
            TreeNode temp = q.remove();
            int count = v.get(temp) + 1;
            if (temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, count);
            }
            if (temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, count);
            }
            if (p.containsKey(temp) && !v.containsKey(p.get(temp))) {
                q.add(p.get(temp));
                v.put(p.get(temp), count);
            }
        }
        int max = -1;
        for (int e : v.values()) {
            max = Math.max(max, e);
        }
        return max;
    }
}