
public class RemoveDuplicate{
  public static void main(String[] args){
    System.out.println("Hi");
    LinkedListNode n = new LinkedListNode();
    n.data = 6;

    LinkedListNode n1 = new LinkedListNode();
    n1.data = 10;

    n.setNext(n1);

    System.out.println(n.printForward());
  }
}
