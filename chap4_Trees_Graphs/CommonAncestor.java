public class CommonAncestor {

    /*  This is one solution for this problem
    *   Time O(n) -> the covers 2n (both almost browse n nodes), then half branch 2n/2, then 2n/4,,,,,
    *   Space O(lgn)
    */

    // Check if the toCheck is a descendant of root
    private static boolean checkRoot(TreeNode root, TreeNode toCheck) {
        if (root == null) return false;
        if (root == toCheck) return true;
        return checkRoot(root.left, toCheck) || checkRoot(root.right, toCheck);
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode t1, TreeNode t2) {
        if (!checkRoot(root, t1) || !checkRoot(root, t2)) {
            return null;
        }
        return commonAncestorHelper(root, t1, t2);
    }

    private static TreeNode commonAncestorHelper(TreeNode root, TreeNode t1, TreeNode t2) {
        if (root == null) return null;
        if (root == t1 || root == t2) return root;
        boolean t1OnLeft = checkRoot(root.left, t1);
        boolean t2OnLeft = checkRoot(root.left, t2);

        // two nodes diverge at here
        if (t1OnLeft != t2OnLeft) return root;

        TreeNode branchRoot = t1OnLeft? root.left: root.right;
        return commonAncestorHelper(branchRoot, t1, t2);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        TreeNode t = TreeNode.createMinimalBST(arr);
        TreeNode t1 = t.left.right;
        TreeNode t2 = t.right.left;
        t.print();

        TreeNode commonAncestor = commonAncestor(t, t1, t2);
        System.out.println(commonAncestor.data);
    }
}
