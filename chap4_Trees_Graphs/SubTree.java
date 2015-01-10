public class SubTree {


    /*  Simple Solution:
    *   which iterate through all the nodes of the large treeNode
    *   time: O(nm)
    */

    public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // This is my solution which cause every iteration will check t2 == null, inefficent.
        if (t1 == null) return false;
        if (t2 == null) return true;

        return checkMatch(t1, t2)? true: checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private static boolean checkMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.data != t2.data) return false;
        return checkMatch(t1.left, t2.left) && checkMatch(t1.right, t2.right);
    }

    /*  Answer's Solution
    *   A little better than my solution
    *
    */
    public static boolean checkContain(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    private static boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) return false;
        if (t1.data == t2.data) {
            if (checkMatch(t1, t2)) return true;
        }
        return subTree(t1.left, t2) || subTree(t1.right, t2);
    }


    public static void main(String[] args) {

    }
}
