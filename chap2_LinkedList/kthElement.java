public class kthElement{

  // Here we used a recursively solution to this problem
  // This way we could not get the node it self
  static int reverseK = 0;

  public static int kthE(LinkedListNode n, int k){
    // Base case
    if (n == null){
      return 0;
    }

    int order = kthE(n.next,k) + 1;
    if (order == k){
      System.out.println(n.data);
    }
    return order;
  }


  // Way to get node
  // Way 1 use static variable

  public static LinkedListNode kthNode(LinkedListNode n, int k){
    if(n == null){
      return null;
    }
    // Once we found the correct result the result will be a correct one and stay unchange.
    LinkedListNode result = kthNode(n.next,k);
    reverseK += 1;
    if(reverseK == k){
      return n;
    }
    return result;
  }

  // Iterative way is awesome, this is my solution ugly.
  public static LinkedListNode kthIterative(LinkedListNode n, int k){
    // First we should find the fast pointer
    LinkedListNode fast = n;
    int kCount = k;
    while(fast != null && kCount >1){
      fast = fast.next;
      kCount--;
    }

    if(fast == null){
      return null;
    }

    LinkedListNode slow = n;
    fast = fast.next;
    while(fast != null){
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }


  // Answer's solution
  public static LinkedListNode kthIterative(LinkedListNode n, int k){
    /* Pay Attention to all kinds of corner conditions.
    *  a -> b -> c -> d -> null
    *  ^         ^
    *  |         |
    * slow      fast
    * when we first get fast k th element from head, we should notice that the iteration time to get fast, because the initial check already add 1 check time.
    * when we loops through we should also consider that the check should fast.next first. otherwise the effect location difference between fast and slow could be 1 more less.
    *
    */
    if(k <= 0) return null;
    // First we should find the fast pointer
    LinkedListNode fast = n;
    LinkedListNode slow = n;
    int kCount = k;
    while(fast != null && kCount >1){
      fast = fast.next;
      kCount--;
    }

    if(fast == null){
      return null;
    }

    // we could check one more ahead at here
    while(fast.next != null){
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
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
    System.out.println(kthNode(n,5).data);
    System.out.println(kthIterative(n,5).data);
  }
}
