public class BSTCheck {


  // I am wrong, which could be wrong if a node's left'right > node
  private static boolean BSTCheck(TreeNode t) {
    if (t == null) return true;
    if (BSTCheck(t.left)) {
      if (t.left != null) {
        if (t.left.data > t.data) {
          return false;
        }
      }
    } else {
      return false;
    }


    if (BSTCheck(t.right)) {
      if (t.right != null) {
        if (t.right.data <= t.data) {
          return false;
        }
      }
    } else {
      return false;
    }

    return true;

  }

  // Correct Recursive Solution
  private static boolean AnsSTwo(TreeNode t) {
    return RCBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean RCBST(TreeNode t, int min_v, int max_v) {
    if (t == null) return true;
    if (t.data <= min_v || t.data > max_v) {
      return false;
    }
    if (!RCBST(t.left, min_v, t.data) || !RCBST(t.right, t.data, max_v)) {
      return false;
    }
    return true;
  }

  // Answer's solution
  private static int index = 0;
  private static void CheckBST(TreeNode t, int[] arr) {
    if (t == null) return;
    CheckBST(t.left, arr);
    arr[index] = t.data;
    index++;
    CheckBST(t.right, arr);
  }

  private static boolean AnsSOne(TreeNode t) {
    System.out.println("Tree's size :" + t.size());
    int[] arr = new int[t.size()];
    CheckBST(t, arr);
    for(int i=1; i<arr.length; i++) {
      if (arr[i-1] > arr[i] ) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    int[] array = new int[] {10,25,20,30};
    TreeNode bt = TreeNode.createMinimalBST(array);
    System.out.println(BSTCheck(bt));
    System.out.println(AnsSOne(bt));
  }
}
