package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import ca.jrvs.practice.codingChallenge.StackUsingQueue.OneQueue;
import ca.jrvs.practice.codingChallenge.StackUsingQueue.TwoQueues;
import org.junit.Test;

public class StackUsingQueueTest {

  @Test
  public void TwoQueues() {
    TwoQueues twoQueues = new TwoQueues();
    twoQueues.push(1);
    twoQueues.push(2);
    assertEquals(2, twoQueues.top());
    assertEquals(2, twoQueues.pop());
    assertFalse(twoQueues.empty());
  }

  @Test
  public void OneQueue() {
    OneQueue oneQueue = new OneQueue();
    oneQueue.push(1);
    oneQueue.push(2);
    assertEquals(2, oneQueue.top());
    assertEquals(2, oneQueue.pop());
    assertFalse(oneQueue.empty());
  }
}
