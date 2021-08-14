package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddEvenTest {

  @Test
  public void oddEvenMod() {
    OddEven oddEven = new OddEven();
    assertEquals("even", oddEven.oddEvenMod(0));
    assertEquals("odd", oddEven.oddEvenMod(111));
    assertEquals("even", oddEven.oddEvenMod(888));
  }

  @Test
  public void oddEvenBit() {
    OddEven oddEven = new OddEven();
    assertEquals("even", oddEven.oddEvenBit(0));
    assertEquals("odd", oddEven.oddEvenBit(111));
    assertEquals("even", oddEven.oddEvenBit(888));
  }
}
