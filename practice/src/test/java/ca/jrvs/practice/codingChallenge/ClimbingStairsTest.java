package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClimbingStairsTest {

  @Test
  public void numOfWays() {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    assertEquals(1, climbingStairs.numOfWays(1));
    assertEquals(2, climbingStairs.numOfWays(2));
    assertEquals(3, climbingStairs.numOfWays(3));
    assertEquals(5, climbingStairs.numOfWays(4));
    assertEquals(8, climbingStairs.numOfWays(5));
  }

  @Test
  public void numOfWaysDP() {
    ClimbingStairs climbingStairs = new ClimbingStairs();
    assertEquals(1, climbingStairs.numOfWaysDP(1));
    assertEquals(2, climbingStairs.numOfWaysDP(2));
    assertEquals(3, climbingStairs.numOfWaysDP(3));
    assertEquals(5, climbingStairs.numOfWaysDP(4));
    assertEquals(8, climbingStairs.numOfWaysDP(5));
  }
}
