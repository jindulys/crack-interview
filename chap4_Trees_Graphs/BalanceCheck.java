import java.util.Random;

public class BalanceCheck {

  private static int treeHeight(TreeNode n) {
    if (n == null) return 0;
    return Math.max(treeHeight(n.left), treeHeight(n.right)) + 1;
  }

  private static boolean isBalance(TreeNode n) {
    if (n == null) return true;
    if (isBalance(n.left) && isBalance(n.right)) {
      int Lheight = treeHeight(n.left);
      int Rheight = treeHeight(n.right);
      if (Math.abs(Lheight - Rheight) > 1) {
        return false;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  // This is the improved version, which will return -1 if the subtree is not balanced or the actual height
  private static int improvedTreeHeight(TreeNode n) {
    // Base case
    if (n == null) return 0;

    int Lh = improvedTreeHeight(n.left);
    if (Lh == -1) return -1;

    int Rh = improvedTreeHeight(n.right);
    if (Rh == -1) return -1;

    if (Math.abs(Lh - Rh) > 1) {
      return -1;
    } else {
      return Math.max(Lh, Rh) + 1;
    }
  }

  private static boolean improvedBalanced(TreeNode n) {
    if (improvedTreeHeight(n) == -1) {
      return false;
    } else {
      return true;
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    System.out.println("Root? " + root.data);
    root.print();

    System.out.println("Balanced? " + isBalance(root));

    TreeNode unbalanced = new TreeNode(10);
    for(int i = 0; i < 10; i++){
      unbalanced.insertInOrder(new Random().nextInt(100));
    }
    unbalanced.print();

    System.out.println("Balanced? " + improvedBalanced(unbalanced));
  }
}
