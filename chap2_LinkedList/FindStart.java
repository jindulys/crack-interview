public class FindStart{
  public static LinkedListNode findStart(LinkedListNode head){
    // First let a faster pointer with 2 steps meet with slower pointer with 1 step.
    // When they meet up, there will be k step ahead. k = (K mod loopSize)

    LinkedListNode fast = head;
    LinkedListNode slow = head;

    while (fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow){
        break;
      }
    }

    // Note: fast.next could be null if head only one node.
    if (fast == null || fast.next == null) {
      return null;
    }

    //After find the collision point we could move fast to head and then move until they met.
    fast = head;
    while (fast != slow){
      fast = fast.next;
      slow = slow.next;
    }
    
    return fast;
  }
}
