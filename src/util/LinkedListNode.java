package util;

import java.util.Random;

public class LinkedListNode {
  public LinkedListNode next = null;
  public int data;
  
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

    StringBuffer sb = new StringBuffer();

    sb.append(String.format("%3d ->", n.data));

    while (n.next != null) {
      n = n.next;
      sb.append(String.format("%3d -> ", n.data));
    }
    System.out.println(sb.toString());
  }

  public static LinkedListNode generateRandomList(int numEl, boolean withDuplicates) {
    if (numEl < 1) {
      return null;
    }

    Random rand = new Random();

    LinkedListNode first = null;
    LinkedListNode current = null;
    int i = 1;
    while (i <= numEl) {

      if (i == 1) {
        first = new LinkedListNode(rand.nextInt(numEl * 10) + 1);
        current = first;
      } else {
        int val = rand.nextInt(numEl * 10) + 1;
        current.next = new LinkedListNode(val);
        current = current.next;
        if (withDuplicates) {
          if (i % (rand.nextInt(5) + 1) == 0) {
            current.next = new LinkedListNode(val);
            current = current.next;
          }
        }
      }
      i++;
    }
    return first;
  }

  public LinkedListNode clone() {
    LinkedListNode n = this;
    LinkedListNode clone = new LinkedListNode(this.data);

    while (n.next != null) {
      n = n.next;
      clone.appendToTail(n.data);
    }

    return clone;

  }
}