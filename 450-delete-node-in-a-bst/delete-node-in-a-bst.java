class Solution {
    public void delete(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val > val) {
            //for 0 child
            if (root.left != null && root.left.val == val && root.left.left == null && root.left.right == null) {
                root.left = null;
            }
            //for 2 child
            else if (root.left != null && root.left.val == val && root.left.left != null && root.left.right != null) {
                TreeNode curr = root.left;
                TreeNode temp = curr.left;
                TreeNode parent = curr;
                while (temp.right != null) {
                    parent = temp;
                    temp = temp.right;
                }
                curr.val = temp.val;
                if (parent == curr)
                    parent.left = temp.left;
                else
                    parent.right = temp.left;
            }
            //for 1 child
            else if (root.left != null && root.left.val == val) {
                if (root.left.left != null && root.left.right == null) {
                    root.left = root.left.left;
                } else
                    root.left = root.left.right;
            } else
                delete(root.left, val);
        } else if (root.val < val) {
            //for 0 child
            if (root.right != null && root.right.val == val && root.right.left == null && root.right.right == null) {
                root.right = null;
                return;
            }
            // for 2 child
            else if (root.right != null && root.right.val == val && root.right.left != null
                    && root.right.right != null) {
                TreeNode curr = root.right;
                TreeNode temp = curr.right;
                TreeNode parent = curr;
                while (temp.left != null) {
                    parent = temp;
                    temp = temp.left;
                }
                curr.val = temp.val;
                if (parent == curr)
                    parent.right = temp.right;
                else
                    parent.left = temp.right;
            } else if (root.right != null && root.right.val == val) {
                if (root.right.left != null && root.right.right == null) {
                    root.right = root.right.left;
                } else
                    root.right = root.right.right;
            } else
                delete(root.right, val);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode temp = new TreeNode(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp, key);
        return temp.left;
    }
}