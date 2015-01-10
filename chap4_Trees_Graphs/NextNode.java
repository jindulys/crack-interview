public class NextNode {

    private static TreeNode findNext(TreeNode t) {
        if (t == null) return null;
        if (t.right != null) {
            return leftMost(t.right);
        }

        // If t.right == null, we need to find the next unexplored parent
        TreeNode p = t.parent;
        TreeNode c = t;
        while (p != null && p.right == c) {
            c = p;
            p = p.parent;
        }
        return p;
    }

    private static TreeNode leftMost(TreeNode t) {
        // I am sure t will not be null
        TreeNode n = t;
        while(n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        TreeNode t = TreeNode.createMinimalBST(arr);
        t.print();

        TreeNode target = t.left.right.right;
        target.print();
        System.out.println(findNext(target).data);
    }
}
