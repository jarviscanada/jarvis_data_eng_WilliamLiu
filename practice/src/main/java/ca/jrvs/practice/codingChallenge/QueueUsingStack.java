package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

public class QueueUsingStack {

  public static class TwoStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    public TwoStacks() {
    }

    /**
     * Big-O: O(n)
     * Justification: move all elements from one stack to another and back
     */
    public void push(int x) {
      if (s1.empty()) {
        front = x;
      }
      while (!s1.empty()) {
        s2.push(s1.pop());
      }
      s2.push(x);
      while (!s2.empty()) {
        s1.push(s2.pop());
      }
    }

    /**
     * Big-O: O(1)
     * Justification: pop stack
     */
    public int pop() {
      int popped = s1.pop();
      if (!s1.empty()) {
        front = s1.peek();
      }
      return popped;
    }

    /**
     * Big-O: O(1)
     * Justification: return variable
     */
    public int peek() {
      return front;
    }

    /**
     * Big-O: O(1)
     * Justification: check if stack is empty
     */
    public boolean empty() {
      return s1.empty();
    }
  }

  public static class TwoStacksAmortized {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    public TwoStacksAmortized() {
    }

    /**
     * Big-O: O(1)
     * Justification: push stack
     */
    public void push(int x) {
      if (s1.empty()) {
        front = x;
      }
      s1.push(x);
    }

    /**
     * Big-O: O(1)
     * Justification: pop stack
     */
    public int pop() {
      if (s2.empty()) {
        while (!s1.empty()) {
          s2.push(s1.pop());
        }
      }
      return s2.pop();
    }

    /**
     * Big-O: O(1)
     * Justification: peek stack
     */
    public int peek() {
      if (!s2.empty()) {
        return s2.peek();
      }
      return front;
    }

    /**
     * Big-O: O(1)
     * Justification: check if stacks are empty
     */
    public boolean empty() {
      return (s1.empty() && s2.empty());
    }
  }
}
