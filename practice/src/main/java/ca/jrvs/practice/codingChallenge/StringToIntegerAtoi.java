package ca.jrvs.practice.codingChallenge;

public class StringToIntegerAtoi {

  /**
   * Big-O: O(n)
   * Justification: iterates through string once
   */
  public int myAtoi(String s) {
    if (s.length() == 0) {
      return 0;
    }
    s = s.trim();

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
      if (sum >= Integer.MAX_VALUE / 10) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      sum = 10 * sum + Integer.parseInt(String.valueOf(s.charAt(index)));
      index++;
    }

    return (int) (sign * sum);
  }

  /**
   * Big-O: O(n)
   * Justification: iterates through string once
   */
  public int myAtoiAscii(String s) {
    if (s.length() == 0) {
      return 0;
    }
    s = s.trim();

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
      if (sum >= Integer.MAX_VALUE / 10) {
        return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      sum = 10 * sum + (int) s.charAt(index) % 48;
      index++;
    }
    return (int) (sign * sum);
  }
}
