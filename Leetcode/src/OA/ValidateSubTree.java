package OA;


class ValidateSubTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (preorder(s, t)) return true;
        return (preorder(s.left, t) || preorder(s.right, t));
    }

    private boolean preorder(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return (s.val == t.val && (preorder(s.left, t.left) && preorder(s.right, t.right)));
    }


}
