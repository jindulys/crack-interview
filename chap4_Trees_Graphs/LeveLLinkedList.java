import java.util.LinkedList;
import java.util.ArrayList;

public class LeveLLinkedList {

  // Recursive Version

  // Note: you should pay attention to whether return void or something, void is because you pass the reference and it will remember the change, recursion is amazing because of this.
  private static ArrayList<LinkedList<TreeNode>> RLevelLinkedList(TreeNode t) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
    RLevelLinkedList(t,result, 0);
    return result;
  }

  private static void RLevelLinkedList(TreeNode t, ArrayList<LinkedList<TreeNode>> result,int level) {
    // Notice the base case
    if (t == null) return;
    LinkedList<TreeNode> current = null;
    if (result.size() == level) {
      current = new LinkedList<TreeNode>();
      result.add(current);
    } else {
      current = result.get(level);
    }
    current.add(t);
    RLevelLinkedList(t.left, result, level+1);
    RLevelLinkedList(t.right, result, level+1);
  }


  // Breadth First Search
  private static ArrayList<LinkedList<TreeNode>> BFSLevelLinkedList(TreeNode t) {
    if (t == null) return null;
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>> ();
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    current.add(t);

    while(current.size() > 0) {
      LinkedList<TreeNode> parent = current;
      current = new LinkedList<TreeNode>();
      for(TreeNode p: parent) {
        if (p.left != null) {
          current.add(p.left);
        }

        if (p.right != null) {
          current.add(p.right);
        }
      }

      result.add(parent);
    }

    return result;
  }

  public static void main(String[] args){
    int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
    TreeNode t = TreeNode.createMinimalBST(array);


  }
}
