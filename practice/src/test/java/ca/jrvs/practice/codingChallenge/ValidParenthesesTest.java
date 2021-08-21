package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidParenthesesTest {

  @Test
  public void isValid() {
    ValidParentheses validParentheses = new ValidParentheses();
    assertTrue(validParentheses.isValid("()"));
    assertTrue(validParentheses.isValid("()[]{}"));
    assertFalse(validParentheses.isValid("(]"));
    assertFalse(validParentheses.isValid("([)]"));
    assertTrue(validParentheses.isValid("{[]}"));
  }
}
