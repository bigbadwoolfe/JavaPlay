package util;

public class LinkedListNode {
  LinkedListNode next = null;
  int data;
  
  public LinkedListNode(int d) {
    this.data = d;
  }
  
  public void appendToTail(int d) {
    LinkedListNode tail = new LinkedListNode(d);
    
    LinkedListNode n = this;
    
    while (n.next != null) {
      n = n.next;
    }
    n.next = tail;
  }
  
  public LinkedListNode appendToHead(int d) {
    LinkedListNode newHead = new LinkedListNode(d);
    newHead.next = this;
    return newHead;
  } 
  
  public void printYourself() {
    LinkedListNode n = this;
    
  }
  
}