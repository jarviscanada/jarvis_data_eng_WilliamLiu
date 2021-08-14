package ca.jrvs.practice.codingChallenge;

public class ClimbingStairs {

  private int fibonacci(int i) {
    if (i == 0 || i == 1) {
      return i;
    } else {
      return fibonacci(i - 1) + fibonacci(i - 2);
    }
  }

  /**
   * Big-O: O(2^n) time, O(n) space
   * Justification: recursion tree has 2^n nodes and n height
   */
  public int numOfWays(int i) {
    return fibonacci(i + 1);
  }

  private int fibonacciDP(int i, int[] memo) {
    int result;
    if (memo[i] != 0) {
      return memo[i];
    } else {
      if (i == 0 || i == 1) {
        result = i;
      } else {
        result = fibonacciDP(i - 1, memo) + fibonacciDP(i - 2, memo);
      }
    }
    memo[i] = result;
    return result;
  }

  /**
   * Big-O: O(n) time, O(n) space
   * Justification: one array holding all number in the sequence
   */
  public int numOfWaysDP(int i) {
    return fibonacciDP(i + 1, new int[i + 2]);
  }
}
