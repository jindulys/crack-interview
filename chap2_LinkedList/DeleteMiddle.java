public class DeleteMiddle{

  public static boolean deleteNode(LinkedListNode n){
    // Could not delete empty node.
    if (n == null || n.next == null) return false;


    // Note: we only need to set the to be deleted node's next to next's next to fake the deletion, that is
    // the advantage of linkedlist.
    n.data = n.next.data;
    n.setNext(n.next.next);
    return true;
  }

  public static void main(String[] args){
    System.out.println("Hi");
    LinkedListNode n = new LinkedListNode();
    n.data = 6;

    n.add(10);
    n.add(10);
    n.add(20);
    n.add(1);
    LinkedListNode n1 = n.add(90);
    n.add(101);
    n.add(30);
    n.add(6);
    n.add(100010);

    System.out.println(n.printForward());
    deleteNode(n1);
    System.out.println(n.printForward());

  }
}
