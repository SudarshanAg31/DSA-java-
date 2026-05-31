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
                TreeNode curr=root.left;
                TreeNode p=curr.left;
                while(p.right!=null){
                    p=p.right;
                }
                delete(root,p.val);
                p.left=curr.left;
                p.right=curr.right;
                root.left=p;
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
                TreeNode curr=root.right;
                TreeNode p=curr.left;
                while(p.right!=null){
                    p=p.right;
                }
                delete(root,p.val);
                p.left=curr.left;
                p.right=curr.right;
                root.right=p;
            }
            //for 1 child
            else if (root.right != null && root.right.val == val) {
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