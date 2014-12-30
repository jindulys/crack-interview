public class SumUp{
  /* My Solution For backwards order
  *   Use Iteratived one, we could change it to recursive one.
  */
  public static LinkedListNode sumNodes(LinkedListNode node1, LinkedListNode node2){
    LinkedListNode result = null;
    LinkedListNode head1 = node1;
    LinkedListNode head2 = node2;

    int remain = 0;
    while(head1 != null && head2 != null){
      int data1 = head1.data;
      int data2 = head2.data;

      int s = data1 + data2 + remain;
      remain = s/10;
      s = s%10;
      if (result == null){
        result = new LinkedListNode();
        result.data = s;
      } else {
        result.add(s);
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    int data = 0;
    if (head1 == null && head2 == null){
      return result;
    } else {
      if (head1 == null) {
        data += head2.data;
      } else {
        data += head1.data;
      }
      data += remain;

      remain = data/10;
      data = data%10;
      result.add(data);
      if (remain != 0){
        result.add(remain);
      }
    }
    return result;
  }


  public static LinkedListNode ansSolutionRecursion(LinkedListNode n1, LinkedListNode n2, int hq){
    if (n1 == null && n2 == null && hq == 0){
      return null;
    }

    int data = hq;
    if (n1 != null){
      data += n1.data;
    }

    if (n2 != null){
      data += n2.data;
    }

    LinkedListNode result = new LinkedListNode();
    result.data = data%10;

    // ** Note Here - we should check n1 is whether null or not, not n1.next
    result.setNext(ansSolutionRecursion(n1 == null? null:n1.next, n2 == null? null: n2.next, data>=10?1:0));

    return result;
  }


  public static void main(String[] args){
    LinkedListNode n = new LinkedListNode();
    n.data = 7;
    n.add(1);
    n.add(6);
    n.add(8);

    LinkedListNode n1 = new LinkedListNode();
    n1.data = 5;
    n1.add(9);
    n1.add(2);


    System.out.println(n.printForward());
    LinkedListNode reversed = LinkedListNode.reverse(n);
    System.out.println(reversed.printForward());
    System.out.println(n.printForward());


    LinkedListNode result = ansSolutionRecursion(n, n1, 0);
    System.out.println(result.printForward());
  }
}
