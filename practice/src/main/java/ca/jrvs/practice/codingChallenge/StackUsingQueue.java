package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

  public static class TwoQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public TwoQueues() {
    }

    /**
     * Big-O: O(1)
     * Justification: add item to list
     */
    public void push(int x) {
      q1.add(x);
      top = x;
    }

    /**
     * Big-O: O(n)
     * Justification: pop last item in q1
     */
    public int pop() {
      int size = q1.size();
      while (size > 1) {
        q2.add(q1.remove());
        size--;
      }
      top = q1.remove();
      Queue<Integer> tmp = q1;
      q1 = q2;
      q2 = tmp;

      return top;
    }

    /**
     * Big-O: O(1)
     * Justification: return variable
     */
    public int top() {
      return top;
    }

    /**
     * Big-O: O(1)
     * Justification: check if queues are empty
     */
    public boolean empty() {
      return (q1.size() == 0 && q2.size() == 0);
    }
  }

  public static class OneQueue {

    private Queue<Integer> q1 = new LinkedList<>();
    private int top;

    public OneQueue() {
    }

    /**
     * Big-O: O(1)
     * Justification: add item to list
     */
    public void push(int x) {
      q1.add(x);
      top = x;
    }

    /**
     * Big-O: O(n)
     * Justification: pop last item in list in place
     */
    public int pop() {
      int size = q1.size();
      while (size > 1) {
        q1.add(q1.remove());
        size--;
      }
      top = q1.remove();
      return top;
    }

    /**
     * Big-O: O(1)
     * Justification: return variable
     */
    public int top() {
      return top;
    }

    /**
     * Big-O: O(1)
     * Justification: check if queue is empty
     */
    public boolean empty() {
      return (q1.size() == 0);
    }
  }
}
