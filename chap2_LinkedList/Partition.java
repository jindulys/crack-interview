public class Partition{

  // Here I use an additionall append method of LinkedList which will make time efficiency bad. O(n^2)
  public static LinkedListNode partition(LinkedListNode n, int key){
    if (n == null) return null;
    LinkedListNode less = null;
    LinkedListNode greater = null;

    while(n != null){
      LinkedListNode toProcess = n.next;
      n.next = null;
      if (n.data < key){
        // put this node in less LinkedList
        if (less == null){
          less = n;
        } else {
          less.append(n);
        }
      } else {
        // put this node in greater LinkedList
        if (greater == null){
          greater = n;
        } else {
          greater.append(n);
        }
      }
      n = toProcess;
    }

    less.append(greater);
    return less;
  }

  // Answer's solution improvement is caused by additional rearrengement, we could insert element at the beginning. Awesome.
  public static LinkedListNode reversePartition(LinkedListNode n, int key){
    LinkedListNode beforeStart = null;
    LinkedListNode afterStart = null;

    while(n != null){
      LinkedListNode toProcessed = n.next;
      if (n.data < key){
        n.next = beforeStart;
        beforeStart = n;
      } else {
        n.next = afterStart;
        afterStart = n;
      }
      n = toProcessed;
    }

    if (beforeStart == null) {
      return afterStart;
    }

    LinkedListNode beforeLast = beforeStart;
    while(beforeLast.next != null){
      beforeLast = beforeLast.next;
    }
    beforeLast.next = afterStart;
    return beforeStart;
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
    LinkedListNode result = reversePartition(n,100);
    System.out.println(result.printForward());
  }
}
