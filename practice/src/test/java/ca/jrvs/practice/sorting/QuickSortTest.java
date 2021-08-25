package ca.jrvs.practice.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class QuickSortTest {

  @Test
  public void quickSort() {
    QuickSort quickSort = new QuickSort();
    int[] arr = {-3, 43, -456, -54, 366, 564564, 2515};
    int[] expected = {-456, -54, -3, 43, 366, 2515, 564564};
    quickSort.quickSort(arr, 0, arr.length - 1);
    assertArrayEquals(expected, arr);
  }
}
