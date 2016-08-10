package ch2;

import util.Question;
import util.LinkedListNode;
import java.util.Hashtable;
import java.util.Random;

public class RemoveDuplicates extends Question {
  
  public RemoveDuplicates() {
    super("2.1", "Remove duplicates from an unordered linked list");
  }

  public void run() {
    hello();

    int run = 1;

    while (run <= 10) {
      System.out.printf("Run: %d\n", run);
      Random rand = new Random();
      LinkedListNode test = LinkedListNode.generateRandomList(rand.nextInt(20) + 1, true);
      LinkedListNode test2 = test.clone();

      test.printYourself();
      test2.printYourself();
      removeDuplicates(test);
      removeDuplicatesNoBuffer(test2);
      test.printYourself();
      test2.printYourself();

      System.out.println("------------------");

      run++;
    }


    bye();
  }

  public void removeDuplicates(LinkedListNode n) {
    Hashtable hashtable = new Hashtable();
    LinkedListNode prev = null;
    while (n != null) {
      if (hashtable.containsKey(n.data)) {
        // n needs to be removed
        prev.next = n.next;
      } else {
        // n needs to be added to hashtable
        hashtable.put(n.data, n);
      }
      prev = n;
      n = n.next;
    }
  }

  public void removeDuplicatesNoBuffer(LinkedListNode n) {
    LinkedListNode stepper = n; // goes through list slowly
    LinkedListNode runner = null; // goes through list for every step
    LinkedListNode prevRunner = n;

    while (stepper != null) {
      if (stepper.next != null) {
        runner = stepper.next;
        while (runner != null) {
          if (prevRunner.data == runner.data) {
            prevRunner.next = runner.next;
          }
          prevRunner = runner;
          runner = runner.next;
        }
      }
      stepper = stepper.next;
    }

  }
}
