class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            boolean x_check = false;
            boolean y_check = false;
            for (int i = 0; i < size; i++) {
                TreeNode temp = qu.poll();
                if (temp.val == x)
                    x_check = true;
                if (temp.val == y)
                    y_check = true;
                if (temp.left != null && temp.right != null) {
                    if (temp.left.val == x && temp.right.val == y || temp.left.val == y && temp.right.val == x) {
                        return false;
                    }
                }
                if (temp.left != null) {
                    qu.add(temp.left);
                }
                if (temp.right != null) {
                    qu.add(temp.right);
                }
            }
            if (x_check && y_check)
                return true;
            else if ((x_check && !y_check) || (!x_check && y_check))
                return false;
        }
        return false;
    }
}