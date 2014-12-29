public class LinkedListNode{
  /* Before : no public access control
  *  After  : has public access control
  *  Reason : Our client need this fields for convenience
  */
  public int data;
  public LinkedListNode next;
  public LinkedListNode pre;

  // Constructor
  public LinkedListNode(int data, LinkedListNode n, LinkedListNode p){
    data = data;
    setNext(n);
    setPre(p);
  }

  public LinkedListNode() {}

  public void setNext(LinkedListNode n){
    next = n;
    if(n != null && n.pre != this){
      n.setPre(this);
    }
  }

  public void setPre(LinkedListNode p){
    pre = p;
    if (p != null && p.next != this){
      p.setNext(this);
    }
  }

  public LinkedListNode add(int data){
    LinkedListNode node = new LinkedListNode();
    node.data = data;
    LinkedListNode current = this;
    while(current.next != null){
      current = current.next;
    }
    current.setNext(node);
    return node;
  }

  public String printForward(){
    if(next != null){
      return data + "->" + next.printForward();
    } else {
      return String.valueOf(data);
    }
  }


  public LinkedListNode clone(){
    LinkedListNode nextNode = null;
    if(next != null) {
      nextNode = next.clone();
    }
    return new LinkedListNode(data,nextNode,null);
  }
}
