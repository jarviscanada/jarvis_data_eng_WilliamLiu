package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import ca.jrvs.practice.codingChallenge.QueueUsingStack.TwoStacks;
import ca.jrvs.practice.codingChallenge.QueueUsingStack.TwoStacksAmortized;
import org.junit.Test;

public class QueueUsingStackTest {

  @Test
  public void TwoStacks() {
    TwoStacks twoStacks = new TwoStacks();
    twoStacks.push(1);
    twoStacks.push(2);
    assertEquals(1, twoStacks.peek());
    assertEquals(1, twoStacks.pop());
    assertFalse(twoStacks.empty());
  }

  @Test
  public void TwoStacksAmortized() {
    TwoStacksAmortized twoStacksAmortized = new TwoStacksAmortized();
    twoStacksAmortized.push(1);
    twoStacksAmortized.push(2);
    assertEquals(1, twoStacksAmortized.peek());
    assertEquals(1, twoStacksAmortized.pop());
    assertFalse(twoStacksAmortized.empty());
  }
}
