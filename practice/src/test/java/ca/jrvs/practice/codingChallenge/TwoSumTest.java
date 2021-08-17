package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class TwoSumTest {

  @Test
  public void twoSumBrute() {
    TwoSum twoSum = new TwoSum();
    int[] ex1 = new int[]{2, 7, 11, 15};
    assertArrayEquals(new int[]{1, 2}, twoSum.twoSumBrute(ex1, 18));
    int[] ex2 = new int[]{3, 2, 4};
    assertArrayEquals(new int[]{1, 2}, twoSum.twoSumBrute(ex2, 6));
    int[] ex3 = new int[]{3, 3};
    assertArrayEquals(new int[]{0, 1}, twoSum.twoSumBrute(ex3, 6));
    int[] ex4 = new int[]{1, 2, 3};
    assertArrayEquals(new int[]{0, 0}, twoSum.twoSumBrute(ex4, 7));
  }

  @Test
  public void twoSumSort() {
    TwoSum twoSum = new TwoSum();
    int[] ex1 = new int[]{2, 7, 11, 15};
    int[] result1 = twoSum.twoSumSort(ex1, 9);
    Arrays.sort(ex1);
    assertEquals(9, ex1[result1[0]] + ex1[result1[1]]);

    int[] ex2 = new int[]{3, 2, 4};
    int[] result2 = twoSum.twoSumSort(ex2, 6);
    Arrays.sort(ex2);
    assertEquals(6, ex2[result2[0]] + ex2[result2[1]]);

    int[] ex3 = new int[]{3, 3};
    int[] result3 = twoSum.twoSumSort(ex3, 6);
    Arrays.sort(ex3);
    assertEquals(6, ex3[result3[0]] + ex3[result3[1]]);

    int[] ex4 = new int[]{1, 2, 3};
    assertArrayEquals(new int[]{0, 0}, twoSum.twoSumSort(ex4, 7));
  }

  @Test
  public void twoSumMap() {
    TwoSum twoSum = new TwoSum();
    int[] ex1 = new int[]{2, 7, 11, 15};
    assertArrayEquals(new int[]{2, 3}, twoSum.twoSumMap(ex1, 26));
    int[] ex2 = new int[]{3, 2, 4};
    assertArrayEquals(new int[]{1, 2}, twoSum.twoSumMap(ex2, 6));
    int[] ex3 = new int[]{3, 3};
    assertArrayEquals(new int[]{0, 1}, twoSum.twoSumMap(ex3, 6));
    int[] ex4 = new int[]{1, 2, 3};
    assertArrayEquals(new int[]{0, 0}, twoSum.twoSumMap(ex4, 7));
  }
}
