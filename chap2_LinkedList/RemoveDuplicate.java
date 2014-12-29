import java.util.*;

public class RemoveDuplicate{

  // Use hashtable to act as an additional storage
  public static void removeDuplicate(LinkedListNode n){
    Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
    LinkedListNode previous = null;
    while(n != null){
      if(table.containsKey(n.data)){
        previous.setNext(n.next);
      } else {
        table.put(n.data, true);
        previous = n;
      }
      n = n.next;
    }
  }

  // Use no additional storage, then we need iterate two loops
  public static void removeDuplicateInPlace(LinkedListNode n){
    while(n != null){
      LinkedListNode toCheck = n.next;
      LinkedListNode previous = n;
      while (toCheck != null){
        if(toCheck.data == n.data){
          previous.setNext(toCheck.next);
        } else {
          previous = toCheck;
        }
        toCheck = toCheck.next;
      }
      n = n.next;
    }
  }

  // Use no additional storage, then we need iterate two loops
  public static void answerSolution(LinkedListNode n){
    if (n == null) return;

    while(n != null){
      LinkedListNode runner = n;
      // key point is to maintain runner.next is the appropriate element to be check.
      while (runner.next != null){
        if(runner.next.data == n.data){
          // move runner's next
          runner.setNext(runner.next.next);
        } else {
          // move runner itself
          runner = runner.next;
        }
      }
      n = n.next;
    }
  }

  public static void main(String[] args){
    System.out.println("Hi");
    LinkedListNode n = new LinkedListNode();
    n.data = 6;

    n.add(10);
    n.add(10);
    n.add(20);
    n.add(1);
    n.add(90);
    n.add(101);
    n.add(30);
    n.add(6);
    n.add(100010);

    System.out.println(n.printForward());
    answerSolution(n);
    System.out.println(n.printForward());
  }
}
