package ca.jrvs.practice.codingChallenge;

public class StringToIntegerAtoi {

  /**
   * Big-O: O(n)
   * Justification: iterates through string once
   */
  public int myAtoi(String s) {
    s = s.trim();
    if (s.length() == 0) {
      return 0;
    }

    int index = 0;

    int sign = 1;
    if (s.charAt(0) == '-') {
      sign = -1;
      index++;
    } else if (s.charAt(0) == '+') {
      index++;
    }

    long sum = 0;
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
      sum = 10 * sum + Integer.parseInt(String.valueOf(s.charAt(index)));
      if (sum > Integer.MAX_VALUE) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      index++;
    }

    return (int) (sign * sum);
  }

  /**
   * Big-O: O(n)
   * Justification: iterates through string once
   */
  public int myAtoiAscii(String s) {
    s = s.trim();
    if (s.length() == 0) {
      return 0;
    }

    int index = 0;

    int sign = 1;
    if (s.charAt(0) == '-') {
      sign = -1;
      index++;
    } else if (s.charAt(0) == '+') {
      index++;
    }

    long sum = 0;
    while (index < s.length() && (int) s.charAt(index) >= 48 && (int) s.charAt(index) <= 57) {
      sum = 10 * sum + (int) s.charAt(index) % 48;
      if (sum > Integer.MAX_VALUE) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      index++;
    }
    return (int) (sign * sum);
  }
}
