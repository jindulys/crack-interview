public class TreeNode {
  public int data;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;

  private int size = 0;

  public TreeNode(int d) {
    data = d;
    size = 1;
  }

  public void setLeftChild(TreeNode left) {
    this.left = left;
    if (left != null) left.parent = this;
  }

  public void setRightChild(TreeNode right) {
    this.right = right;
    if (right != null) right.parent = this;
  }

  public void insertInOrder(int d) {
    if (d <= data) {
      if ( left == null) setLeftChild(new TreeNode(d));
      else {
        left.insertInOrder(d);
      }
    } else {
      if (right == null) setRightChild(new TreeNode(d));
      else {
        right.insertInOrder(d);
      }
    }

    size++;
  }

  public int size() {
    return size;
  }

  public boolean isBST() {
    if ( left != null ){
      if (data < left.data || !left.isBST()){
        return false;
      }
    }

    if ( right != null ) {
      if (data >= right.data || !right.isBST()) {
        return false;
      }
    }

    return true;
  }


  public int height() {
    int leftHeight = left != null? left.height():0;
    int rightHeight = right != null? right.height():0;
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public TreeNode find(int d) {
    if (d == data) {
      return this;
    } else if (d < data) {
      return left != null? left.find(d) : null;
    } else {
      return right != null ? right.find(d) : null;
    }
  }

  private static TreeNode createMinimalBST(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(arr[mid]);
    n.setLeftChild(createMinimalBST(arr, start, mid - 1));
    n.setRightChild(createMinimalBST(arr, mid + 1, end));
    n.size = end - start + 1;
    return n;
  }

  public static TreeNode createMinimalBST(int[] arr) {
    return createMinimalBST(arr, 0, arr.length-1);
  }

  public static String inorderString(TreeNode t) {
      if (t == null) return "0";
      String result = "";
      if (t.left != null) {
          result += inorderString(t.left);
      }
      result += t.data;
      if (t.right != null) {
          result += inorderString(t.right);
      }
      return result;
  }

  public void print() {
    BTreePrinter.printNode(this);
  }

  public static void main (String[] args) {
    System.out.println("Hello World!");
    System.out.println((4+5)/2);
  }
}
